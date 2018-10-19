package com.ldq.baseandroid;

import android.util.Log;

import com.ldq.baseandroid.SimpleBase.AbstractMvpPersenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestPersenter2 extends AbstractMvpPersenter<RequestView1>{
    private static final String TAG = "RequestPersenter2";
    private RequestModel model;



    public RequestPersenter2() {
        this.model = new RequestModel();
    }

    public  void ClickRequest (){
        getView().requestLoading();
        
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
