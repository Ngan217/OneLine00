package com.example.oneline;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Level1Activity extends AppCompatActivity {
    public static Activity selfinter;
    int lvl;
    Button btnchose, btnmainmenu, btnresume;
    ImageButton menu01, iconundo01;
    ImageButton back;
    static TextView lv;
    static TextView countundo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        int s =  bundle.getInt("lvl");

        setContentView(R.layout.activity_level1);
        selfinter = this;
        menu01 = findViewById(R.id.menu01);
        lv = (TextView) findViewById(R.id.level);
        lv.setText(lv.getText()+" "+String.valueOf(s));
        countundo = findViewById(R.id.countundo01);
        lvl = s;
        back = findViewById(R.id.backoptionn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        menu01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(Gravity.CENTER);
            }
        });


    }
    Diem a;

    public void openDialog(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog);

        btnchose = dialog.findViewById(R.id.btnchoselevel);
        btnchose.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               Level1Activity.selfinter.finish();
           }
        });
        btnmainmenu = dialog.findViewById(R.id.btnmainmenu);
        btnmainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Level1Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnresume = dialog.findViewById(R.id.btnresume);
        btnresume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        Window window = dialog.getWindow();
        if(window == null) return;
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);
        dialog.show();
    }
}