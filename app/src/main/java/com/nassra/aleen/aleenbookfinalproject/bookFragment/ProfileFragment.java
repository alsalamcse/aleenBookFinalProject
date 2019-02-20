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

import com.nassra.aleen.aleenbookfinalproject.R;
import com.nassra.aleen.aleenbookfinalproject.bookListActivity;

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



        // Inflate the layout for this fragment
        return view;

    }






}