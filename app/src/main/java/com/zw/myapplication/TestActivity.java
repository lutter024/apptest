package com.zw.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhiwei on 2018/7/3.
 */

public class TestActivity extends Activity{

//    private RecyclerView mRecyclerView;
//    private List<String> mDatas;
//    private HomeAdapter mAdapter;
    private ImageView mLogo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("tag", "onCreate()");
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            int t = savedInstanceState.getInt("test");
            Log.d("tag", "helllo ==" + t);
            //savedInstanceState.containsKey("test");
        }
        setContentView(R.layout.activity_main4);
        mLogo = (ImageView)findViewById(R.id.imglogo);
        Animation ms = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(ms);
        animationSet.setDuration(3000);
        mLogo.startAnimation(animationSet);
        mLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(TestActivity.this, MainActivityA.class);
//                startActivity(i);
                AmTestAA.Ab();
            }
        });
        new Help(TestActivity.this).printActivityName();
        //initData();
//        mRecyclerView = (RecyclerView)findViewById(R.id.myRecyler);
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
//                DividerItemDecoration.VERTICAL));
//        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,  StaggeredGridLayoutManager.HORIZONTAL));
//        //mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
//        mRecyclerView.setAdapter(mAdapter = new HomeAdapter(this, mDatas));

    }

    @Override
    protected void onRestart() {
        Log.d("tag", "onRestart()");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.d("tag", "onStart()");
        super.onStart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("tag", "onRestoreInstanceState()");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        Log.d("tag", "onReumser()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("tag", "onpause()");
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("tag", "===saveaaaa()");
        outState.putInt("test", 123456);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        Log.d("tag", "onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("tag", "onDestroy()");
        super.onDestroy();
    }

    protected void initData()
    {
//        mDatas = new ArrayList<String>();
//        for (int i = 'A'; i < 'z'; i++)
//        {
//            mDatas.add("" + (char) i);
//        }
    }
}
