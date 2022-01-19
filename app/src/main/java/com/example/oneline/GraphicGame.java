package com.example.oneline;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import java.util.Stack;

public class GraphicGame extends View {
    Paint p1,p2,p3;
    boolean dia = false;
    int x_mouse = 0;
    int y_mouse = 0;
    boolean win;
    int count = 2;
    boolean StartGame = false;
    Hinh test = new Hinh();
    Diem Start = null, End = null;

    int lv = ChooseLevelActivity.lv;
    Stack<Diem> Diemdiqua = new Stack<>();

    public GraphicGame(Context context) throws NoSuchFieldException {
        super(context);
    }
    public GraphicGame(Context context, @Nullable AttributeSet attrs) throws NoSuchFieldException {
        super(context, attrs);
        init(lv);

    }
    public GraphicGame(Context context, @Nullable AttributeSet attrs, int defStyleAttr) throws NoSuchFieldException {
        super(context, attrs, defStyleAttr);
    }
    private void init(int lv){
        p1 = new Paint();
        p1.setColor(Color.rgb(0,0,0));
        p1.setStyle(Paint.Style.FILL);
        p1.setStrokeWidth(15);

        p2 = new Paint();
        p2.setColor(Color.rgb(255,0,0));
        p2.setStrokeWidth(15);
        p2.setStyle(Paint.Style.FILL);

        p3 = new Paint();
        p3.setColor(Color.rgb(255,219,15));
        p3.setStrokeWidth(20);
        initH(lv);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x_mouse = (int) event.getX();
        y_mouse = (int) event.getY();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (x_mouse != 0 && y_mouse != 0){
            for (Diem d :
                    test.MangDiem) {
                if (d.check(x_mouse,y_mouse)){
                    if (Start == null){
                        Start = d;
                        StartGame = true;
                        Diemdiqua.push(Start);
                    }else {
                        End = d;
                    }
                    x_mouse = 0;
                    y_mouse = 0;
                }

            }
        }

        if (Start!=null && End!=null){
            for (Canh c :
                    test.MangCanh) {
                if (c.dau == Start || c.cuoi == Start){
                    if ((Start == c.dau && End == c.cuoi)||(Start == c.cuoi && End == c.dau)){
                        if (c.succ == false){
                            c.succ = true;
                            Start = End;
                            End = null;
                            Diemdiqua.push(Start);
                        }
                        else{
                            //thong bao khong ve trung len
                            Toast.makeText(Level1Activity.selfinter, "This line has already drawed", Toast.LENGTH_SHORT).show();
                            End = null;
                        }
                    }
                }
            }
        }
        Draw(canvas,p1,p2,test);
        try {
            CheckGameOver(Start,test,canvas,p1,StartGame);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Level1Activity.selfinter.findViewById(R.id.iconundo01).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count != 0){
                    if(Diemdiqua.size() >= 2){
                        Diem _s = Diemdiqua.peek();
                        Diemdiqua.pop();
                        Diem _e = Diemdiqua.peek();
                        for (Canh c: test.MangCanh
                        ) {
                            if ((c.dau == _e && c.cuoi ==_s)||(c.cuoi == _e &&c.dau == _s)){
                                c.succ = false;
                            }
                        }
                        Start = Diemdiqua.peek();
                        count--;
                    }else
                    if (Diemdiqua.size() == 1){
                        Diemdiqua.pop();
                        Start = null;
                        count--;
                        StartGame = false;
                    }
                    Level1Activity.countundo.setText(String.valueOf(count));
                }
            }
        });
        if (Start !=null){
            canvas.drawCircle(Start.x,Start.y,25,p3);
        }
        invalidate();
    }


    public void Draw(Canvas canvas,Paint p1,Paint p2, Hinh a){
        for (Canh c:a.MangCanh
             ) {
            if (c.succ == true){
                canvas.drawLine(c.dau.x,c.dau.y,c.cuoi.x,c.cuoi.y,p2);
            }else{
                canvas.drawLine(c.dau.x,c.dau.y,c.cuoi.x,c.cuoi.y,p1);
            }
        }
    }
    public void CheckGameOver(Diem d, Hinh h,Canvas canvas,Paint p,boolean s) throws InterruptedException {
        boolean flg = true;
        win = true;
        for (Canh c :
                h.MangCanh) {
            if (c.dau == d || c.cuoi == d){
                if (c.succ == false){
                    flg = false;
                    break;
                }
            }
        }
        if (flg){
            if (s == true){
                GameOver(h,canvas,p);
            }
//
        }

        for (Canh c: h.MangCanh
        ) {
            if (c.succ == false){
                win = false;
                break;
            }
        }
        if (s == true && win == true){
//            android.os.Process.killProcess(android.os.Process.myPid());
            //xu ly chien thang
            if (dia == false){
                openDialogWin(Gravity.CENTER, getContext());
                dia = true;
            }

        }
    }

    private  void GameOver(Hinh h,Canvas canvas,Paint p){
        boolean flg = true;
        for (Canh c : h.MangCanh) {
            if (!c.succ){
                flg = false;
                break;
            }
        }

        if (!flg){
            //Thong bao thua cuoc
            if(dia == false){
                dia = true;
                openDialogLose(Gravity.CENTER, getContext());
            }
        }
    }
    public void openDialogWin(int gravity, Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setMessage("congratulation \nLevel Passed").setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                x_mouse = 0;
                y_mouse = 0;
                Start = null;
                End = null;
                dia = false;
                win = false;
                StartGame = false;
                test = new Hinh();
                lv = lv+1;
                count = 2;
                Level1Activity.countundo.setText(String.valueOf(count));
                init(lv);
                Level1Activity.lv.setText("Level "+String.valueOf(lv));
            }
        }).setNegativeButton("Chose Level", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Level1Activity.selfinter.finish();
            }
        });
        builder.create().show();
    }
    public void openDialogLose(int gravity, Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setMessage("Level Failed").setPositiveButton("Retry", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                x_mouse = 0;
                y_mouse = 0;
                Start = null;
                End = null;
                dia = false;
                win = false;
                StartGame = false;
                test = new Hinh();
                count = 2;
                Level1Activity.countundo.setText(String.valueOf(count));
                init(lv);
                Level1Activity.lv.setText("Level "+String.valueOf(lv));
            }
        }).setNegativeButton("Chose Level", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Level1Activity.selfinter.finish();
            }
        });
        builder.create().show();
    }

    //// Ve Hinh
    private void initH(int lv){
        if (lv == 1){
            Diem _1 = new Diem(50,50);
            Diem _2 = new Diem(350,50);
            Diem _3 = new Diem(200,200);
            Diem _4 = new Diem(50,350);
            Diem _5 = new Diem(350,350);

            test.MangDiem.add(_1);
            test.MangDiem.add(_2);
            test.MangDiem.add(_3);
            test.MangDiem.add(_4);
            test.MangDiem.add(_5);

            test.MangCanh.add(new Canh(_1,_2));
            test.MangCanh.add(new Canh(_2,_3));
            test.MangCanh.add(new Canh(_3,_4));
            test.MangCanh.add(new Canh(_4,_5));
            test.MangCanh.add(new Canh(_5,_3));
            test.MangCanh.add(new Canh(_3,_1));

        }
        else if (lv == 2){
            Diem _1 = new Diem(50,50);
            Diem _2 = new Diem(50,350);
            Diem _3 = new Diem(350,200);
            Diem _4 = new Diem(155,200);

            test.MangDiem.add(_1);
            test.MangDiem.add(_2);
            test.MangDiem.add(_3);
            test.MangDiem.add(_4);

            test.MangCanh.add(new Canh(_1,_2));
            test.MangCanh.add(new Canh(_2,_3));
            test.MangCanh.add(new Canh(_3,_1));
            test.MangCanh.add(new Canh(_1,_4));
            test.MangCanh.add(new Canh(_4,_2));

        }else if (lv ==3){
            Diem _1 = new Diem(50,200);
            Diem _2 = new Diem(200,50);
            Diem _3 = new Diem(350,200);
            Diem _4 = new Diem(200,350);
            Diem _5 = new Diem(50,350);
            Diem _6 = new Diem(350,350);
            Diem _7 = new Diem(350,50);
            Diem _8 = new Diem(50,50);


            test.MangDiem.add(_1);
            test.MangDiem.add(_2);
            test.MangDiem.add(_3);
            test.MangDiem.add(_4);
            test.MangDiem.add(_5);
            test.MangDiem.add(_6);
            test.MangDiem.add(_7);
            test.MangDiem.add(_8);

            test.MangCanh.add(new Canh(_1,_2));
            test.MangCanh.add(new Canh(_2,_3));
            test.MangCanh.add(new Canh(_3,_4));
            test.MangCanh.add(new Canh(_4,_1));
            test.MangCanh.add(new Canh(_1,_5));
            test.MangCanh.add(new Canh(_5,_4));
            test.MangCanh.add(new Canh(_4,_6));
            test.MangCanh.add(new Canh(_6,_3));
            test.MangCanh.add(new Canh(_3,_7));
            test.MangCanh.add(new Canh(_7,_2));
            test.MangCanh.add(new Canh(_2,_8));
            test.MangCanh.add(new Canh(_8,_1));

        } else if (lv == 4) {
            Diem _1 = new Diem(200,30);
            Diem _2 = new Diem(60,150);
            Diem _3 = new Diem(350,150);
            Diem _4 = new Diem(200,260);
            Diem _5 = new Diem(60,370);
            Diem _6 = new Diem(350,370);

            test.MangDiem.add(_1);
            test.MangDiem.add(_2);
            test.MangDiem.add(_3);
            test.MangDiem.add(_4);
            test.MangDiem.add(_5);
            test.MangDiem.add(_6);

            test.MangCanh.add(new Canh(_1,_2));
            test.MangCanh.add(new Canh(_1,_3));
            test.MangCanh.add(new Canh(_2,_3));
            test.MangCanh.add(new Canh(_2,_4));
            test.MangCanh.add(new Canh(_2,_5));
            test.MangCanh.add(new Canh(_3,_4));
            test.MangCanh.add(new Canh(_3,_6));
            test.MangCanh.add(new Canh(_4,_5));
            test.MangCanh.add(new Canh(_4,_6));
            test.MangCanh.add(new Canh(_5,_6));
        } else if(lv == 5){
            Diem _1 = new Diem(10,310);
            Diem _2 = new Diem(10,130);
            Diem _3 = new Diem(128,130);
            Diem _4 = new Diem(236,130);
            Diem _5 = new Diem(360,130);
            Diem _6 = new Diem(360,310);
            Diem _7 = new Diem(230,310);
            Diem _8 = new Diem(132,310);
            Diem _9 = new Diem(180,380);
            Diem _10 = new Diem(296,218);
            Diem _11 = new Diem(180,50);
            Diem _12 = new Diem(70,218);

            test.MangDiem.add(_1);
            test.MangDiem.add(_2);
            test.MangDiem.add(_3);
            test.MangDiem.add(_4);
            test.MangDiem.add(_5);
            test.MangDiem.add(_6);
            test.MangDiem.add(_7);
            test.MangDiem.add(_8);
            test.MangDiem.add(_9);
            test.MangDiem.add(_10);
            test.MangDiem.add(_11);
            test.MangDiem.add(_12);

            test.MangCanh.add(new Canh(_1,_2));
            test.MangCanh.add(new Canh(_2,_3));
            test.MangCanh.add(new Canh(_3,_4));
            test.MangCanh.add(new Canh(_4,_5));
            test.MangCanh.add(new Canh(_5,_6));
            test.MangCanh.add(new Canh(_6,_7));
            test.MangCanh.add(new Canh(_7,_8));
            test.MangCanh.add(new Canh(_8,_1));
            test.MangCanh.add(new Canh(_1,_9));
            test.MangCanh.add(new Canh(_9,_7));
            test.MangCanh.add(new Canh(_7,_10));
            test.MangCanh.add(new Canh(_10,_5));
            test.MangCanh.add(new Canh(_5,_11));
            test.MangCanh.add(new Canh(_11,_2));
            test.MangCanh.add(new Canh(_2,_12));
            test.MangCanh.add(new Canh(_12,_8));
            test.MangCanh.add(new Canh(_8,_9));
            test.MangCanh.add(new Canh(_9,_6));
            test.MangCanh.add(new Canh(_6,_10));
            test.MangCanh.add(new Canh(_10,_4));
            test.MangCanh.add(new Canh(_4,_11));
            test.MangCanh.add(new Canh(_1,_12));
            test.MangCanh.add(new Canh(_12,_3));
            test.MangCanh.add(new Canh(_3,_11));
        } else if(lv == 6) {
            Diem _1 = new Diem(50,250);
            Diem _2 = new Diem(50,50);
            Diem _3 = new Diem(120,190);
            Diem _4 = new Diem(200,350);
            Diem _5 = new Diem(200,120);
            Diem _6 = new Diem(280,190);
            Diem _7 = new Diem(350,250);
            Diem _8 = new Diem(350,50);

            test.MangDiem.add(_1);
            test.MangDiem.add(_2);
            test.MangDiem.add(_3);
            test.MangDiem.add(_4);
            test.MangDiem.add(_5);
            test.MangDiem.add(_6);
            test.MangDiem.add(_7);
            test.MangDiem.add(_8);

            test.MangCanh.add(new Canh(_1,_2));
            test.MangCanh.add(new Canh(_2,_3));
            test.MangCanh.add(new Canh(_3,_1));
            test.MangCanh.add(new Canh(_1,_4));
            test.MangCanh.add(new Canh(_4,_3));
            test.MangCanh.add(new Canh(_3,_5));
            test.MangCanh.add(new Canh(_5,_6));
            test.MangCanh.add(new Canh(_6,_4));
            test.MangCanh.add(new Canh(_4,_7));
            test.MangCanh.add(new Canh(_7,_8));
            test.MangCanh.add(new Canh(_8,_6));
            test.MangCanh.add(new Canh(_6,_7));
        }
    }
}
