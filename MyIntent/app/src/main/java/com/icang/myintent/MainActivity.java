package com.icang.myintent;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResult;  // global variable
    final ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
        result -> {
            if (result.getResultCode() == MoveForResultActivity.RESULT_CODE && result.getData() != null) {
                int selectedValue = result.getData().getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.move_activity);
        Button btnMoveWithData = findViewById(R.id.move_activity_with_data);
        Button btnMoveWithObject = findViewById(R.id.btn_move_activity_object);
        Button btnDialNumber = findViewById(R.id.btn_dial_number);
        Button btnMoveForResult = findViewById(R.id.btn_move_for_result);

        tvResult = findViewById(R.id.tv_result);

        btnMoveActivity.setOnClickListener(this);
        btnMoveWithData.setOnClickListener(this);
        btnMoveWithObject.setOnClickListener(this);
        btnDialNumber.setOnClickListener(this);
        btnMoveForResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.move_activity) {
            Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
            startActivity(moveIntent);
        }
        else if (view.getId() == R.id.move_activity_with_data) {
            Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Icang");
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 21);
            startActivity(moveWithDataIntent);
        }
        else if (view.getId() == R.id.btn_move_activity_object) {
            // create new object of Person class
            Person person = new Person();

            // set data to object with setter method
            person.setName("Faisal");
            person.setAge(21);
            person.setEmail("muhamadfaisal280201@gmail.com");
            person.setCity("Bogor");

            // create Intent variable
            Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
            // get data value using putExtra() method
            moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person);
            // call startActivity() method
            startActivity(moveWithObjectIntent);
        }
        else if (view.getId() == R.id.btn_dial_number) {
            String phoneNumber = "08156283541";
            Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(dialPhoneIntent);
        }
        else if (view.getId() == R.id.btn_move_for_result) {
            Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
            resultLauncher.launch(moveForResultIntent);
        }
    }
}