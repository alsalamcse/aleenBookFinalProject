package com.nassra.aleen.aleenbookfinalproject.bookFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nassra.aleen.aleenbookfinalproject.R;
import com.nassra.aleen.aleenbookfinalproject.bookListActivity;
import com.nassra.aleen.aleenbookfinalproject.data.MyBook;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewBookFragment extends Fragment {
    private TextView tvQues,tvWriter,tvYear,tvThem,tvRecomm;
    private EditText etWriter,etYear,etThem,etRecomm;
    private Button btnLook;


    public NewBookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_new_book, container, false);
        tvQues=view.findViewById(R.id.tvQues);
        tvWriter=view.findViewById(R.id.tvWriter);
        tvYear=view.findViewById(R.id.tvYear);
        tvThem=view.findViewById(R.id.tvThem);
        tvRecomm=view.findViewById(R.id.tvRecomm);
        etWriter=view.findViewById(R.id.etWriter);
        etYear=view.findViewById(R.id.etYear);
        etThem=view.findViewById(R.id.etThem);
        etRecomm=view.findViewById(R.id.etRecomm);
        btnLook=view.findViewById(R.id.btnLook);
        btnLook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sarchBookData();
            }
        });

        return view;
    }

    private void sarchBookData() {
        boolean isok=true;
        String writer=etWriter.getText().toString();
        String year=etYear.getText().toString();
        String them=etThem.getText().toString();
        String recomm=etRecomm.getText().toString();
        if (writer==null){
            etWriter.setError("write a name");
            isok=false;
        }
        if (year==null){
            etYear.setError("write a year");
            isok=false;
        }
        if (isok){
            Intent intent=new Intent(getContext(),ReadBookFragment.class);
            intent.putExtra("wr",writer);
            intent.putExtra("ye",year);
            intent.putExtra("th",them);
            intent.putExtra("re",recomm);
            startActivity(intent);

        }

        }
}


