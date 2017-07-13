package com.example.nakama.browseproduct_cleanarchitecture.domain.repository;

import com.example.nakama.browseproduct_cleanarchitecture.data.entity.mapper.ProductEntityDataMapper;
import com.example.nakama.browseproduct_cleanarchitecture.domain.model.Product;
import com.example.nakama.browseproduct_cleanarchitecture.data.entity.AceResponse;
import com.example.nakama.browseproduct_cleanarchitecture.data.api.AceService;
import com.example.nakama.browseproduct_cleanarchitecture.data.entity.BaseApiResponse;
import com.example.nakama.browseproduct_cleanarchitecture.data.entity.ProductResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Nakama on 12/07/2017.
 */

public class AceRepository {

    private AceService aceService;
    private ProductEntityDataMapper productEntityDataMapper;

    @Inject
    public AceRepository(AceService aceService, ProductEntityDataMapper productEntityDataMapper) {
        this.aceService = aceService;
        this.productEntityDataMapper = productEntityDataMapper;
    }

    public Observable<Product> getProducts(
            String device,
            String source,
            String q,
            int rows,
            int start) {
        return aceService.getAce(device, source, q, rows, start)
                .flatMapIterable(new Function<BaseApiResponse<AceResponse>, Iterable<ProductResponse>>() {
                    @Override
                    public Iterable<ProductResponse> apply(BaseApiResponse<AceResponse> response) throws Exception {
                        return response.data.products;
                    }
                })
                .map(new Function<ProductResponse, Product>() {
                    @Override
                    public Product apply(ProductResponse productResponse) throws Exception {
                        return productEntityDataMapper.transform(productResponse);
                    }
                });
    }

}
