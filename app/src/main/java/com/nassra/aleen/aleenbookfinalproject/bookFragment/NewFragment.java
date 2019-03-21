package com.nassra.aleen.aleenbookfinalproject.bookFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nassra.aleen.aleenbookfinalproject.R;
import com.nassra.aleen.aleenbookfinalproject.bookListActivity;
import com.nassra.aleen.aleenbookfinalproject.data.MyBook;
import com.nassra.aleen.aleenbookfinalproject.data.NewBookAdaptor;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFragment extends Fragment {
    private ListView lstvBooks;
    private NewBookAdaptor newBookAdaptor;


    public NewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_new, container, false);
        lstvBooks=view.findViewById(R.id.lstvBooks);
        newBookAdaptor=new NewBookAdaptor(getContext(),R.layout.new_book);
        lstvBooks.setAdapter(newBookAdaptor);
        getAllbook();
        return   view;
    }
    private void getAllbook(){
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference();
        reference.child("MyBook").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                newBookAdaptor.clear();
                for (DataSnapshot d:dataSnapshot.getChildren())
                {
                    MyBook b=d.getValue(MyBook.class);
                    newBookAdaptor.add(b);
                }
                newBookAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext()  , "onCancelled", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
