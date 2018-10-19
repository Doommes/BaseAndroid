package com.ldq.baseandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("chapters/json/")
    Call<List<WeChatArticle>> request();
}
