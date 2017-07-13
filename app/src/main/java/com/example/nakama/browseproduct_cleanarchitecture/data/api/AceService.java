package com.example.nakama.browseproduct_cleanarchitecture.data.api;

import com.example.nakama.browseproduct_cleanarchitecture.data.entity.AceResponse;
import com.example.nakama.browseproduct_cleanarchitecture.data.entity.BaseApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Nakama on 12/07/2017.
 */

public interface AceService {

    @GET("search/product/v3")
    Observable<BaseApiResponse<AceResponse>> getAce(
            @Query("device") String device,
            @Query("source") String source,
            @Query("q") String q,
            @Query("rows") int rows,
            @Query("start") int start
    );

}
