package com.vence.qingtravel.utils;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;

import com.vence.qingtravel.R;


/**
 * Created by st0rm23 on 2016/2/17.
 */
public class Loading {

    static private AlertDialog alertDialog;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    static public void showLoading(Context context) {
        if (alertDialog != null && alertDialog.isShowing()) return;
        alertDialog =
                new AlertDialog.Builder(context, R.style.LoadingDialog)
                        .setView(R.layout.layout_loading)
                        .setCancelable(false)
                        .create();
        alertDialog.show();
    }

    static public void dismissLoading() {
        if (alertDialog == null || !alertDialog.isShowing()) return;
        try {
            alertDialog.dismiss();
        } catch (Exception e) {

        }
    }
}
