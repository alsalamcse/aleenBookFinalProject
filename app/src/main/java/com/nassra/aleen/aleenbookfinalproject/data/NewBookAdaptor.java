package com.nassra.aleen.aleenbookfinalproject.data;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nassra.aleen.aleenbookfinalproject.R;
import com.nassra.aleen.aleenbookfinalproject.addBookActivity;
import com.nassra.aleen.aleenbookfinalproject.bookInfoActivity;
import com.nassra.aleen.aleenbookfinalproject.bookListActivity;
import com.nassra.aleen.aleenbookfinalproject.choosenActivity;

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
        final MyBook m=getItem(position);//return data object number "position"
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
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                    FirebaseAuth auth=FirebaseAuth.getInstance();
                    String key = reference.child(auth.getUid()).child("MyChoosen").push().getKey();
                    m.setKey(key);
                    reference.child(auth.getUid()).child("MyChoosen").child(key).setValue(m).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task1) {
                            if (task1.isSuccessful()) {
                                Toast.makeText(getContext(),"Choosen successed", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(getContext(),choosenActivity.class);
                                getContext().startActivity(i);
                            } else {
                                Toast.makeText(getContext(), "Choosen failed" + task1.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });


                }
            }
        });

        return convertView;
    }
}
