package com.nassra.aleen.aleenbookfinalproject.bookFragment;


import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nassra.aleen.aleenbookfinalproject.R;
import com.nassra.aleen.aleenbookfinalproject.bookListActivity;
import com.nassra.aleen.aleenbookfinalproject.data.MyBook;
import com.nassra.aleen.aleenbookfinalproject.data.MyProfile;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private TextView tvProfile;
    private ImageView imPic;
    private EditText etName,etFamily,etPhone,etAge;
    private Button btnList;


    public ProfileFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)

    {
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        tvProfile=view.findViewById(R.id.tvProfile);
        imPic=view.findViewById(R.id.imPic);
        etName=view.findViewById(R.id.etName);
        etFamily=view.findViewById(R.id.etFamily);
        etPhone=view.findViewById(R.id.etPhone);
        etAge=view.findViewById(R.id.etAge);
        btnList=view.findViewById(R.id.btnList);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),bookListActivity.class);
                startActivity(i);
            }
        });

getProfile();

        // Inflate the layout for this fragment
        return view;

    }

    private void getProfile(){
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference();
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        reference.child("Myprofile").child(email.replace('.','*')).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


               // DataSnapshot d=dataSnapshot.getChildren().iterator().next();
                 MyProfile p=dataSnapshot.getValue(MyProfile.class);
                etName.setText(p.getName());
                etFamily.setText(p.getFamily());
                etPhone.setText(p.getPhone());
                etAge.setText(p.getAge());


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), "onCancelled", Toast.LENGTH_SHORT).show();

            }
        });
    }




}