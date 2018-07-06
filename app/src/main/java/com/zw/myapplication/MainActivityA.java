package com.zw.myapplication;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MainActivityA extends Activity {

    private SQLHelp sqlHelp = new SQLHelp();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("tag", "a oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(MainActivityA.this, MainActivityB.class);
                //startActivity(i);
                //Intent intent = new Intent(MainActivityA.this, MyService.class);
                //startService(intent);

//                bindService(intent, new ServiceConnection() {
//                    @Override
//                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
//                        Log.d("tag", "ser connect");
//                    }
//
//                    @Override
//                    public void onServiceDisconnected(ComponentName componentName) {
//                        Log.d("tag", "ser disconnect");
//
//                    }
//                }, BIND_AUTO_CREATE);
                sqlHelp.oncreate(MainActivityA.this);
                sqlHelp.createtable();
            }
        });
//        Intent intent = new Intent("action.x");
//        //sendOrderedBroadcast(intent, "1000");
////        sendOrderedBroadcast(intent, null, new XF(), null, 0,
////                "每人发100斤大米", null);
//        sendOrderedBroadcast(intent, "每人发100");
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sqlHelp.add(null);
                sqlHelp.addCol();
            }
        });

        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlHelp.update();
            }
        });
        sqlHelp.oncreate(MainActivityA.this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sqlHelp.close();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d("tag", "a onnewintent");
        super.onNewIntent(intent);
    }
}
