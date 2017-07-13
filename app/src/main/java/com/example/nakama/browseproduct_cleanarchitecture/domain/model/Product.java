package com.example.nakama.browseproduct_cleanarchitecture.domain.model;

/**
 * Created by Nakama on 13/07/2017.
 */

public class Product {
    private String name;
    private String image_url;

    public Product(String name, String image_url) {
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
