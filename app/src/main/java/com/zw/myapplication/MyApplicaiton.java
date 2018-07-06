package com.zw.myapplication;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by zhiwei on 2018/6/28.
 */

public class MyApplicaiton extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                // 在Activity启动时（onCreate()） 写入Activity实例到容器内
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                // 在Activity启动时（onDestory()） 写入Activity实例到容器内
            }
        });
    }

        public void exitApp(){
              //https://www.jianshu.com/p/269873a16937
//            Log.d(TAG, "容器内的Activity列表如下 ");
//            // 先打印当前容器内的Activity列表
//            for (Activity activity : activityLinkedList) {
//                Log.d(TAG, activity.getLocalClassName());
//            }
//
//            Log.d(TAG, "正逐步退出容器内所有Activity");
//
//            // 逐个退出Activity
//            for (Activity activity : activityLinkedList) {
//                activity.finish();
//            }

            //  结束进程
            // System.exit(0);
        }
}
