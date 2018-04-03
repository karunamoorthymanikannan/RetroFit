package com.example.karunamoorthy.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.mylibrary.api.ApiHelper;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    HashMap map;
    EnumMap enumMap;
    LinkedHashMap linkedHashMap;
    ConcurrentHashMap concurrentHashMap;
    WeakHashMap weakHashMap;
    TreeMap treeMap;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCouponData();

    }

    //single api call using retrofit and rxjava
    private void getCouponData() {
        Call<StoreCoupons> request = ApiHelper.getInstance().getRetrofit().create(StoreCouponsApi.class).getCoupons1("1");
        request.enqueue(new Callback<StoreCoupons>() {
            @Override
            public void onResponse(Call<StoreCoupons> call, Response<StoreCoupons> response) {

            }

            @Override
            public void onFailure(Call<StoreCoupons> call, Throwable t) {

            }
        });
        Observable.just(5,6).map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) throws Exception {
                return integer * integer;
            }
        }).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer < 30;
            }
        }).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer value) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        getStoreInfoObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<StoreInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(StoreInfo value) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
                /*.subscribe(new Observer<StoreInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StoreInfo value) {
                        Log.e("Observer", "" + value.cashback.size() + "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Observer", "" + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("Observer", "onComplete");
                    }
                });*/
    }

    public Single<StoreInfo> getStoreInfoObservable() {
        return ApiHelper.getInstance().getRetrofit().create(StoreCouponsApi.class).getStoreInfo();
    }
}
