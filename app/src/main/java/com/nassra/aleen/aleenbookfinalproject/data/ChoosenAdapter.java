package com.nassra.aleen.aleenbookfinalproject.data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.nassra.aleen.aleenbookfinalproject.R;
import com.nassra.aleen.aleenbookfinalproject.bookInfoActivity;

public class ChoosenAdapter extends ArrayAdapter<MyBook> {
    public ChoosenAdapter(Context context, int resource) {
        super(context, resource);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        if (convertView==null)//to build one item
            convertView=LayoutInflater.from(getContext())
                    .inflate(R.layout.choosen,parent,false);
        //to get current data object
        final MyBook m=getItem(position);//return data object number "position"
        //get referances for eact item at the xml ui
        TextView tvItmName=convertView.findViewById(R.id.tvItmName);
        TextView tvItmWriter=convertView.findViewById(R.id.tvItmWriter);
        TextView tvItmYear=convertView.findViewById(R.id.tvItmYear);
        ImageButton btnInfo =convertView.findViewById(R.id.btnInfo);
        //put the data of the object on the view
        tvItmName.setText(m.getName());
        tvItmWriter.setText(m.getWriter());
        tvItmYear.setText(m.getYear());
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),bookInfoActivity.class);
                intent.putExtra("book",m);
                getContext().startActivity(intent);
            }
        });

        return convertView;

    }
}
