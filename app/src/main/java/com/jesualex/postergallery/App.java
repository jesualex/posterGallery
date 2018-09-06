package com.jesualex.postergallery;

import android.app.Application;
import android.content.Context;

import com.jesualex.postergallery.database.entitys.MyObjectBox;

import io.objectbox.BoxStore;

/**
 * Created by jesualex
 * Date: 05-09-18
 */
public class App extends Application{
    private static Context context;
    private static BoxStore boxStoreInstance;

    @Override public void onCreate() {
        super.onCreate();
        context = this;

        boxStoreInstance = MyObjectBox.builder().androidContext(App.this).build();
    }

    public static BoxStore getBoxStoreInstance(){
        return boxStoreInstance;
    }

    public static Context getAppContext() {
        return context;
    }
}
