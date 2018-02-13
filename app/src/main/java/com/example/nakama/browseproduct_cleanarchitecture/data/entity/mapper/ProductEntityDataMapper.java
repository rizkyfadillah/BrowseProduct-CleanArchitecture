package com.example.nakama.browseproduct_cleanarchitecture.data.entity.mapper;

import com.example.nakama.browseproduct_cleanarchitecture.data.entity.ProductResponse;
import com.example.nakama.browseproduct_cleanarchitecture.domain.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nakama on 13/07/2017.
 */

public class ProductEntityDataMapper {

    public List<Product> transform(List<ProductResponse> productResponses) {
        List<Product> products = new ArrayList<>();
        for (ProductResponse productResponse : productResponses) {
            products.add(new Product(productResponse.name, productResponse.image_url));
        }
        return products;
    }

}
