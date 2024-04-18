package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SendAPackage2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_send_a_package2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView place = findViewById(R.id.textView41);
        TextView phon = findViewById(R.id.textView42);
        TextView placetrakc = findViewById(R.id.textView44);
        TextView phonetrack = findViewById(R.id.textView45);
        TextView weight = findViewById(R.id.textView50);
        TextView worth = findViewById(R.id.textView52);
        TextView item = findViewById(R.id.textView48);

        Bundle arg = getIntent().getExtras();

        place.setText(arg.getString("place"));
        phon.setText(arg.getString("phon"));
        placetrakc.setText(arg.getString("placetrakc"));
        phonetrack.setText(arg.getString("phonetrack"));
        weight.setText(arg.getString("weight"));
        worth.setText(arg.getString("worth"));
        item.setText(arg.getString("item"));
    }
    public void SendAPack(View v){
        Intent intent = new Intent(this, SendAPackageActivity.class);
        startActivity(intent);
    }
    public void MakePayment(View v){
        Intent intent = new Intent(this, TransactionSuccessfulActivity.class);
        startActivity(intent);
    }
    public void Right(View v){
        Intent intent = new Intent(this, SendAPackageActivity.class);
        startActivity(intent);
    }
}