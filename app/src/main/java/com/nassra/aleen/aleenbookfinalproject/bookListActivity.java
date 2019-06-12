package com.nassra.aleen.aleenbookfinalproject;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nassra.aleen.aleenbookfinalproject.data.BookAdapter;
import com.nassra.aleen.aleenbookfinalproject.data.MyBook;

public class bookListActivity extends AppCompatActivity {
    private ListView lvBook;
    private FloatingActionButton btnAdd;
    private BookAdapter  bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        lvBook=findViewById(R.id.lvBook);
        btnAdd=findViewById(R.id.btnAdd);
        bookAdapter=new BookAdapter(getBaseContext(),R.layout.book);
        lvBook.setAdapter(bookAdapter);
getAllbook();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bookListActivity.this,addBookActivity.class);
                startActivity(intent);
            }
        });
    }
    private void getAllbook(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        FirebaseAuth auth=FirebaseAuth.getInstance();
        reference.child("MyBook").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                bookAdapter.clear();
                for (DataSnapshot d:dataSnapshot.getChildren())
                {
                    MyBook b=d.getValue(MyBook.class);
                    bookAdapter.add(b);
                }
                bookAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(bookListActivity.this, "onCancelled", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
