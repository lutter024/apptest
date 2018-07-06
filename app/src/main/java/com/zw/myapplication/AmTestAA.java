package com.zw.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.zw.lib2.AnnTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhiwei on 2018/7/4.
 */
@AnnTest("test")
public class AmTestAA implements ItestInterface{

    private static String tt = "tt";

    public static void Ab(){
        List<String> list = new ArrayList<String>();
        //HelloWorld.main();
        //Class class = this
//        Class<TestAnnotation> clazz = TestAnnotation.class;
//        // 得到类注解
//        MyClassAnnotation myClassAnnotation = clazz.getAnnotation(MyClassAnnotation.class);
//        System.out.println(myClassAnnotation.desc() + " "+ myClassAnnotation.uri());
//
//        // 得到构造方法注解
//        Constructor<TestAnnotation> cons = clazz.getConstructor(new Class[]{});
//        MyConstructorAnnotation myConstructorAnnotation = cons.getAnnotation(MyConstructorAnnotation.class);
//        System.out.println(myConstructorAnnotation.desc() + " "+ myConstructorAnnotation.uri());
//
//        // 获取方法注解
//        Method method = clazz.getMethod("setId", new Class[]{int.class});
//        MyMethodAnnotation myMethodAnnotation = method.getAnnotation(MyMethodAnnotation.class);
//        System.out.println(myMethodAnnotation.desc() + " "+ myMethodAnnotation.uri());
//        // 获取字段注解
//        Field field = clazz.getDeclaredField("id");
//        MyFieldAnnotation myFieldAnnotation = field.getAnnotation(MyFieldAnnotation.class);
//        System.out.println(myFieldAnnotation.desc() + " "+ myFieldAnnotation.uri());
        //Class<AmTestAA> clazz = AmTestAA.class;
        //AnnTest test = clazz.getAnnotation(AnnTest.class);
       // String dd = test.value();
        //Log.d("gg", "value =" + dd);
        Queue<String> queue = new LinkedList<String>();
        queue.offer("aa");
        queue.offer("bb");
        queue.offer("cc");

    }

    public void test(Context mContext){
        Toast.makeText(mContext, "hello", Toast.LENGTH_LONG).show();
    }
}
