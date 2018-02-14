package com.example.nakama.browseproduct_cleanarchitecture;

import android.app.Application;

import com.example.nakama.browseproduct_cleanarchitecture.di.AppComponent;
import com.example.nakama.browseproduct_cleanarchitecture.di.DaggerAppComponent;
import com.example.nakama.browseproduct_cleanarchitecture.di.MainActivityComponent;
import com.example.nakama.browseproduct_cleanarchitecture.di.MainActivityModule;

/**
 * Created by Nakama on 12/07/2017.
 */

public class BrowseProductApplication extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder().build();
    }

    public AppComponent getComponent() {
        return component;
    }

    public MainActivityComponent getMainActivityComponent() {
        return DaggerAppComponent.builder().build()
                .plus(new MainActivityModule());
    }
}
