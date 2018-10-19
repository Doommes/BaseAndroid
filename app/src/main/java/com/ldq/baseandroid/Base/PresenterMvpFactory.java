package com.ldq.baseandroid.Base;

public interface PresenterMvpFactory<V extends BaseMVpView, P extends BaseMvpPresenter<V>>{
    /**
     * 创建Presenter的接口方法
     * @return Presenter
     */
    P createMvpPresenter();
}
