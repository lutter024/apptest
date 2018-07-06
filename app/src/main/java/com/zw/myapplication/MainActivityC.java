package com.zw.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivityC extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("tag", "c oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivityC.this, MainActivityA.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d("tag", "c onnewintent");
        super.onNewIntent(intent);
    }
}
