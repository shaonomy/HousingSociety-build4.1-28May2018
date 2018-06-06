package com.housing_society.shaonomy.housingsociety1;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class History extends AppCompatActivity {

        Button submit;
        Spinner spinner1, spinner2, spinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        submit = (Button) findViewById(R.id.btnSubmit);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String year = String.valueOf(spinner1.getSelectedItem()) ;
                String month = String.valueOf(spinner2.getSelectedItem()) ;
                String event = String.valueOf(spinner3.getSelectedItem()) ;
                Toast.makeText(History.this, "year: "+ year +"month: "+ month +"event: "+ event,Toast.LENGTH_SHORT).show();

            }
        });

    }


}
