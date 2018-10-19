package com.ldq.baseandroid;

import android.util.Log;

import java.util.List;
import java.util.logging.Handler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestPersenter1 {
    private static final String TAG = "RequestPersenter1";
    private final RequestView1 view1;
    private final RequestModel model;

    public RequestPersenter1(RequestView1 view1) {
        this.view1 = view1;
        this.model = new RequestModel();
    }

    public  void ClickRequest (){
        view1.requestLoading();
        
        model.request(new Callback<List<WeChatArticle>>() {
            @Override
            public void onResponse(Call<List<WeChatArticle>> call, Response<List<WeChatArticle>> response) {
                Log.d(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Call<List<WeChatArticle>> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }
}
