package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewPasswordActivity extends AppCompatActivity {

    private AppCompatButton log;
    private String confText, passText;
    private EditText conf, pass;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        log = findViewById(R.id.button2);
        passText = "";
        confText = "";

        conf = findViewById(R.id.pass2);
        pass = findViewById(R.id.pass1);

        conf.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                confText = conf.getText().toString();
                passText = pass.getText().toString();
                Validation(confText, passText);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                confText = conf.getText().toString();
                passText = pass.getText().toString();
                Validation(confText, passText);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void Validation(String conf, String pass){
        if (!conf.isEmpty() & !pass.isEmpty() & pass.equals(conf)){
            log.setEnabled(true);
            log.setBackgroundColor(getColor(R.color.blue));
        } else{
            log.setEnabled(false);
            log.setBackgroundColor(getColor(R.color.Gray));
        }
    }

    public void LogIn2(View v){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}