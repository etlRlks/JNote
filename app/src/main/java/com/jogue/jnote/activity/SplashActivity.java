package com.jogue.jnote.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.jogue.jnote.MainActivity;
import com.jogue.jnote.R;

/**
 * Created by jogue- on 2016/8/8.
 */
public class SplashActivity extends AppCompatActivity{
    private static final long DELAY_TIME = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        Window window = SplashActivity.this.getWindow();
        window.setFlags(flag,flag);
        setContentView(R.layout.activity_splash);
        redirectByTime();
    }

    private void redirectByTime() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finishActivityAnimation(SplashActivity.this);
            }
        }, DELAY_TIME);
    }

    public static void finishActivityAnimation(Context context) {
        ((Activity) context).finish();
        ((Activity) context).overridePendingTransition(R.anim.zoom_enter,
                R.anim.zoom_exit);
    }
}
