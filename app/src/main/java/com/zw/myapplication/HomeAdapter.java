package com.zw.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhiwei on 2018/7/3.
 */

public class HomeAdapter extends RecyclerView.Adapter{

    //RecyclerView.Adapter<HomeAdapter.MyViewHolder>

    private LayoutInflater inflater;
    private ArrayList<HashMap<String, Object>> listItem;

    //构造函数，传入数据
    public HomeAdapter(Context context, ArrayList<HashMap<String, Object>> listItem) {
        inflater = LayoutInflater.from(context);
        this.listItem = listItem;
    }


    //定义Viewholder
    class Viewholder extends RecyclerView.ViewHolder  {
        private TextView Title, Text;

        public Viewholder(View root) {
            super(root);
            Title = (TextView) root.findViewById(R.id.Itemtitle);
            Text = (TextView) root.findViewById(R.id.Itemtext);

        }

        public TextView getTitle() {
            return Title;
        }

        public TextView getText() {
            return Text;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(inflater.inflate(R.layout.item_home, null));
    }//在这里把ViewHolder绑定Item的布局

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Viewholder vh = (Viewholder) holder;
        // 绑定数据到ViewHolder里面
        vh.Title.setText((String) listItem.get(position).get("ItemTitle"));
        vh.Text.setText((String) listItem.get(position).get("ItemText"));
    }

    //返回Item数目
    @Override
    public int getItemCount() {
        return listItem.size();
    }
//    private Context mContext;
//    private List<String> mdata;
//    public HomeAdapter(Context context, List<String> data){
//        mContext = context;
//        mdata = data;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
//                mContext).inflate(R.layout.item_home, viewGroup,
//                false));
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//        myViewHolder.tv.setText(mdata.get(i));
//    }
//
//    @Override
//    public int getItemCount() {
//        return mdata.size();
//    }
//
//    class MyViewHolder extends RecyclerView.ViewHolder
//    {
//
//        TextView tv;
//
//        public MyViewHolder(View view)
//        {
//            super(view);
//            tv = (TextView) view.findViewById(R.id.id_num);
//        }
//    }
}
