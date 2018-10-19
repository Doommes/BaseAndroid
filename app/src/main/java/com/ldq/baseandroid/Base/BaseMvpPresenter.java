package com.ldq.baseandroid.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public class BaseMvpPresenter<V extends BaseMVpView> {
    private V mView;

    /**
     * Presenter被创建后调用
     *
     * @param savedState 被意外销毁后重建后的Bundle
     */
    public void onCreatePresenter(@Nullable Bundle savedState){

    }

    /**
     * 绑定View
     */
    public void onAttachMvpView(V view){
        mView = view;
    }

    /**
     * 解除绑定View
     */
    public void onDetachMvpView(){
        mView = null;
    }

    /**
     * Presenter 被销毁时调用
     */
    public void onDestroyPresenter(){

    }

    /**
     * 在Presenter被销毁的时候调用
     * @param outState
     */
    public void onSaveInstanceState(Bundle outState){

    }

    /**
     * 获取V层接口View
     *
     * @return 返回当前MvpView
     */
    public V getMvpView(){
        return mView;
    }
}
