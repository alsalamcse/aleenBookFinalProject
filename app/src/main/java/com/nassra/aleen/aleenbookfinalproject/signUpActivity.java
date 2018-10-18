package com.nassra.aleen.aleenbookfinalproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class signUpActivity extends AppCompatActivity {
    private EditText etFirstName,etLastName,etPhone,etEmail2,etPassword2;
    private Button btnSave;
    private FirebaseUser user;
    private FirebaseAuth auth;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etFirstName=findViewById(R.id.etFirstName);
        etLastName=findViewById(R.id.etLastName);
        etPhone=findViewById(R.id.etPhone);
        etEmail2=findViewById(R.id.etEmail2);
        etPassword2=findViewById(R.id.etPassword2);
        btnSave=findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();


    }

    private void dataHandler() {
        boolean isok=true;
        String email=etEmail2.getText().toString();
        String pass=etPassword2.getText().toString();
        String fName=etFirstName.getText().toString();
        String lName=etLastName.getText().toString();
        String phone=etPhone.getText().toString();
        if (email.length()<4||email.indexOf('@')<0||email.indexOf('.')<0){
            etEmail2.setError("wrong email");
            isok=false;

        }
        if ((pass.length())<8){
            etPassword2.setError("wrong password");
            isok=false;
        }
        if (isok){
            creatAcount(email,pass);
        }



    }
    private void creatAcount(String email,String passw){
        auth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(signUpActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(signUpActivity.this, "AUTHENTICTION SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(signUpActivity.this, "Authentication failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }

            }
        });
    }


}
