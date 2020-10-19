package com.nomadlearner.bmi_sea;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.net.Inet4Address;

public class ResultsActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        String category = intent.getStringExtra(MainActivity.nameCategory);
        float bmiVal = intent.getFloatExtra(MainActivity.nameValue,0);
        final EditText BMIResult = (EditText)
                findViewById(R.id.etBmiShow);
        BMIResult.setText(Float.toString(bmiVal));
        final TextView BMICategory = (TextView)
                findViewById(R.id.BMI_Cat);
        BMICategory.setText(category);

    }
}