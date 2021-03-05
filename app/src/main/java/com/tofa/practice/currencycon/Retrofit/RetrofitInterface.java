package com.tofa.practice.currencycon.Retrofit;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitInterface {


    @GET("v6/82adc10ce9721ee22b0b6c9c/latest/{currency}")
    Call<JSONObject> getExchangeCurrency(@Path("currency")String  currency);



}
