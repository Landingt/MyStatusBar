package com.example.mystatusbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private Button mWelcome;
    private Button mVideo;
    private Button mGame;
    private ActionBar mActionBar;
    private View decorView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    private void init() {
        mActionBar = getSupportActionBar();
        mActionBar.hide();
        mWelcome=findViewById(R.id.welcome);
        mVideo=findViewById(R.id.video);
        mGame=findViewById(R.id.game);
        decorView= getWindow().getDecorView();
        mWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setmWelcomeStatusBar();
            }
        });
        mVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setmVideoStatusBar();
            }
        });
        mGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setmGameStatusBar();
            }
        });
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if(visibility==View.VISIBLE){
                    Toast.makeText(getApplicationContext(),"当前状态栏已显示",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"当前状态栏已隐藏",Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    void setmWelcomeStatusBar() {

        if (Build.VERSION.SDK_INT >= 21) {

            int option =  WindowManager.LayoutParams.FLAG_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);

        }
    }
    private void setmVideoStatusBar() {
        if (Build.VERSION.SDK_INT >= 21) {

            int option =  WindowManager.LayoutParams.FLAG_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    |View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }


    private void setmGameStatusBar() {
        if (Build.VERSION.SDK_INT >= 21) {

            int option =  WindowManager.LayoutParams.FLAG_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

            decorView.setSystemUiVisibility(option);
        }
    }
}
