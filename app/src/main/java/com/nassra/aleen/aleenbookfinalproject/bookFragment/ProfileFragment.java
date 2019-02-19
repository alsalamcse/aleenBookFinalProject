package com.nassra.aleen.aleenbookfinalproject.bookFragment;


import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.nassra.aleen.aleenbookfinalproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private TextView tvProfile;
    private ImageView imPic;
    private EditText etName,etFamily,etPhone,etAge;


    public ProfileFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)

    {
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        tvProfile=view.findViewById(R.id.tvProfile);


        // Inflate the layout for this fragment
        return view;

    }



}