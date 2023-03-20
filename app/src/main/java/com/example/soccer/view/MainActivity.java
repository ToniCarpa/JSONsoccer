package com.example.soccer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.soccer.R;
import com.example.soccer.adapter.AdapterCountry;
import com.example.soccer.model.Country;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String JSON_URL = "com.example.edt19.EXTRA_TEXT_NAME";

    private Spinner spinner;
    private AdapterCountry adapterCountry;
    private ArrayList<Country> listCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayCountry();

        //HOOK
        spinner = findViewById(R.id.spinnerMain);
        adapterCountry = new AdapterCountry(this, listCountry);
        spinner.setAdapter(adapterCountry);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Country item = (Country) adapterView.getItemAtPosition(i);
                String itemName = item.getName();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(JSON_URL, itemName);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Select Country", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void arrayCountry(){
        listCountry = new ArrayList<>();
        listCountry.add(new Country(getString(R.string.spain), R.drawable.spain));
        listCountry.add(new Country(getString(R.string.argentina), R.drawable.argentina));
        listCountry.add(new Country(getString(R.string.australia), R.drawable.australia));
        listCountry.add(new Country(getString(R.string.canada), R.drawable.canada));
        listCountry.add(new Country(getString(R.string.congo), R.drawable.congo));
        listCountry.add(new Country(getString(R.string.uk), R.drawable.uk));
        listCountry.add(new Country(getString(R.string.uk), R.drawable.egypt));
        listCountry.add(new Country(getString(R.string.uk), R.drawable.france));
        listCountry.add(new Country(getString(R.string.uk), R.drawable.germany));
        listCountry.add(new Country(getString(R.string.uk), R.drawable.greece));
        listCountry.add(new Country(getString(R.string.uk), R.drawable.india));
        listCountry.add(new Country(getString(R.string.uk), R.drawable.indonesia));
        listCountry.add(new Country(getString(R.string.uk), R.drawable.mexico));
        listCountry.add(new Country(getString(R.string.uk), R.drawable.newzeland));
        listCountry.add(new Country(getString(R.string.uk), R.drawable.italy));
        listCountry.add(new Country(getString(R.string.uk), R.drawable.ireland));
    }
}