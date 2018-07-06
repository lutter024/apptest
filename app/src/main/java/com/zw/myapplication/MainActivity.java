package com.zw.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.idescout.sql.SqlScoutServer;
import com.test.HelloWorld;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends Activity {

    ButtonView btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("tag", "main oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (ButtonView) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TestActivity.class);
                startActivity(i);
//                AmTestAA test = (AmTestAA) HelloWorld.main("test");
//                test.test(MainActivity.this);
            }
        });
        //SqlScoutServer.create(this, getPackageName());
        //AParent a = new B();
        //a.fun1();
//        B b = new B();
//        b.funxx();
        //Circle.test();
        //new Circle();
        //hookOnClickListener(btn);
    }

//    public void setOnClickListener(@Nullable OnClickListener l) {
//        if (!isClickable()) {
//            setClickable(true);
//        }
//        getListenerInfo().mOnClickListener = l;
//    }
//
//    ListenerInfo getListenerInfo() {
//        if (mListenerInfo != null) {
//            return mListenerInfo;
//        }
//        mListenerInfo = new ListenerInfo();
//        return mListenerInfo;
//    }
    private void hookOnClickListener(View v){
        try {
            // 得到 View 的 ListenerInfo 对象
            Method getListenerInfo = View.class.getDeclaredMethod("getListenerInfo");//获取方法
            getListenerInfo.setAccessible(true);
            Object listenerInfo = getListenerInfo.invoke(v);
            // 得到 原始的 OnClickListener 对象
            Class<?> listenerInfoClz = Class.forName("android.view.View$ListenerInfo");
            Field mOnClickListener = listenerInfoClz.getDeclaredField("mOnClickListener");//获取到相应属性
            mOnClickListener.setAccessible(true);
            View.OnClickListener originOnClickListener = (View.OnClickListener) mOnClickListener.get(listenerInfo);
            // 用自定义的 OnClickListener 替换原始的 OnClickListener
            View.OnClickListener hookedOnClickListener = new HookedOnClickListener(originOnClickListener);
            mOnClickListener.set(listenerInfo, hookedOnClickListener);
        } catch (Exception e) {
            //log.warn("hook clickListener failed!", e);
            Toast.makeText(MainActivity.this, "hook failed", Toast.LENGTH_SHORT).show();
        }
    }

    class HookedOnClickListener implements View.OnClickListener {
        private View.OnClickListener origin;

        HookedOnClickListener(View.OnClickListener origin) {
            this.origin = origin;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "hook click", Toast.LENGTH_SHORT).show();
            //log.info("Before click, do what you want to to.");
//            if (origin != null) {
//                origin.onClick(v);
//            }
//            log.info("After click, do what you want to to.");
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d("tag", "main onnewintent");
        super.onNewIntent(intent);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("xx", "activity dis");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("xx", "activity onTouchEvent");
        return super.onTouchEvent(event);
    }
}
