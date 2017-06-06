package com.example.root.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.Intent;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.Arrays;

public class TimeTableFillActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ArrayAdapter<String> adapter_staff;
    ArrayAdapter<String> adapter_day;
    ArrayAdapter<String> adapter_time;
    final String subject_code_map[]={"Subject 1 - 001","Subject 2 - 002","Subject 3 - 003","Subject 4 - 004","Subject 5 - 005"};
    final String Staff[]={"A","B","C","D","E"};
    final String Days[]={"Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday"};
    final String Time[]={"TimeSlot1","TimeSlot2","TimeSlot3","TimeSlot4","TimeSlot5"};
    String Selection[] = {" "," "," "," "};
    Spinner spinner_1_staff,spinner_1_day,spinner_1_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table_fill);
        spinner_1_staff = (Spinner) findViewById(R.id.spinner_staff);
        spinner_1_day = (Spinner) findViewById(R.id.spinner_day);
        spinner_1_time = (Spinner) findViewById(R.id.spinner_time);

        adapter_staff =    new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,Staff);
        adapter_staff.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_1_staff.setAdapter(adapter_staff);
        spinner_1_staff.setOnItemSelectedListener(this);

        adapter_day =    new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,Days);
        adapter_day.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_1_day.setAdapter(adapter_day);
        spinner_1_day.setOnItemSelectedListener(this);

        adapter_time =    new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,Time);
        adapter_time.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_1_time.setAdapter(adapter_time);
        spinner_1_time.setOnItemSelectedListener(this);
    }

    public void entered_subject_1(View view) {
        Selection[0] = subject_code_map[0];
        Toast.makeText(this,subject_code_map[0], Toast.LENGTH_SHORT).show();
    }

    public void entered_subject_2(View view) {
        Selection[0] = subject_code_map[1];
        Toast.makeText(this,subject_code_map[1], Toast.LENGTH_SHORT).show();
    }

    public void entered_subject_3(View view) {
        Selection[0] = subject_code_map[2];
        Toast.makeText(this, subject_code_map[2], Toast.LENGTH_SHORT).show();
    }

    public void entered_subject_4(View view) {
        Selection[0] = subject_code_map[3];
        Toast.makeText(this, subject_code_map[3], Toast.LENGTH_SHORT).show();
    }

    public void entered_subject_5(View view) {
        Selection[0] = subject_code_map[4];
        Toast.makeText(this, subject_code_map[4], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Selection[1] = "Staff:" + spinner_1_staff.getSelectedItem().toString();

        Selection[2] = "Day:" + spinner_1_day.getSelectedItem().toString();

        Selection[3] = "Time:" + spinner_1_time.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getApplicationContext(),"Please make proper choice", Toast.LENGTH_SHORT).show();

    }

    public void finalize(View view) {
        String Data = Arrays.toString(Selection);
        Toast.makeText(getApplicationContext(),Data, Toast.LENGTH_LONG).show();
        Intent refresh = new Intent(this, TimeTableFillActivity.class);
        startActivity(refresh);
    }
}
