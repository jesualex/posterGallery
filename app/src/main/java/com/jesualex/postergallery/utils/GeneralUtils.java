package com.jesualex.postergallery.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.jesualex.postergallery.App;

/**
 * Created by jesualex
 * Date: 05-09-18
 */
public class GeneralUtils {

    public static void showToast(String msj){
        Toast.makeText(
                App.getAppContext(),
                msj,
                Toast.LENGTH_LONG
        ).show();
    }

    public static void showToast(@StringRes int resId){
        Toast.makeText(
                App.getAppContext(),
                resId,
                Toast.LENGTH_LONG
        ).show();
    }
}
