package com.example.mymonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    boolean isALLFieldsChecked = false;

    EditText etNRP, etPass;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSign = findViewById(R.id.sign_in);
        etNRP = findViewById(R.id.idTextInputNRP);
        etPass = findViewById(R.id.idTextInputPass);


        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isALLFieldsChecked = CheckAllFields();

                if (isALLFieldsChecked) {
                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                }
            }
        });
    }

    private boolean CheckAllFields() {
        if (etNRP.length() == 0) {
            etNRP.setError("NRP Harus Di Isi");
            return false;
        }
        if (etPass.length() == 0) {
            etPass.setError("Password NRP Harus Di Isi");
            return false;
        }
        return true;
    }
}