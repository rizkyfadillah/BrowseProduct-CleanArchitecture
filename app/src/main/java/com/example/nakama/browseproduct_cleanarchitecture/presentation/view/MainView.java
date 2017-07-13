package com.example.nakama.browseproduct_cleanarchitecture.presentation.view;

import com.example.nakama.browseproduct_cleanarchitecture.presentation.model.ProductModel;

import java.util.List;

/**
 * Created by Nakama on 12/07/2017.
 */

public interface MainView {

    void showProducts(List<ProductModel> productModelList);

    void showError(String message);

}
