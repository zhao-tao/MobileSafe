package com.example.zhao.MobileSafe;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 闪屏页面
 */
public class SplashActivity extends AppCompatActivity {

    @Bind(R.id.tv_version)
    TextView tvVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        int versionCode = packageInfo().versionCode;
        String versionName = packageInfo().versionName;

        tvVersion.setText("VersionName：" + versionName);

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
