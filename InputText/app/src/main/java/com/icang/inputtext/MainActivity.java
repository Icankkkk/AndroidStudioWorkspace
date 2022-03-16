package com.icang.inputtext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText inputNama;
    public TextView outputNama;
    public Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNama = findViewById(R.id.edt_nama);
        outputNama = findViewById(R.id.tv_nama);
        submit = findViewById(R.id.btn_submit);

        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_submit) {
            String text = inputNama.getText().toString();
            outputNama.setText(text);
        }
    }
}