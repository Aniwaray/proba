//Цандер Максим Витальевич
//2 апреля 2024 год
//Окно для регистрации
package com.example.myapplication;

import static android.content.ContentValues.TAG;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private AppCompatButton login;
    private CheckBox terms;
    private String fioText, phoneText, emailText, passText, confText;
    private EditText email, fio, phone, pass, conf;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        login = findViewById(R.id.button);
        fioText = "";
        phoneText = "";
        emailText = "";
        passText = "";
        confText = "";

        email = findViewById(R.id.editTextTextEmailAddress);
        fio = findViewById(R.id.editTextText);
        phone = findViewById(R.id.editTextPhone);
        pass = findViewById(R.id.pass);
        conf = findViewById(R.id.pass1);
        terms = findViewById(R.id.checkBox);
        mAuth = FirebaseAuth.getInstance();



        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailText = email.getText().toString();
                Validation(emailText, terms);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        terms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                emailText = email.getText().toString();
                Validation(emailText, terms);
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fioText = fio.getText().toString();
                phoneText = phone.getText().toString();
                passText = pass.getText().toString();
                confText = conf.getText().toString();
                emailText = email.getText().toString();




                if(fioText.length() != 0 & Patterns.PHONE.matcher(phoneText).matches() & passText.length() != 0 & confText.length() != 0 & passText.equals(confText) == true){
                    createAccount(emailText, passText);
                    if(user != null) {
                        Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }
                if(fioText.length() == 0) {
                    fio.setBackground(getDrawable(R.drawable.red_block));
                } else {
                    fio.setBackground(getDrawable(R.drawable.white_block));
                }
                if(Patterns.PHONE.matcher(phoneText).matches()) {
                    phone.setBackground(getDrawable(R.drawable.white_block));
                } else {
                    phone.setBackground(getDrawable(R.drawable.red_block));
                }
                if(passText.length() == 0 || passText.equals(confText) == false) {
                    pass.setBackground(getDrawable(R.drawable.red_block));
                } else {
                    pass.setBackground(getDrawable(R.drawable.white_block));
                }
                if(confText.length() == 0 || passText.equals(confText) == false) {
                    conf.setBackground(getDrawable(R.drawable.red_block));
                } else {
                    conf.setBackground(getDrawable(R.drawable.white_block));
                }
            }
        });

    }

    private void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            user = mAuth.getCurrentUser();

                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }
    public void Validation(String email, CheckBox view){
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches() & view.isChecked() == true){
            login.setEnabled(true);
            login.setBackgroundColor(getColor(R.color.blue));
        } else{
            login.setEnabled(false);
            login.setBackgroundColor(getColor(R.color.Gray));
        }
    }
    public void  Sign_in(View v){
        Intent intent = new Intent(this, LoginInActivity.class);
        startActivity(intent);
    }

    private void reload() {
    }

}



