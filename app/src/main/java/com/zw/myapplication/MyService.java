package com.zw.myapplication;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by zhiwei on 2018/6/27.
 */

public class MyService extends Service{

    private final String TAG = "tag";
    private final int DELAY = 2000;

    private Handler mHander = new Handler();
    private Runnable mTask = new Runnable() {

        @Override
        public void run() {
            Log.d(TAG, DELAY / 1000 + "s after");
            // 故意制造异常，使该进程挂掉
            Integer.parseInt("ok");
        }
    };

//    public static void startService(Context context) {
//        Intent intent = new Intent(context, MyService.class);
//        context.startService(intent);
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "   onCreate");
        mHander.postDelayed(mTask, DELAY);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "   onStartCommand    startId = " + startId);
        Log.d(TAG, "   onStartCommand    intent = " + intent);
        /** START_NOT_STICKY | START_STICKY | START_REDELIVER_INTENT | START_STICKY_COMPATIBILITY */
        //return START_STICKY_COMPATIBILITY;
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "   onDestroy");
        super.onDestroy();
    }
}

    //    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        Log.d("tag", "onbinde");
//        return null;
//    }
//
//    @Override
//    public void onCreate() {
//        Log.d("tag", "testOncreat");
//        Notification.Builder builder = new Notification.Builder(this)
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setTicker("This is ticker text")
//                .setWhen(System.currentTimeMillis());
//        Notification note = builder.build();
//        startForeground(1, note);
//        super.onCreate();
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.d("tag", "onStartCommand");
//        return super.onStartCommand(intent, flags, startId);
//    }
//
//    @Override
//    public void onDestroy() {
//        Log.d("tag", "onDestroy");
//        super.onDestroy();
//    }
//
//    @Override
//    public boolean onUnbind(Intent intent) {
//        Log.d("tag", "onUnbind");
//        return super.onUnbind(intent);
//    }
//}
