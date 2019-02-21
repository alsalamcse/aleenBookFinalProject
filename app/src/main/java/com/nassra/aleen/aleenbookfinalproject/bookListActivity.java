package com.nassra.aleen.aleenbookfinalproject;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.nassra.aleen.aleenbookfinalproject.bookFragment.ProfileFragment;

public class bookListActivity extends AppCompatActivity {
    private ListView lvBook;
    private FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        lvBook=findViewById(R.id.lvBook);
        btnAdd=findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bookListActivity.this,addBookActivity.class);
                startActivity(intent);
            }
        });
    }
}
