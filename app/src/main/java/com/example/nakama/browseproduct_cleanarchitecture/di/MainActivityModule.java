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
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Nakama on 13/07/2017.
 */

@Module
public class MainActivityModule {

    @Provides
    @ActivityScope
    @SubscribeScheduler
    Scheduler provideSubscribeScheduler() {
        return Schedulers.io();
    }

    @Provides
    @ActivityScope
    @ObserveScheduler
    Scheduler provideObserveScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter(GetProductsUseCase getProductsUseCase, ProductModelDataMapper productModelDataMapper) {
        return new MainPresenterImpl(getProductsUseCase, productModelDataMapper);
    }

    @Provides
    @ActivityScope
    AceService provideAceService(Retrofit restAdapter) {
        return restAdapter.create(AceService.class);
    }

    @Provides
    @ActivityScope
    ProductEntityDataMapper provideProductEntityDataMapper() {
        return new ProductEntityDataMapper();
    }

    @Provides
    @ActivityScope
    ProductModelDataMapper provideProductModelDataMapper() {
        return new ProductModelDataMapper();
    }

}
