package com.example.nakama.browseproduct_cleanarchitecture.data.entity;

/**
 * Created by Nakama on 12/07/2017.
 */

public class ProductResponse {
    public String id;
    public String name;
    public String image_url;

    public ProductResponse(String id, String name, String image_url) {
        this.id = id;
        this.name = name;
        this.image_url = image_url;
    }
}
