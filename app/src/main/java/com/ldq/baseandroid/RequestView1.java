package com.ldq.baseandroid;

import com.ldq.baseandroid.SimpleBase.IMvpBaseView;

import java.util.List;

public interface RequestView1 extends IMvpBaseView {
    //请求中
    void requestLoading();
    //请求成功
    void requestSuccess(List<WeChatArticle> list);
    //请求失败
    void requestFailure(String result);
}
