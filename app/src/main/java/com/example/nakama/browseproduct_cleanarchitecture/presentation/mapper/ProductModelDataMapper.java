package com.example.nakama.browseproduct_cleanarchitecture.presentation.mapper;

import com.example.nakama.browseproduct_cleanarchitecture.domain.model.Product;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.model.ProductModel;

/**
 * Created by Nakama on 13/07/2017.
 */

public class ProductModelDataMapper {

    public ProductModel transform(Product product) {
        return new ProductModel(product.getName(), product.getImage_url());
    }

}
