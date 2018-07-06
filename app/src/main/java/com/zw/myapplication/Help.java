package com.zw.myapplication;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

/**
 * Created by zhiwei on 2018/7/4.
 */

public class Help {

    private Context mContext;

    public Help(Context context) {

        this.mContext = context;

    }

    /**
     * 打印ActivityName
     */

    public void printActivityName() {

        for (int i = 0; i < 100; i++) {

            new Thread(new Runnable() {

                @Override

                public void run() {

                    while (true)

                        try {

                            Thread.sleep(1000 * 30);

                            Log.d(Help.class.getSimpleName(), ((Activity) mContext).getClass().getSimpleName());

                        } catch (InterruptedException e) {

                            e.printStackTrace();

                        }

                }

            }).start();

        }
    }
}
