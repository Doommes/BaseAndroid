package com.ldq.baseandroid.Base;

public interface PresenterProxyInterface<V extends BaseMVpView, P extends BaseMvpPresenter<V>> {

    /**
     * 设置创建Presenter的工厂
     * @param presenterFactory presenterFactory PresenterFactory类型
     */
    void setPresenterFactory(PresenterMvpFactory<V,P> presenterFactory);

    /**
     * 获取Presenter 的工厂种类
     * @return 返回 PresenterMvpFactory 类型
     */
    PresenterMvpFactory<V,P> getPresenterFactory();

    /**
     * 获取创建的presenter
     * @return 指定类型的presenter
     */
    P getMvpPresenter();
}
