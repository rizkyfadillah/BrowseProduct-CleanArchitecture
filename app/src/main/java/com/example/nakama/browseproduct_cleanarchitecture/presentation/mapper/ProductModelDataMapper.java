package com.example.nakama.browseproduct_cleanarchitecture.presentation.mapper;

import com.example.nakama.browseproduct_cleanarchitecture.domain.model.Product;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nakama on 13/07/2017.
 */

public class ProductModelDataMapper {

    public List<ProductModel> transform(List<Product> products) {
        List<ProductModel> productModels = new ArrayList<>();
        for (Product product : products) {
            productModels.add(new ProductModel(product.getName(), product.getImage_url()));
        }
        return productModels;
    }

}
