package com.example.nakama.browseproduct_cleanarchitecture.presentation.presenter;

import com.example.nakama.browseproduct_cleanarchitecture.presentation.view.MainView;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.view.activity.MainActivity;

/**
 * Created by Nakama on 12/07/2017.
 */

public interface MainPresenter {

    void getProducts(String device, String source, String q, int rows, int start);

    void destroy();

    void setView(MainView mainView);

}
