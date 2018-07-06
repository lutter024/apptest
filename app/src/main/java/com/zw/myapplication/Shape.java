package com.zw.myapplication;

import android.util.Log;

/**
 * Created by zhiwei on 2018/6/30.
 */

public class Shape {
    //private Draw draw = new Draw("shape");
    protected int a = 5;

    static {
        Log.d("aa", "shape static" );
    }
    {
        Log.d("aa", "shape not static" + a);
    }
    public Shape() {
        Log.d("aa","shape constructor");
    }
}
