package com.icang.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {

    // create variable static for a key by getParcelableExtra() method
    public static final String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        // create TextView component
        TextView tvObject = findViewById(R.id.tv_object_received);
        // create object from class Person
        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        // set text
        String text = "Name : " + person.getName() + ",\nEmail : " + person.getEmail() + ",\nAge : " + person.getAge() + ",\nLocation : " + person.getCity();
        tvObject.setText(text);
    }
}