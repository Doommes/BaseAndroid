package com.ldq.baseandroid;

import android.util.Log;

import com.ldq.baseandroid.Base.BaseMvpPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestPresenter5 extends BaseMvpPresenter<RequestView5> {
    private static final String TAG = "RequestPresenter5";

    private RequestModel mModel;

    public RequestPresenter5(RequestModel mModel) {
        this.mModel = mModel;
    }

    public  void ClickRequest (){
        getMvpView().requestLoading();

        mModel.request(new Callback<List<WeChatArticle>>() {
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
