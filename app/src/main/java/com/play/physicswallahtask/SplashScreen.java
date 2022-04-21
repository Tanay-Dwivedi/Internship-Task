package com.play.physicswallahtask;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import java.util.Objects;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // This will display our app in full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // This will remove the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, TeachersListScreen.class);
            startActivity(intent);
            finish();
        },3000);

    }
}