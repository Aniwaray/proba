package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class Onboarding4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding4);
    }
    public void Skip(View v){
        Intent intent = new Intent(this, Onboarding3Activity.class);
        startActivity(intent);
    }
    public void Next4(View v){
        Intent intent = new Intent(this, Onboarding3Activity.class);
        startActivity(intent);
    }
}