package com.zw.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by zhiwei on 2018/6/27.
 */

public class ZF  extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String data = getResultData();
        Log.d("tag", "市政府");
    }
}
