package com.example.nakama.browseproduct_cleanarchitecture.data.entity.mapper;

import com.example.nakama.browseproduct_cleanarchitecture.data.entity.ProductResponse;
import com.example.nakama.browseproduct_cleanarchitecture.domain.model.Product;

/**
 * Created by Nakama on 13/07/2017.
 */

public class ProductEntityDataMapper {

    public Product transform(ProductResponse productResponse) {
        return new Product(productResponse.name, productResponse.image_url);
    }

}
