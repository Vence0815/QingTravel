package com.vence.qingtravel.activity;

import android.app.Activity;
import android.app.Service;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.google.gson.Gson;
import com.vence.qingtravel.R;
import com.vence.qingtravel.adapter.CityListAdatapter;
import com.vence.qingtravel.adapter.HotCityListAdapter;
import com.vence.qingtravel.constent.Url;
import com.vence.qingtravel.demon.CityList;
import com.vence.qingtravel.service.LocationService;
import com.vence.qingtravel.utils.CityListSort;
import com.vence.qingtravel.utils.SearchALG;
import com.vence.qingtravel.view.NoScrollGridView;
import com.vence.qingtravel.volley.VolleyManager;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 城市列表的activity
 * <p/>
 * //带结果的回调，调用时使用带结果的启动即可，得到城市对应的编号
 * Intent intent = new Intent();
 * intent.putExtra("cityID", pEntity.getId());
 * context.setResult(1, intent);
 * context.finish();
 */
public class CityListActivity extends Activity {

    @ViewInject(R.id.lv_city)
    private ListView lv_city;

    @ViewInject(R.id.gv_citylist)
    private NoScrollGridView gv_citylist;

    @ViewInject(R.id.tv_head_location)
    private TextView tv_head_location;

    @ViewInject(R.id.tv_canner)
    private TextView tv_canner;//取消的按钮

    @ViewInject(R.id.et_search)
    private EditText et_search;

    @ViewInject(R.id.iv_back)
    private ImageView iv_back;

    @ViewInject(R.id.lv_city_search)
    private ListView lv_city_search;

    private View headView;
    private List<String> litters;
    private Map<String, List<CityList.PEntity>> maps;

    private LocationService locationService;
    public Vibrator mVibrator;
    private List<CityList.PEntity> pEntities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        x.view().inject(this);
        headView = View.inflate(this, R.layout.city_list_head, null);
        x.view().inject(this, headView);

        //定位相关
        locationService = new LocationService(getApplicationContext());
        mVibrator = (Vibrator) getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        locationService.start();// 定位SDK

        /**
         * 先从本地读取城市列表的数据。
         */
        String cityJson = getStringFromAssert("cityJson");
        if (!TextUtils.isEmpty(cityJson)) {
            handlerData(new Gson().fromJson(cityJson, CityList.class));
        }
        getDataFromServer();
        setListener();
    }


    /**
     * 设置各种监听
     */
    private void setListener() {
        iv_back.setOnClickListener(new View.OnClickListener() {//回退键
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_canner.setOnClickListener(new View.OnClickListener() {//取消按钮
            @Override
            public void onClick(View v) {
                et_search.setText(null);
                tv_canner.setVisibility(View.GONE);
                lv_city_search.setVisibility(View.GONE);
                lv_city.setVisibility(View.VISIBLE);
                isFirstAcy = true;
            }
        });

        et_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_canner.setVisibility(View.VISIBLE);
                lv_city.setVisibility(View.GONE);
                lv_city_search.setVisibility(View.VISIBLE);
                if (et_search.getText().toString().length() == 0) {
                    lv_city_search.setAdapter(new HotCityListAdapter(CityListActivity.this, pEntities, false));
                }

            }
        });

        et_search.addTextChangedListener(watcher);
    }

    private boolean isFirstAcy = true;
    List<CityList.PEntity> avable = new ArrayList<>();
    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            tv_canner.setVisibility(View.VISIBLE);
            lv_city.setVisibility(View.GONE);
            lv_city_search.setVisibility(View.VISIBLE);

            if (isFirstAcy) {
                for (int i = 0; i < pEntities.size(); i++) {
                    if (s != null && !s.equals("") && s.length() > 0 && SearchALG.isAddToHintList(pEntities.get(i).getN(), s.toString())) {
                        avable.add(pEntities.get(i));
                    }
                }
                lv_city_search.setAdapter(new HotCityListAdapter(CityListActivity.this, avable, false));
                isFirstAcy = false;
            } else {
                List<CityList.PEntity> avable1 = new ArrayList<>();
                for (int i = 0; i < avable.size(); i++) {
                    if (s != null && !s.equals("") && s.length() > 0 && SearchALG.isAddToHintList(avable.get(i).getN(), s.toString())) {
                        avable1.add(avable.get(i));
                    }
                }
                lv_city_search.setAdapter(new HotCityListAdapter(CityListActivity.this, avable1, false));
                if (avable1.size() == 0) {
                    isFirstAcy = true;
                }
                avable.clear();
            }
            if (s.length() == 0) {
                lv_city_search.setAdapter(new HotCityListAdapter(CityListActivity.this, pEntities, false));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    /**
     * 联网获取数据
     */
    private void getDataFromServer() {
        Log.e("TAG", "getDataFromServer");

        VolleyManager.newInstance().GsonGetRequest("TAG", Url.CITY_LIST, CityList.class, new Response.Listener<CityList>() {
            @Override
            public void onResponse(CityList cityList) {
                handlerData(cityList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.toString());
            }
        });
    }

    /**
     * 处理得到的list数据
     *
     * @param cityList
     */
    private void handlerData(CityList cityList) {
        maps = new TreeMap<>();
        litters = new ArrayList<>();
        pEntities = CityListSort.sortDatas(cityList.getP());

        for (int i = 0; i < cityList.getP().size(); i++) {
            CityList.PEntity pEntity = cityList.getP().get(i);
            String startLitter = pEntity.getPinyinFull().substring(0, 1).toUpperCase();
            if (maps.containsKey(startLitter)) {
                maps.get(startLitter).add(pEntity);
            } else {
                maps.put(startLitter, new ArrayList<CityList.PEntity>());
                litters.add(startLitter);
                maps.get(startLitter).add(pEntity);
            }
        }

        Collections.sort(litters);
        Log.e("TAG", litters.size() + "");
        gv_citylist.setAdapter(new HotCityListAdapter(this, cityList.getP().subList(0, 12), true));
        lv_city.removeHeaderView(headView);
        lv_city.addHeaderView(headView);
        lv_city.setAdapter(new CityListAdatapter(CityListActivity.this, litters, maps));
    }


    @Override
    protected void onStart() {
        super.onStart();
        //获取locationService实例，建议应用中只始化1个location实例，然后使用，可以参考其他示例的activity，都是通过此种方式获取locationservice实例的
        locationService.registerListener(mListener);
        //注册监听
        int type = getIntent().getIntExtra("from", 0);
        if (type == 0) {
            locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        } else if (type == 1) {
            locationService.setLocationOption(locationService.getOption());
        }
    }


    /**
     * 在此方法中获取地理信息的经纬度
     */
    private BDLocationListener mListener = new BDLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation location) {
            final String city = location.getCity();
            tv_head_location.setText(city);//设置定位的数据
        }

    };

    /**
     * 从资产目录中获取城市列表
     *
     * @param fileName
     * @return
     */
    public String getStringFromAssert(String fileName) {
        String content = null; //结果字符串
        Log.e("TAG", "getStringFromAssert");

        AssetManager assetManager = this.getAssets();
        try {
            InputStream is = assetManager.open(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder stringBuffer = new StringBuilder();
            String str = null;
            while ((str = br.readLine()) != null) {
                content = String.valueOf(stringBuffer.append(str));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}


