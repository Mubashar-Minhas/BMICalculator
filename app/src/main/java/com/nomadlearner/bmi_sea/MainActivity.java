package com.nomadlearner.bmi_sea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.channels.FileLock;

public class MainActivity extends AppCompatActivity {

    private Button btnCalculateBMI;
    private EditText etWeight,etHeight;

    private float BMI;
    private String bmiCategory;

    public static final String nameValue="com.nomadlearner.bmi_sea.bmiValue";
    public static final String nameCategory="com.nomadlearner.bmi_sea.bmiCategory";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoadViews();
        RegisterListeners();

    }

    private void RegisterListeners() {
        btnCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComputeResults();
                LoadResultsActivity();
            }
        });
    }

    private void ComputeResults() {
        float weight = Float.parseFloat(etWeight.getText().toString());
        float height = Float.parseFloat(etHeight.getText().toString());
        BMI = weight/height*height;

        if (BMI < 15)
            bmiCategory = "Very severely underweight";
        else if (BMI < 16)
            bmiCategory = "Severely underweight";
        else if (BMI < 18.5)
            bmiCategory = "Underweight";
        else if (BMI < 25)
            bmiCategory = "Normal";
        else if (BMI < 30)
            bmiCategory = "Overweight";
        else if (BMI < 35)
            bmiCategory = "Obese Class 1 – Moderately Obese";
        else if (BMI < 40)
            bmiCategory = "Obese Class 2 - Severely Obese";
        else
            bmiCategory = "Obese Class 3 - Very Severely Obese";
    }

    private void LoadResultsActivity() {
        Intent intent = new Intent(this,ResultsActivity.class);
        intent.putExtra(nameValue,BMI);
        intent.putExtra(nameCategory,bmiCategory);
        startActivity(intent);

    }

    private void LoadViews() {
        btnCalculateBMI = (Button)findViewById(R.id.btnCalculateBMI);
        etHeight = (EditText)findViewById(R.id.etHeight);
        etWeight = (EditText)findViewById(R.id.etWeight);
    }
}