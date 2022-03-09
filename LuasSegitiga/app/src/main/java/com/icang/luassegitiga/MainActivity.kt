package com.icang.luassegitiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // mendeklarasikan varibael yang dibutuhkan
    private lateinit var edtBase: EditText     // untuk nilai alas
    private lateinit var edtHeight: EditText   // untuk nilai tinggi
    private lateinit var btnCalculate: Button  // untuk menghitung luas
    private lateinit var tvResult: TextView    // hasil luas segitiga

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // inisialisasi atau memasukan id pada komponen kedalam variabel
        edtBase = findViewById(R.id.edt_alas)
        edtHeight = findViewById(R.id.edt_tinggi)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        // membuat tombol aksi pada btnCalculate untuk menghitung atau memproses luas segitiga
        btnCalculate.setOnClickListener(this)

        // membuat kondisi pada method onCreate() dimana jika savedInstanceState tidak sama dengan null
        // maka hasil yang sudah disimpan didalam variabel konstanta STATE_RESULT
        // akan di assignt ke komponen atau variabel textView tvResult
        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }

    // membuat variabel tetap (konstanta) dengan objek companion
    // variabel ini berfungsi untuk menyimpan hasil pada state ketika orientasi berubah
    companion object {
        private const val STATE_RESULT = "state_result"
    }

    // method untuk menyimpan nilai atau data jika orientasi berubah
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    // method untuk aksi tombol btnCalculate
    override fun onClick(v: View) {
        // jika id pada v sama dengan id pada btnCalculate
        if (v.id == R.id.btn_calculate) {
            // mengambil nilai dari komponen editText
            // trims() berfungsi jika terdapat spasi maka akan dihiraukan
            val inputBase = edtBase.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            // membuat variabel boolean untuk digunakan pada kondisi jika input kosong
            var isEmptyField = false

            // kondisi dimana jika input kosong
            if (inputBase.isEmpty()) {
                isEmptyField = true
                edtBase.error = "Field ini tidak boleh kosong"
            }
            if (inputHeight.isEmpty()) {
                isEmptyField = true
                edtHeight.error = "Field ini tidak boleh kosong"
            }

            // kondisi dimana jika field tidak kosong atau null maka akan menghitung rumus luas segitiga
            if (!isEmptyField) {
                val temp = 0.5
                val luasSegitiga = temp * inputBase.toDouble() * inputHeight.toDouble()
                tvResult.text = luasSegitiga.toString() // hasil dari luas segitiga
            }
        }
    }
}