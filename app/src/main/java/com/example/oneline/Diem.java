package com.example.oneline;

public class Diem {
    int x;
    int y;
    int xe;
    int xs;
    int ye;
    int ys;
    Diem(int x, int y){
        this.x = x*1440/410;
        this.y = y*1440/410;
        this.xe = this.x+50;
        this.xs = this.x-50;
        this.ye = this.y+50;
        this.ys = this.y-50;
    }
    boolean check(int x, int y){
        return (xs<=x && xe >= x && ye >=y && ys <=y);
    }
}
