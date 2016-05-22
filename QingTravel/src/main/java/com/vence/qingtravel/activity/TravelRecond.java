package com.vence.qingtravel.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.vence.qingtravel.R;

public class TravelRecond extends Activity {
    private WebView wb_travel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_recond);
        wb_travel = (WebView) findViewById(R.id.wb_travel);

        final String url = getIntent().getStringExtra("url");
        if (url != null) {
            wb_travel.loadUrl(url);
        }

        WebSettings webSettings = wb_travel.getSettings();

        webSettings.setJavaScriptEnabled(true);  //支持js

        webSettings.setUseWideViewPort(true);  //将图片调整到适合webview的大小

        /**
         * 不调用系统浏览器，在本页面中打开】
         */
        wb_travel.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    /**
     * 按返回键回到上个页面，不退出
     * @param keyCode
     * @param event
     * @return
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wb_travel.canGoBack()) {
            wb_travel.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
