package com.example.karunamoorthy.retrofit;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by karunamoorthy on 4/1/18.
 */

public interface StoreCouponsApi {

    @GET("coupons/")
    Observable<StoreCoupons> getCoupons(@Query("status") String status);

    @GET("coupons/")
    Call<StoreCoupons> getCoupons1(@Query("status") String status);

    @GET("storeOffers/")
    Single<StoreInfo> getStoreInfo();

}
