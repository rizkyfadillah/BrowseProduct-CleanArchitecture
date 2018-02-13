package com.example.nakama.browseproduct_cleanarchitecture.presentation.presenter;

import android.util.Log;

import com.example.nakama.browseproduct_cleanarchitecture.data.entity.mapper.ProductEntityDataMapper;
import com.example.nakama.browseproduct_cleanarchitecture.domain.model.Product;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.mapper.ProductModelDataMapper;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.model.ProductModel;
import com.example.nakama.browseproduct_cleanarchitecture.domain.interactor.GetProductsUseCase;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.view.MainView;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.view.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Nakama on 12/07/2017.
 */

public class MainPresenterImpl implements MainPresenter {

    private GetProductsUseCase getProductsUseCase;

    private MainView mainView;

    private ProductModelDataMapper productModelDataMapper;

    private List<ProductModel> productModelList = new ArrayList<>();

    public MainPresenterImpl(GetProductsUseCase getProductsUseCase, ProductModelDataMapper productModelDataMapper) {
        this.getProductsUseCase = getProductsUseCase;
        this.productModelDataMapper = productModelDataMapper;
    }

    @Override
    public void setView(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void getProducts(String device, String source, String q, int rows, int start) {
        productModelList.clear();
        getProductsUseCase.execute(
                new AceObserver(), new GetProductsUseCase.Params(device, source, q, rows, start));
    }

    @Override
    public void destroy() {
        getProductsUseCase.dispose();
    }

    private class AceObserver extends DisposableObserver<List<Product>> {
        @Override
        public void onNext(@NonNull List<Product> product) {
            mainView.showProducts(productModelDataMapper.transform(product));
        }

        @Override
        public void onError(@NonNull Throwable e) {
            mainView.showError(e.getMessage());
        }

        @Override
        public void onComplete() {

        }
    }

}
