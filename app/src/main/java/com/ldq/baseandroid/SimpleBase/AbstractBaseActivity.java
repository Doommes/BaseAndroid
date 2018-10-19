package com.ldq.baseandroid.SimpleBase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class AbstractBaseActivity<V extends IMvpBaseView, P extends AbstractMvpPersenter<V>>
            extends AppCompatActivity implements IMvpBaseView{
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter == null){
            mPresenter = createPresenter();
        }
        if (mPresenter == null){
            throw new NullPointerException("presenter 不能为空！");
        }
        mPresenter.attach((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.detach();
        }
    }

    public P getPresenter(){
        return mPresenter;
    }

    protected abstract P createPresenter();
}
