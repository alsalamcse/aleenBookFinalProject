package com.nassra.aleen.aleenbookfinalproject.data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import com.nassra.aleen.aleenbookfinalproject.R;
import com.nassra.aleen.aleenbookfinalproject.bookInfoActivity;

public class NewBookAdaptor extends ArrayAdapter<MyBook> {
    public NewBookAdaptor( Context context, int resource) {
        super(context, resource);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        if (convertView==null)
            convertView=LayoutInflater.from(getContext())
                    .inflate(R.layout.new_book,parent,false);
        //to get current data object
        MyBook m=getItem(position);//return data object number "position"
        //get referances for eact item at the xml ui
        TextView tvWriter4=convertView.findViewById(R.id.tvWriter4);
        TextView tvYear4=convertView.findViewById(R.id.tvYear4);
        CheckBox cbName=convertView.findViewById(R.id.cbName);

        //put the data of the object on the view
        cbName.setText(m.getName());
        tvWriter4.setText(m.getWriter());
        tvYear4.setText(m.getYear());
        cbName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){

                }
            }
        });

        return convertView;
    }
}
