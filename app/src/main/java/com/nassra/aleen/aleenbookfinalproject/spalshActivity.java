package com.nassra.aleen.aleenbookfinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class spalshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyThread myThread=new MyThread();
        myThread.start();

    }
    public class MyThread extends Thread{
        @Override
        public void run() {

                try {
                    sleep(3000);
                    Intent i=new Intent(spalshActivity.this,logInActivity.class);
                    startActivity(i);

                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }

}
