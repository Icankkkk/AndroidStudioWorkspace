package com.icang.muhamadfaisal_p10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Logika extends AppCompatActivity implements View.OnClickListener {

    TextView tvNilaiHasil, tvGrade;
    EditText edtInputNilai;
    Button btLogika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logika);
        tvNilaiHasil = findViewById(R.id.tv_nilai_result);
        tvGrade = findViewById(R.id.tv_grade_result);
        edtInputNilai = findViewById(R.id.edt_nilai);
        btLogika = findViewById(R.id.btn_logic);
        btLogika.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_logic) {
            double nilai = Double.parseDouble(edtInputNilai.getText().toString());
            if ( nilai >= 80) {
                tvNilaiHasil.setText(Double.toString(nilai));
                tvGrade.setText("A");
            } else {
                tvNilaiHasil.setText(Double.toString(nilai));
                tvGrade.setText("B");
            }
        }
    }
}