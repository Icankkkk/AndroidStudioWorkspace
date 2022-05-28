package com.icang.muhamadfaisal_p10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LuasSegitiga extends AppCompatActivity implements View.OnClickListener {

    EditText edtBase, edtHeight;
    TextView tvResult;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas_segitiga);

        edtBase = findViewById(R.id.edt_alas);
        edtHeight = findViewById(R.id.edt_tinggi);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null)
        {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate)
        {
            String inputBase = edtBase.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();

            boolean isEmptyField = false;

            if (TextUtils.isEmpty(inputBase)) {
                isEmptyField = true;
                edtBase.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyField = true;
                edtBase.setError("Field ini tidak boleh kosong");
            }

            if (!isEmptyField) {
                Double temp = 0.5;
                Double luasSegitiga = temp * Double.parseDouble(inputBase) * Double.parseDouble(inputHeight);
                tvResult.setText(String.valueOf(luasSegitiga));
            }
        }
    }
}