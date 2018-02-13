package com.example.nakama.browseproduct_cleanarchitecture;

import com.example.nakama.browseproduct_cleanarchitecture.data.api.AceService;
import com.example.nakama.browseproduct_cleanarchitecture.data.entity.mapper.ProductEntityDataMapper;
import com.example.nakama.browseproduct_cleanarchitecture.domain.repository.AceRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import static org.mockito.Mockito.mock;

/**
 * Created by Rizky on 13/02/18.
 */

@Module
public class MockNetModule {

    @Provides
    @Singleton
    AceRepository provideAceRepository() {
        return mock(AceRepository.class);
    }

}
