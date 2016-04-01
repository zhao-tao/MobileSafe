package com.example.zhao.mobilesafe.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.zhao.mobilesafe.R;
import com.example.zhao.mobilesafe.beans.Contents;
import com.example.zhao.mobilesafe.beans.UpdateJson;
import com.example.zhao.mobilesafe.utils.BitmapCache;
import com.example.zhao.mobilesafe.utils.GsonRequest;

/**
 * 闪屏页面
 */
public class SplashActivity extends AppCompatActivity {

    private TextView tvVersion;
    private ImageView ivShow;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private UpdateJson mUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int versionCode = packageInfo().versionCode;
        String versionName = packageInfo().versionName;

        tvVersion = (TextView) findViewById(R.id.tv_version);
        ivShow = (ImageView) findViewById(R.id.iv_show);

        tvVersion.setText("VersionName：" + versionName);

        Glide.with(this).load(Contents.SPLASH_IMG).into(ivShow);

        requestQueue = Volley.newRequestQueue(this);
        imageLoader = new ImageLoader(requestQueue, new BitmapCache());

        volleyImageView();

        GsonRequest<UpdateJson> updateJsonGsonRequest = new GsonRequest<>(Request.Method.GET, Contents.UP_DATA, UpdateJson.class, new Response.Listener<UpdateJson>() {
            @Override
            public void onResponse(UpdateJson response) {
                mUpdate = response;
                showUpdateInfo();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(updateJsonGsonRequest);
    }

    private void showUpdateInfo() {
        TextView upDateInfo = (TextView) findViewById(R.id.tv_update_info);
        upDateInfo.setText(mUpdate.getData().getMessage());
    }

    private void volleyImageView() {
        NetworkImageView ivVolley = (NetworkImageView) findViewById(R.id.iv_volley);
        ivVolley.setDefaultImageResId(R.drawable.splash);
        ivVolley.setErrorImageResId(R.drawable.home_safe);
        ivVolley.setImageUrl(Contents.SPLASH_IMG, imageLoader);
    }

    private PackageInfo packageInfo() {
        try {
            PackageInfo info = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            return info;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
