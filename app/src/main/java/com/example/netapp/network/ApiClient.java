package com.example.netapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit sRetrofit;

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public ApiInterface getAPI() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit.create(ApiInterface.class);
    }
}
