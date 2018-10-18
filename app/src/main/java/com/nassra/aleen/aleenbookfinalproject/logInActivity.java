package com.nassra.aleen.aleenbookfinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class logInActivity extends AppCompatActivity {
    private EditText etEmail,etPassword;
    private Button btnSignUp,btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnSignUp=findViewById(R.id.btnSignUp);
        btnSignIn=findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(logInActivity.this,StartActivity.class);
                startActivity(i);

            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(logInActivity.this,signUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
