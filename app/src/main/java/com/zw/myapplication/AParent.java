package com.zw.myapplication;

import android.util.Log;

/**
 * Created by zhiwei on 2018/6/30.
 */

public class AParent {

    protected int a = 1;
    protected void funxx(){
        Log.d("dd", "Human xxx" );
    }


    public void fun1() {
        Log.d("dd", "Human fun1" + a);

        String a = "abc";
        String b = "abc";
        Log.d("dd", "a == b " + (a == b));
        Log.d("dd", "a == b " + (a.equals(b)));
        fun2();
    }

    public void fun2() {
        Log.d("dd","Human fun2");
    }

    public static void fxxx(){

    }
}
