package com.example.nakama.browseproduct_cleanarchitecture;

import com.example.nakama.browseproduct_cleanarchitecture.di.AppComponent;
import com.example.nakama.browseproduct_cleanarchitecture.di.MainActivityComponent;

/**
 * Created by Rizky on 12/02/18.
 */

public class MockApplication extends BrowseProductApplication {

    private AppComponent component;
    private MainActivityComponent mainActivityComponent;

    public void setTestComponent(AppComponent component) {
        this.component = component;
    }

    public void setMainActivityComponent(MainActivityComponent mainActivityComponent) {
        this.mainActivityComponent = mainActivityComponent;
    }

    @Override
    public AppComponent getComponent() {
        return component;
    }

    @Override
    public MainActivityComponent getMainActivityComponent() {
        return mainActivityComponent;
    }
}
