package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OtpVerificationActivity extends AppCompatActivity {

    private EditText one, two, three, four, five, six;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        one = findViewById(R.id.editTextNumberPassword);

        two = findViewById(R.id.editTextNumberPassword2);

        three = findViewById(R.id.editTextNumberPassword3);

        four = findViewById(R.id.editTextNumberPassword4);

        five = findViewById(R.id.editTextNumberPassword5);

        six = findViewById(R.id.editTextNumberPassword6);
        final int[] time = {60};
        TextView timer = (TextView) findViewById(R.id.textView26) ;

        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("seconds remaining: " + time[0]);
                time[0]--;
            }

            public void onFinish() {
                timer.setText("resend");
                timer.setTextColor(getColor(R.color.blue));
            }

        }.start();

        one.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(one.length() == 1){
                    two.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        two.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(two.length() == 1){
                    three.requestFocus();
                }
                if(two.length() == 0){
                    one.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        three.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(three.length() == 1){
                    four.requestFocus();
                }
                if(three.length() == 0){
                    two.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        four.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(four.length() == 1){
                    five.requestFocus();
                }
                if(four.length() == 0){
                    three.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        five.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(five.length() == 1){
                    six.requestFocus();
                }
                if(five.length() == 0){
                    four.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        six.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(six.length() == 0){
                    five.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void SetNewPassword1(View v){
        Intent intent = new Intent(this, NewPasswordActivity.class);
        startActivity(intent);
    }
}