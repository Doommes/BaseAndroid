package com.ldq.baseandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ldq.baseandroid.Base.AbstractMvpActivity;
import com.ldq.baseandroid.SimpleBase.AbstractBaseActivity;

import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity
        extends AbstractMvpActivity<RequestView5, RequestPresenter5>
        implements View.OnClickListener, RequestView5 {
    private static final String TAG = "MainActivity";
    /**
     * Hello World!
     */
    private Button mBtnRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setPresenterFactory();
        initView();

    }


    private void initView() {
        mBtnRequest = findViewById(R.id.btn_request);
        mBtnRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_request:
                if (getMvpPresenter() != null){
                    getMvpPresenter().ClickRequest();
                }else {
                    Log.d(TAG, "onClick: failure");
                }
                //RequestWeather();
                break;
        }
    }

    @Override
    public void requestLoading() {
        Toast.makeText(this, "正在请求中。。。", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void requestSuccess(List<WeChatArticle> list) {
        Log.d(TAG, "requestSuccess: ");
    }

    @Override
    public void requestFailure(String result) {
        Log.d(TAG, "requestFailure: ");
    }
}
