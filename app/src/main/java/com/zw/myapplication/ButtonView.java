package com.zw.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by zhiwei on 2018/6/29.
 */

public class ButtonView extends Button {
    public ButtonView(Context context) {
        super(context);
    }

    public ButtonView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("xx", "view disaptch");
        return super.dispatchTouchEvent(event);
        //return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("xx", "view onTouchEvent");
//        switch(event.getAction()){
//        case MotionEvent.ACTION_DOWN:
//            Log.d("xx", "view actiondouw");
//
//            return true;
//        }
        return super.onTouchEvent(event);
    }
}
