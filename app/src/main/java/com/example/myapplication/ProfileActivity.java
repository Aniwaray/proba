package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void Card(View v){
        Intent intent = new Intent(this, AddPaymentMethodActivity.class);
        startActivity(intent);
    }
    public void Notification(View v){
        Intent intent = new Intent(this, NotificationActivity.class);
        startActivity(intent);
    }
    public void Statements(View v){
        Intent intent = new Intent(this, SendAPackageActivity.class);
        startActivity(intent);
    }
    public void Home(View v){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void Track(View v){
        Intent intent = new Intent(this, TrackingPackageActivity.class);
        startActivity(intent);
    }
    public void LogOut(View v){
        Intent intent = new Intent(this, LoginInActivity.class);
        startActivity(intent);
    }
}