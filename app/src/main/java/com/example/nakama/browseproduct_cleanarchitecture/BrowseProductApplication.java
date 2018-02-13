package com.example.nakama.browseproduct_cleanarchitecture;

import android.app.Application;

import com.example.nakama.browseproduct_cleanarchitecture.di.AppComponent;
import com.example.nakama.browseproduct_cleanarchitecture.di.DaggerAppComponent;

/**
 * Created by Nakama on 12/07/2017.
 */

public class BrowseProductApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = createComponent();
    }

    protected AppComponent createComponent() {
        return DaggerAppComponent.builder().build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
