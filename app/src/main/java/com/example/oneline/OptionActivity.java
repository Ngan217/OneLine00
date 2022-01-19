package com.example.oneline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;

import java.util.Locale;

public class OptionActivity extends AppCompatActivity {
ImageButton imgback, vie, us;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        imgback = findViewById(R.id.backoption);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
/*
        us = findViewById(R.id.btn_us);
        vie = findViewById(R.id.btn_vie);

        us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multilanguage("en");
            }
        });

        vie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multilanguage("vie");
            }
        });
*/
    }
    public void multilanguage(String language){
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        Intent intent = new Intent(OptionActivity.this, OptionActivity.class);
        startActivity(intent);
    }
}