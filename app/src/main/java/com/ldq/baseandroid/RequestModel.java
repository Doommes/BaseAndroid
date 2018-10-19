package com.ldq.baseandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestModel {
    private static final String BASE_URL = "http://wanandroid.com/wxarticle/";

    public void request(Callback<List<WeChatArticle>> callBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<WeChatArticle>> call = apiService.request();
        call.enqueue(callBack);
    }
}
