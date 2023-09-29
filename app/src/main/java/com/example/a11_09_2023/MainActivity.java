package com.example.a11_09_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
TextView tvdisplay;
RadioGroup radioGroup;
RadioButton rbmale,rbfemale,radioButton;
SeekBar seekBar;
Spinner spinner;
String[] courses = {"bsc cs","bsc ds","bsc it"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvdisplay = findViewById(R.id.tvGender);
        radioGroup = findViewById(R.id.rbGroup);
        rbmale = findViewById(R.id.rbMale);
        rbfemale = findViewById(R.id.rbFemale);
        seekBar = findViewById(R.id.seekBar);
        spinner = findViewById( R.id.spinner);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                radioButton = findViewById(i);
                String selectedOption = radioButton.getText().toString();
                tvdisplay.setText(selectedOption + " is Selected..");
            }
        });
        seekBar.setOnSeekBarChangeListener(this);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,courses);
        spinner.setAdapter(ad);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String SelectedCourse = ad.getItem(i).toString();
                Toast.makeText(getApplicationContext(),"Selected course is "+SelectedCourse,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        tvdisplay.setTextSize(i);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}