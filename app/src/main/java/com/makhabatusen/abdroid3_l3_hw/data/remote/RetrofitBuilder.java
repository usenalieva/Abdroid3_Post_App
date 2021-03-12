package com.makhabatusen.abdroid3_l3_hw.data.remote;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    public RetrofitBuilder() { }

    private static Android3API instance;

    public static Android3API getInstance() {
        if (instance == null)
            instance = createAPI();
        return instance;
    }

    private static Android3API createAPI() {
        return new Retrofit
                .Builder()
                .baseUrl("http://android-3-mocker.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Android3API.class);
    }
}
