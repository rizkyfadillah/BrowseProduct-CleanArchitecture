package com.example.nakama.browseproduct_cleanarchitecture.di;

import com.example.nakama.browseproduct_cleanarchitecture.presentation.view.activity.MainActivity;

import dagger.Subcomponent;

/**
 * Created by Nakama on 13/07/2017.
 */
@ActivityScope
@Subcomponent(
    modules = MainActivityModule.class
)
public interface MainActivityComponent {

    MainActivity inject(MainActivity mainActivity);

}
