package com.zw.myapplication;

import android.util.Log;

/**
 * Created by zhiwei on 2018/6/30.
 */

public class Circle extends Shape {
    //private Draw draw = new Draw("circle");
    static {
        Log.d("aa", "Circle static" );
    }
    {
        Log.d("aa", "Circle not static" + a);
    }
    public Circle() {
        Log.d("aa","circle constructor");
    }

    public static void test(){
        Log.d("aa", "test");
    }
}
