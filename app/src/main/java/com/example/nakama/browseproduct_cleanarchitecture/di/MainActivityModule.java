package com.example.nakama.browseproduct_cleanarchitecture.di;

import com.example.nakama.browseproduct_cleanarchitecture.data.api.AceService;
import com.example.nakama.browseproduct_cleanarchitecture.data.entity.mapper.ProductEntityDataMapper;
import com.example.nakama.browseproduct_cleanarchitecture.domain.interactor.GetProductsUseCase;
import com.example.nakama.browseproduct_cleanarchitecture.domain.repository.AceRepository;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.mapper.ProductModelDataMapper;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.presenter.MainPresenter;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.presenter.MainPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Nakama on 13/07/2017.
 */
@Module
public class MainActivityModule {

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter(GetProductsUseCase getProductsUseCase, ProductModelDataMapper productModelDataMapper) {
        return new MainPresenterImpl(getProductsUseCase, productModelDataMapper);
    }

    @Provides
    @ActivityScope
    GetProductsUseCase provideGetAce(AceRepository aceRepository) {
        return new GetProductsUseCase(aceRepository);
    }

    @Provides
    @ActivityScope
    ProductModelDataMapper provideProductModelDataMapper() {
        return new ProductModelDataMapper();
    }

}
