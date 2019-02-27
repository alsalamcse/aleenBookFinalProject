package com.nassra.aleen.aleenbookfinalproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nassra.aleen.aleenbookfinalproject.data.MyBook;
import com.nassra.aleen.aleenbookfinalproject.data.MyProfile;

public class addBookActivity extends AppCompatActivity {
    private EditText etBookName1, etWriter1, etYear1, etThem1, etRecom1;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        etBookName1 = findViewById(R.id.etBookName1);
        etWriter1 = findViewById(R.id.etWriter1);
        etYear1 = findViewById(R.id.etYear1);
        etThem1 = findViewById(R.id.etThem1);
        etRecom1 = findViewById(R.id.etRecom1);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHadler();
            }
        });


    }

    private void dataHadler() {
        boolean isok = true;
        String name = etBookName1.getText().toString();
        String writer = etWriter1.getText().toString();
        String year = etYear1.getText().toString();
        String them = etThem1.getText().toString();
        String recom = etRecom1.getText().toString();

        if (name.length() == 0) {
            etBookName1.setError("you have to write a name ");
            isok = false;


        }
        if (writer.length() == 0) {
            etWriter1.setError("you have to write a family");
            isok = false;
        }
        if (year.length() == 0) {
            etYear1.setError("you have to write a family");
            isok = false;
        }

        if (isok) {
            MyBook book = new MyBook();

            book.setName(name);
            book.setWriter(writer);
            book.setYear(year);
            book.setThem(them);
            book.setRecomm(recom);

            //FirebaseAuth auth=FirebaseAuth.getInstance();
            //profile.setOwner(auth.getCurrentUser().getEmail());

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

            String key = reference.child("MyBook").push().getKey();
            book.setKey(key);
            reference.child("MyBook").child(key).setValue(book).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task1) {
                    if (task1.isSuccessful()) {
                        Toast.makeText(addBookActivity.this, "add successed", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(addBookActivity.this,bookListActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(addBookActivity.this, "add failed" + task1.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }
}