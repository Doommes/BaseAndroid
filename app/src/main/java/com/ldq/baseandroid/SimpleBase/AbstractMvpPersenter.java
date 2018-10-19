package com.ldq.baseandroid.SimpleBase;

public class AbstractMvpPersenter<V extends IMvpBaseView> {
    private V mView;

    public void attach(V view){
        this.mView = view;
    }

    public void detach(){
        this.mView = null;
    }

    public V getView(){
        return mView;
    }
}
