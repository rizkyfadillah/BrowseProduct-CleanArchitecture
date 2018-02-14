package com.example.nakama.browseproduct_cleanarchitecture.di;

import com.example.nakama.browseproduct_cleanarchitecture.data.api.AceService;
import com.example.nakama.browseproduct_cleanarchitecture.data.entity.mapper.ProductEntityDataMapper;
import com.example.nakama.browseproduct_cleanarchitecture.domain.interactor.GetProductsUseCase;
import com.example.nakama.browseproduct_cleanarchitecture.domain.repository.AceRepository;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.mapper.ProductModelDataMapper;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nakama on 12/07/2017.
 */
@Module
public class NetModule {

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRestAdapter(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl("http://ace.tokopedia.com")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
