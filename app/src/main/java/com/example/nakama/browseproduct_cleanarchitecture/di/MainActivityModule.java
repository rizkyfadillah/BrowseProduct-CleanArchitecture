package com.example.nakama.browseproduct_cleanarchitecture.di;

import com.example.nakama.browseproduct_cleanarchitecture.domain.interactor.GetProductsUseCase;
import com.example.nakama.browseproduct_cleanarchitecture.domain.repository.AceRepository;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.mapper.ProductModelDataMapper;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.presenter.MainPresenter;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.presenter.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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
    GetProductsUseCase provideGetAce(AceRepository aceRepository, @SubscribeScheduler Scheduler subscribeScheduler,
                                     @ObserveScheduler Scheduler observeScheduler) {
        return new GetProductsUseCase(aceRepository, subscribeScheduler, observeScheduler);
    }

    @Provides
    @ActivityScope
    ProductModelDataMapper provideProductModelDataMapper() {
        return new ProductModelDataMapper();
    }

}
