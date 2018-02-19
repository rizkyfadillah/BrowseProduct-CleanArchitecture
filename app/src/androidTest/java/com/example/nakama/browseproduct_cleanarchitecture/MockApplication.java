package com.example.nakama.browseproduct_cleanarchitecture;

import com.example.nakama.browseproduct_cleanarchitecture.di.AppComponent;
import com.example.nakama.browseproduct_cleanarchitecture.di.MainActivityComponent;

/**
 * Created by Rizky on 12/02/18.
 */

public class MockApplication extends BrowseProductApplication {

    private MainActivityComponent mainActivityComponent;

    public void setMainActivityComponent(MainActivityComponent mainActivityComponent) {
        this.mainActivityComponent = mainActivityComponent;
    }

    @Override
    public MainActivityComponent getMainActivityComponent() {
        return mainActivityComponent;
    }

}
