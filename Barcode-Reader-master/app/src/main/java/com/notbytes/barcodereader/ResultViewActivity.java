package com.notbytes.barcodereader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_view);

        Intent intent = getIntent();
        String xmlUID = intent.getExtras().getString("xmlUID");
        String xmlName = intent.getExtras().getString("xmlName");
        String xmlMobile = intent.getExtras().getString("xmlMobile");
        String xmlBY = intent.getExtras().getString("xmlBY");
        String xmlGender = intent.getExtras().getString("xmlGender");
        String xmlNext = intent.getExtras().getString("xmlNext");
        String xmlLocation = intent.getExtras().getString("xmlLocation");
        String xmlDistrict = intent.getExtras().getString("xmlDistrict");
        String xmlState = intent.getExtras().getString("xmlState");
        String xmlPC = intent.getExtras().getString("xmlPC");

        EditText UID = (EditText) findViewById(R.id.txtUID);
        EditText NAME = (EditText) findViewById(R.id.txtName);
        EditText MOBILE = (EditText) findViewById(R.id.txtMobile);
        EditText BY = (EditText) findViewById(R.id.txtBY);
        EditText GENDER = (EditText) findViewById(R.id.txtGender);
        EditText NEXT = (EditText) findViewById(R.id.txtNext);
        EditText LOCATION = (EditText) findViewById(R.id.txtLocation);
        EditText DISTRICT = (EditText) findViewById(R.id.txtDistrict);
        EditText STATE = (EditText) findViewById(R.id.txtState);
        EditText PC = (EditText) findViewById(R.id.txtPC);

        UID.setText(xmlUID);
        NAME.setText(xmlName);
        MOBILE.setText(xmlMobile);
        BY.setText(xmlBY);
        GENDER.setText(xmlGender);
        NEXT.setText(xmlNext);
        LOCATION.setText(xmlLocation);
        DISTRICT.setText(xmlDistrict);
        STATE.setText(xmlState);
        PC.setText(xmlPC);

        final ArrayList<String> tourTypeArrayList = new ArrayList<String>(Arrays.asList(tourType.getTourType()));
        ArrayAdapter<String> adapterTourType = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tourTypeArrayList);
        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner2.setAdapter(adapterTourType);
    }



}
