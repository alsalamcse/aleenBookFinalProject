package com.nassra.aleen.aleenbookfinalproject;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nassra.aleen.aleenbookfinalproject.data.BookAdapter;
import com.nassra.aleen.aleenbookfinalproject.data.ChoosenAdapter;
import com.nassra.aleen.aleenbookfinalproject.data.MyBook;

public class choosenActivity extends AppCompatActivity {
    private ListView lvChoosen;
    private ChoosenAdapter choosenAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosen);
        lvChoosen=findViewById(R.id.IvChoosen);
        choosenAdapter=new ChoosenAdapter(getBaseContext(),R.layout.choosen);
        lvChoosen.setAdapter(choosenAdapter);
        getAllchoosen();
    }

    private void getAllchoosen() {

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            FirebaseAuth auth=FirebaseAuth.getInstance();
            reference.child(auth.getUid()).child("MyChoosen");
            reference.child(auth.getUid()).child("MyChoosen").addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    choosenAdapter.clear();
                    for (DataSnapshot d:dataSnapshot.getChildren())
                    {
                        MyBook b=d.getValue(MyBook.class);
                        choosenAdapter.add(b);
                    }
                    choosenAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getBaseContext(), "onCancelled", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

