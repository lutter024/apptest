package com.zw.myapplication;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivityB extends Activity {

    private Handler handler;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("tag", "b oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView)findViewById(R.id.test);
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivityB.this, MainActivityC.class);
                //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                //Threadlocal
            }
        });
        HandlerThread handlerThread = new HandlerThread("test");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper()){
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                Log.d( "handler " , "消息： " + msg.what + "  线程： " + Thread.currentThread().getName()  ) ;
//                textView.setText("1234");
//            }

            @Override
            public void dispatchMessage(Message msg) {
                super.dispatchMessage(msg);
                Log.d( "handler " , "消息： " + msg.what + "  线程： " + Thread.currentThread().getName()  ) ;
                textView.setText("1234");
            }
        };
        Log.d("tag","线程" + Thread.currentThread().getName());
        //handler.sendEmptyMessage(1);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                handler.sendEmptyMessage(2);
//            }
//        }).start();
//
//        Handler t = new Handler(){
//            @Override
//            public void dispatchMessage(Message msg) {
//                super.dispatchMessage(msg);
//            }
//
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//            }
//        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        //handler.sendEmptyMessage(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                textView.setText("12345");
            }
        }).start();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d("tag", "b onnewintent");
        super.onNewIntent(intent);
    }
}
