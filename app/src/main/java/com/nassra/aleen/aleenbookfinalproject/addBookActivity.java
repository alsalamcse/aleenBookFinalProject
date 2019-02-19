package com.nassra.aleen.aleenbookfinalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class addBookActivity extends AppCompatActivity {
    private EditText etBookName1,etWriter1,etYear1,etThem1,etRecom1;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        etBookName1=findViewById(R.id.etBookName1);
        etWriter1=findViewById(R.id.etWriter1);
        etYear1=findViewById(R.id.etYear1);
        etThem1=findViewById(R.id.etThem1);
        etRecom1=findViewById(R.id.etRecom1);
        btnAdd=findViewById(R.id.btnAdd);

    }
}
