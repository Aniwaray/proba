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

public class Onboarding1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding1);
    }
    public void Skip(View v){
        Intent intent = new Intent(this, Onboarding3Activity.class);
        startActivity(intent);
    }
    public void Next1(View v){
        Intent intent = new Intent(this, Onboarding4Activity.class);
        startActivity(intent);
    }
}