package com.example.mylibrary.api;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by karunamoorthy on 4/1/18.
 */

public class ApiHelper {

    public static ApiHelper mApiHelper = null;
    public Retrofit mRetrofit;
    public static final String BASE_URL = "http://www.zoftino.com/api/";

    private ApiHelper() {

    }

    public static ApiHelper getInstance() {
        if (mApiHelper == null) {
            mApiHelper = new ApiHelper();
        }
        return mApiHelper;
    }

    public synchronized Retrofit getRetrofit() {
        if (mRetrofit == null) {
            setUpRetrofit(BASE_URL);
        }
        return mRetrofit;
    }

    private Retrofit setUpRetrofit(String baseUrl) {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
