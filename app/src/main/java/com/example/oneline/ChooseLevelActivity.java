package com.example.oneline;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ChooseLevelActivity extends AppCompatActivity {
    public static int lv;
    public static Activity selfinter;
    ImageButton img;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level);
        Anhxa();
        // main menu
        selfinter = this;
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChooseLevelActivity.this, Level1Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("lvl",1);
                intent.putExtras(bundle);
                lv = 1;
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChooseLevelActivity.this, Level1Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("lvl",2);
                intent.putExtras(bundle);
                lv = 2;
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChooseLevelActivity.this, Level1Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("lvl",3);
                lv = 3;
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChooseLevelActivity.this, Level1Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("lvl",4);
                lv = 4;
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChooseLevelActivity.this, Level1Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("lvl",5);
                lv = 5;
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChooseLevelActivity.this, Level1Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("lvl",6);
                lv = 6;
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    private void Anhxa(){
        img = findViewById(R.id.backstart);
        btn1 = findViewById(R.id.level01);
        btn2 = findViewById(R.id.level02);
        btn3 = findViewById(R.id.level03);
        btn4 = findViewById(R.id.level04);
        btn5 = findViewById(R.id.level05);
        btn6 = findViewById(R.id.level06);
    }
}