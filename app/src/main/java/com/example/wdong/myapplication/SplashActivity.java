package com.example.wdong.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/**
 * Created by wdong on 2015/9/28.
 */
public class SplashActivity extends Activity {
    final long sleepTime = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onResume() {
        super.onResume();
        final int version = getVersion();
        //网络上去访问拿到最新的app版本，比较，是否要更新app
        new Thread(new Runnable() {
            @Override
            public void run() {
                int code = RemoteService.getVersionCode();
                if(code > version) {
                }
            }

        });
        try {
            Thread.sleep(sleepTime);
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        } catch (Exception e) {

        }

    }

    private int getVersion() {
        PackageManager pm = getPackageManager();
        try {
            PackageInfo packinfo = pm.getPackageInfo(getPackageName(), 0);
            int version = packinfo.versionCode;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
