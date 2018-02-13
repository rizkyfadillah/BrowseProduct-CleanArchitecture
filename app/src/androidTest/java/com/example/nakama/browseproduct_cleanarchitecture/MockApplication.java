package com.example.nakama.browseproduct_cleanarchitecture;

import com.example.nakama.browseproduct_cleanarchitecture.di.AppComponent;

/**
 * Created by Rizky on 12/02/18.
 */

public class MockApplication extends BrowseProductApplication {

    @Override
    protected AppComponent createComponent() {
        return DaggerMainActivityTest_TestComponent.builder().build();
    }

}
