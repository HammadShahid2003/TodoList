package com.example.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logoImageView = findViewById(R.id.logoImageView);

        // Load the animations
        Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_animation);
        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);

        // Start the animations sequentially
        logoImageView.startAnimation(translateAnimation);
        logoImageView.startAnimation(scaleAnimation);

        // Delay the navigation to MainActivity until the animation finishes
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivityForResult(intent, 100);
            finish();
        }, 5000);
    }
}
