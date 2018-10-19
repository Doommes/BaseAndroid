package com.ldq.baseandroid;

import com.ldq.baseandroid.Base.BaseMVpView;

import java.util.List;

public interface RequestView5 extends BaseMVpView {
    //请求中
    void requestLoading();
    //请求成功
    void requestSuccess(List<WeChatArticle> list);
    //请求失败
    void requestFailure(String result);
}
