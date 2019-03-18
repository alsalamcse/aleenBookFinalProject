package com.nassra.aleen.aleenbookfinalproject.data;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class NewBookAdaptor extends ArrayAdapter<MyBook> {
    public NewBookAdaptor( Context context, int resource) {
        super(context, resource);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        if (convertView==null);
        return super.getView(position, convertView, parent);
    }
}
