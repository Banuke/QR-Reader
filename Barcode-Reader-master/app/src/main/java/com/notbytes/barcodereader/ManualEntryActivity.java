package com.notbytes.barcodereader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.Arrays;

public class ManualEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_entry);

        final ArrayList<String> countryArrayList = new ArrayList<String>(Arrays.asList(CountryDetails.getCountry()));
        ArrayAdapter<String> adapterCountry = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countryArrayList);
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner1.setAdapter(adapterCountry);

        /*spinner1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("mytag",countryArrayList.get(i));
            }
        });*/

        final ArrayList<String> tourTypeArrayList = new ArrayList<String>(Arrays.asList(tourType.getTourType()));
        ArrayAdapter<String> adapterTourType = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tourTypeArrayList);
        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner2.setAdapter(adapterTourType);

    }

}