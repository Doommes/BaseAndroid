package com.ldq.baseandroid.Base;

import android.os.Bundle;

/**
 * date 2018/10/19
 * @description 代理实现类， 用来管理Presenter的生命周期，还有和view之间的关联
 */
public class BaseMvpProxy<V extends BaseMVpView, P extends BaseMvpPresenter<V>> implements PresenterProxyInterface<V,P> {
    //获取onSaveInstanceState 中的bundle的key
    private final static String PRESENTER_KEY = "presenter_key";

    private PresenterMvpFactory<V,P> mFactory;
    private P mPresenter;
    private Bundle mBundle;
    private boolean mIsAttachView;


    public BaseMvpProxy(PresenterMvpFactory<V, P> mFactory) {
        this.mFactory = mFactory;
    }

    @Override
    public void setPresenterFactory(PresenterMvpFactory<V, P> presenterFactory) {
        if (mPresenter != null){
            throw new IllegalArgumentException("这个方法只能在getMvpPresenter()之前调用，如果Presenter已经创建则不能再修改");
        }
        this.mFactory = presenterFactory;
    }

    @Override
    public PresenterMvpFactory<V, P> getPresenterFactory() {
        return mFactory;
    }

    @Override
    public P getMvpPresenter() {
        if (mFactory != null){
            if (mPresenter != null){
                mPresenter = mFactory.createMvpPresenter();
                mPresenter.onCreatePresenter(mBundle == null ? null : mBundle.getBundle(PRESENTER_KEY));
            }
        }
        return mPresenter;
    }

    public void onResume(V view){
        getMvpPresenter();
        if (mPresenter != null && !mIsAttachView){
            mPresenter.onAttachMvpView(view);
            mIsAttachView = true;
        }
    }

    private void onDetachMvpView(){
        if (mPresenter !=null && mIsAttachView){
            mPresenter.onDetachMvpView();
            mIsAttachView = false;
        }
    }

    /**
     * 销毁Presenter
     */
    public void onDestroy(){
        if (mPresenter != null){
            onDetachMvpView();
            mPresenter.onDestroyPresenter();
            mPresenter = null;
        }
    }

    /**
     * 意外销毁的时候调用
     * @return Bundle 存入回调给Presenter 的Bundle 和当前Presenter 的ID
     */
    public Bundle onSaveInstanceState(){
        Bundle bundle = new Bundle();
        getMvpPresenter();
        if (mPresenter != null){
            Bundle presenterBundle = new Bundle();
            //回调Presenter
            mPresenter.onSaveInstanceState(presenterBundle);
            bundle.putBundle(PRESENTER_KEY, presenterBundle);
        }
        return bundle;
    }

    public void onRestoreInstanceState(Bundle saveInstanceState){
        mBundle = saveInstanceState;
    }
}
