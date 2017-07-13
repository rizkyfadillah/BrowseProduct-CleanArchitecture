package com.example.nakama.browseproduct_cleanarchitecture.presentation.model;

/**
 * Created by Nakama on 12/07/2017.
 */

public class ProductModel {
    private String name;
    private String image_url;

    public ProductModel(String name, String image_url) {
        this.name = name;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }
}
