package com.example.nakama.browseproduct_cleanarchitecture;

import com.example.nakama.browseproduct_cleanarchitecture.di.AppComponent;

/**
 * Created by Rizky on 12/02/18.
 */

public class MockApplication extends BrowseProductApplication {

    private AppComponent component;

    public void setTestComponent(AppComponent component) {
        this.component = component;
    }

    @Override
    public AppComponent getComponent() {
        return component;
    }
}
