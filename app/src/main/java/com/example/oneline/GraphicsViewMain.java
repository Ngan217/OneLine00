package com.example.oneline;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GraphicsViewMain extends View {
    Paint p;
    Paint p1;
    public GraphicsViewMain(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GraphicsViewMain(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public GraphicsViewMain(Context context) {
        super(context);
    }

    private void init(){
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(10);
        p.setStyle(Paint.Style.STROKE);
        p.setTextSize(150);

        p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setColor(Color.WHITE);
        p1.setStrokeWidth(10);
        p1.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
    /*
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int desiredWidth = getSuggestedMinimumWidth();
        int desiredHeight = getSuggestedMinimumHeight();
        setMeasuredDimension(resolveSize(desiredWidth, widthMeasureSpec),resolveSize(desiredHeight, heightMeasureSpec));

    }
    */
    /*
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //desiredWidth: dựa vào nội dung muốn hiển thị mà bạn sẽ tính ra bạn cần tối thiểu bao nhiêu
        //không gian để bạn hiển thị
        int desiredWidth = 1000;
        int desiredHeight = 1000;
        int width, height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(desiredWidth, widthSize);
        } else {
            width = desiredWidth;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = Math.min(desiredHeight, heightSize);
        } else {
            height = heightSize;
        }
        setMeasuredDimension(width,height);
    }
    */


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Draw component in here
        //diem
        /*
        float r = 50;
        float r1 = 40;
        int x = 200;
        int y = 250;
        canvas.drawCircle(x , y+50, r, p);// diem 1
        canvas.drawPoint(x , y+50, p);
        canvas.drawCircle(x , y+50, r1, p1);
        canvas.drawCircle(x + 600 , y - 50, r, p); // diem 2
        canvas.drawPoint(x + 600 , y - 50, p);
        canvas.drawCircle(x + 600 , y - 50, r1, p1);
        canvas.drawLine(x, y +50, x +600, y - 50, p); // line 1 to 2
        canvas.drawCircle(x + 1050 , y + 550, r, p); // diem 3
        canvas.drawPoint(x + 1050 , y + 550, p);
        canvas.drawCircle(x + 1050 , y + 550, r1, p1);
        canvas.drawCircle(x + 1000 , y + 1000, r, p); // diem 4
        canvas.drawPoint(x + 1000 , y + 1000, p);
        canvas.drawCircle(x + 1000 , y + 1000, r1, p1);
        canvas.drawLine(x + 1050, y +550, x + 1000, y + 1000, p); // line 3 to 4
        canvas.drawLine(x, y +50, x + 1000, y + 1000, p); // line 1 to 4
        canvas.drawCircle(x+ 100, y + 1850, r, p);// diem 5
        canvas.drawPoint(x+ 100, y + 1850, p);
        canvas.drawCircle(x+ 100, y + 1850, r1, p1);
        canvas.drawLine(x + 1050 , y + 550, x+ 100, y + 1850, p); // line 3 to 5
        canvas.drawLine(x + 600 , y - 50, x+ 100, y + 1850, p); // line 2 to 5
        */
        /*
        float r = 50;
        float r1 = 40;
        canvas.drawCircle(getWidth()- 1300 ,getHeight() - 1900 , r, p);// diem 1
        canvas.drawPoint(getWidth()- 1300 ,getHeight() - 1900, p);
        canvas.drawCircle(getWidth()- 1300 ,getHeight() - 1900, r1, p1);
        canvas.drawCircle(getWidth()-650 , getHeight()-2050, r, p); // diem 2
        canvas.drawPoint(getWidth()-650 , getHeight()-2050, p);
        canvas.drawCircle(getWidth()-650 , getHeight()-2050, r1, p1);
        canvas.drawCircle(getWidth()-200 , getHeight()-1500, r, p); // diem 3
        canvas.drawPoint(getWidth()-200 , getHeight()-1500, p);
        canvas.drawCircle(getWidth()-200 , getHeight()-1500, r1, p1);
        canvas.drawCircle(getWidth()-290 , getHeight()-800, r, p); // diem 4
        canvas.drawPoint(getWidth()-290 , getHeight()-800, p);
        canvas.drawCircle(getWidth()-290 , getHeight()-800, r1, p1);
        canvas.drawCircle(getWidth()-1000 , getHeight()-350, r, p);// diem 5
        canvas.drawPoint(getWidth()-1000 , getHeight()-350, p);
        canvas.drawCircle(getWidth()-1000 , getHeight()-350, r1, p1);

        canvas.drawLine(getWidth()- 1300 ,getHeight() - 1900, getWidth()-650 , getHeight()-2050, p); // line 1 to 2
        canvas.drawLine(getWidth()-200 , getHeight()-1500, getWidth()-290 , getHeight()-800, p); // line 3 to 4
        canvas.drawLine(getWidth()- 1300 ,getHeight() - 1900, getWidth()-290 , getHeight()-800, p); // line 1 to 4
        canvas.drawLine(getWidth()-200 , getHeight()-1500, getWidth()-1000 , getHeight()-350, p); // line 3 to 5
        canvas.drawLine(getWidth()-650 , getHeight()-2050, getWidth()-1000 , getHeight()-350, p); // line 2 to 5
        */
        float r = 50;
        float r1 = 40;
        float r2 = 300;
        float r3 = 290;
        canvas.drawCircle(getMeasuredWidth() - getMeasuredWidth()*7/8 ,getMeasuredHeight() - getMeasuredHeight()*7/8 , r, p);// diem 1
        canvas.drawPoint(getMeasuredWidth() - getMeasuredWidth()*7/8 ,getMeasuredHeight() - getMeasuredHeight()*7/8, p);
        canvas.drawCircle(getMeasuredWidth() - getMeasuredWidth()*7/8 ,getMeasuredHeight() - getMeasuredHeight()*7/8, r1, p1);
        canvas.drawCircle(getMeasuredWidth() - getMeasuredWidth()*4/9, getMeasuredHeight() - getMeasuredHeight()*15/16, r, p); // diem 2
        canvas.drawPoint(getMeasuredWidth() - getMeasuredWidth()*4/9, getMeasuredHeight() - getMeasuredHeight()*15/16, p);
        canvas.drawCircle(getMeasuredWidth() - getMeasuredWidth()*4/9, getMeasuredHeight() - getMeasuredHeight()*15/16, r1, p1);
        canvas.drawCircle(getMeasuredWidth() - getMeasuredWidth()*1/8, getMeasuredHeight() - getMeasuredHeight()*2/3, r, p); // diem 3
        canvas.drawPoint(getMeasuredWidth() - getMeasuredWidth()*1/8, getMeasuredHeight() - getMeasuredHeight()*2/3, p);
        canvas.drawCircle(getMeasuredWidth() - getMeasuredWidth()*1/8, getMeasuredHeight() - getMeasuredHeight()*2/3, r1, p1);
        canvas.drawCircle(getMeasuredWidth() - getMeasuredWidth()*3/16, getMeasuredHeight() - getMeasuredHeight()*2/5, r, p); // diem 4
        canvas.drawPoint(getMeasuredWidth() - getMeasuredWidth()*3/16, getMeasuredHeight() - getMeasuredHeight()*2/5, p);
        canvas.drawCircle(getMeasuredWidth() - getMeasuredWidth()*3/16, getMeasuredHeight() - getMeasuredHeight()*2/5, r1, p1);
        canvas.drawCircle(getMeasuredWidth() - getMeasuredWidth()*3/4, getMeasuredHeight() - getMeasuredHeight()*1/8, r, p); // diem 5
        canvas.drawPoint(getMeasuredWidth() - getMeasuredWidth()*3/4, getMeasuredHeight() - getMeasuredHeight()*1/8, p);
        canvas.drawCircle(getMeasuredWidth() - getMeasuredWidth()*3/4, getMeasuredHeight() - getMeasuredHeight()*1/8, r1, p1);

        canvas.drawCircle(getMeasuredWidth()-100, 100, r2, p);
        canvas.drawCircle(getMeasuredWidth()-100, 100, r3, p1);
        canvas.drawCircle(getMeasuredWidth()-100, getMeasuredHeight()-100 , r2, p);
        canvas.drawCircle(getMeasuredWidth()-100, getMeasuredHeight()-100 , r3, p1);

        canvas.drawLine(getMeasuredWidth() - getMeasuredWidth()*7/8 ,getMeasuredHeight() - getMeasuredHeight()*7/8 , getMeasuredWidth() - getMeasuredWidth()*4/9, getMeasuredHeight() - getMeasuredHeight()*15/16, p); // line 1 to 2
        canvas.drawLine(getMeasuredWidth() - getMeasuredWidth()*1/8, getMeasuredHeight() - getMeasuredHeight()*2/3, getMeasuredWidth() - getMeasuredWidth()*3/16, getMeasuredHeight() - getMeasuredHeight()*2/5, p); // line 3 to 4
        canvas.drawLine(getMeasuredWidth() - getMeasuredWidth()*7/8 ,getMeasuredHeight() - getMeasuredHeight()*7/8, getMeasuredWidth() - getMeasuredWidth()*3/16, getMeasuredHeight() - getMeasuredHeight()*2/5, p); // line 1 to 4
        canvas.drawLine(getMeasuredWidth() - getMeasuredWidth()*1/8, getMeasuredHeight() - getMeasuredHeight()*2/3, getMeasuredWidth() - getMeasuredWidth()*3/4, getMeasuredHeight() - getMeasuredHeight()*1/8, p); // line 3 to 5
        canvas.drawLine(getMeasuredWidth() - getMeasuredWidth()*4/9, getMeasuredHeight() - getMeasuredHeight()*15/16, getMeasuredWidth() - getMeasuredWidth()*3/4, getMeasuredHeight() - getMeasuredHeight()*1/8, p); // line 2 to 5
    }

}
