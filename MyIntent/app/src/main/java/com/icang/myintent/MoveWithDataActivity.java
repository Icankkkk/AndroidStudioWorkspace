package com.icang.myintent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MoveWithDataActivity extends AppCompatActivity {

    // static variable for received data from origin activity
    public static final String EXTRA_AGE = "extra_age";
    public static final String EXTRA_NAME = "extra_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);

        // create TextView component
        TextView tvDataReceived = findViewById(R.id.tv_data_received);

        // get data values by key which is passed using the getIntent().getStringExtra(key) method
        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE, 0);

        // set text
        String text = "Name : " + name + ", Your Age : " + age;
        tvDataReceived.setText(text);
    }
}