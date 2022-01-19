package com.example.oneline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class GraphicsViewOption extends View {
    Paint p,p1,p2;
    public GraphicsViewOption(Context context) {
        super(context);
    }

    public GraphicsViewOption(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GraphicsViewOption(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(10);
        p.setStyle(Paint.Style.STROKE);

        p1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setColor(Color.WHITE);
        p1.setStrokeWidth(10);
        p1.setStyle(Paint.Style.FILL_AND_STROKE);

        p2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        p2.setColor(Color.WHITE);
        p2.setStrokeWidth(15);
        p2.setStyle(Paint.Style.FILL_AND_STROKE);
    }
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
    @Override
    protected void onDraw(Canvas canvas){
        float r2 = 200;
        float r3 = 190;
        canvas.drawCircle(getMeasuredWidth()-100, 100, r2, p);
        canvas.drawCircle(getMeasuredWidth()-100, 100, r3, p1);
        canvas.drawCircle(getMeasuredWidth()-100, getMeasuredHeight()-100 , r2, p);
        canvas.drawCircle(getMeasuredWidth()-100, getMeasuredHeight()-100 , r3, p1);

        canvas.drawLine(getMeasuredWidth() - getMeasuredWidth()*14/15, 300, getMeasuredWidth() - 250, 300, p2);
    }
}
