package com.nassra.aleen.aleenbookfinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nassra.aleen.aleenbookfinalproject.data.MyBook;
import com.nassra.aleen.aleenbookfinalproject.data.MyProfile;

public class bookInfoActivity extends AppCompatActivity {
    private EditText etBookName1, etWriter1, etYear1, etThem1, etRecom1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);
        etBookName1 = findViewById(R.id.etBookName1);
        etWriter1 = findViewById(R.id.etWriter1);
        etYear1 = findViewById(R.id.etYear1);
        etThem1 = findViewById(R.id.etThem1);
        etRecom1 = findViewById(R.id.etRecom1);
        Intent i=getIntent();
        if(i!=null){
            MyBook b= (MyBook) i.getExtras().get("book");
            etBookName1.setText(b.getName());
            etWriter1.setText(b.getWriter());
            etThem1.setText(b.getThem());
            etRecom1.setText(b.getRecomm());
        }


    }


}
