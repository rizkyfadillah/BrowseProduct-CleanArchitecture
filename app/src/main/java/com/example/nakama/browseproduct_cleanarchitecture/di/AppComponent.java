package com.example.nakama.browseproduct_cleanarchitecture.di;

import javax.inject.Singleton;

import com.example.nakama.browseproduct_cleanarchitecture.presentation.view.activity.MainActivity;

import dagger.Component;

/**
 * Created by Nakama on 12/07/2017.
 */
@Singleton
@Component(
    modules = NetModule.class
)
public interface AppComponent {

    MainActivityComponent plus(MainActivityModule mainActivityModule);

}
