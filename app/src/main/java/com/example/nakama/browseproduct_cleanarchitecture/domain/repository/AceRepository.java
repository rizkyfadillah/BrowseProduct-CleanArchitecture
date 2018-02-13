package com.example.nakama.browseproduct_cleanarchitecture.domain.repository;

import com.example.nakama.browseproduct_cleanarchitecture.data.entity.mapper.ProductEntityDataMapper;
import com.example.nakama.browseproduct_cleanarchitecture.domain.model.Product;
import com.example.nakama.browseproduct_cleanarchitecture.data.entity.AceResponse;
import com.example.nakama.browseproduct_cleanarchitecture.data.api.AceService;
import com.example.nakama.browseproduct_cleanarchitecture.data.entity.BaseApiResponse;
import com.example.nakama.browseproduct_cleanarchitecture.data.entity.ProductResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Nakama on 12/07/2017.
 */

public class AceRepository {

    private AceService aceService;
    private ProductEntityDataMapper productEntityDataMapper;

    public AceRepository(AceService aceService, ProductEntityDataMapper productEntityDataMapper) {
        this.aceService = aceService;
        this.productEntityDataMapper = productEntityDataMapper;
    }

    public Observable<List<Product>> getProducts(
            String device,
            String source,
            String q,
            int rows,
            int start) {
        return aceService.getAce(device, source, q, rows, start)
                .map(new Function<BaseApiResponse<AceResponse>, List<Product>>() {
                    @Override
                    public List<Product> apply(BaseApiResponse<AceResponse> response) throws Exception {
                        return productEntityDataMapper.transform(response.data.products);
                    }
                });
    }

}
