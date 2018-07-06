package com.zw.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * Created by zhiwei on 2018/7/3.
 */

public class DividerGridItemDecoration extends RecyclerView.ItemDecoration{
    //写右边的画笔
    private Paint mPaint;

    //写左边日期字的画笔(时间+日期)
    private Paint mPaint1;
    private Paint mPaint2;

    //左 上偏移长度
    private int itemView_leftinterval;
    private int itemView_topinterval;

    //
    private int circle_radius;

    private Bitmap mIcon;

    public DividerGridItemDecoration(Context context){
        mPaint = new Paint();
        mPaint.setColor(Color.RED);

        //年月
        mPaint1 = new Paint();
        mPaint1.setColor(Color.BLUE);
        mPaint1.setTextSize(30);


        mPaint2 = new Paint();
        mPaint2.setColor(Color.BLUE);

        itemView_leftinterval = 200;

        itemView_topinterval = 50;

        circle_radius = 10;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(itemView_leftinterval, itemView_topinterval, 0, 0);
    }

    //先于itemview绘制
    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    //后于itemview绘制
    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int childCount = parent.getChildCount();
        for(int i = 0; i< childCount; i++){
            View child = parent.getChildAt(i);

            /*
            绘制轴点
             */
            float centerx = child.getLeft() - itemView_leftinterval/3;
            float centery = child.getTop() - itemView_topinterval + (itemView_topinterval + child.getHeight()) / 2;
            c.drawCircle(centerx, centery, circle_radius, mPaint);
        }
    }

    //    private static final int[] ATTRS = new int[] { android.R.attr.listDivider };
//    private Drawable mDivider;
//
//    public DividerGridItemDecoration(Context context)
//    {
//        final TypedArray a = context.obtainStyledAttributes(ATTRS);
//        mDivider = a.getDrawable(0);
//        a.recycle();
//    }
//
//    @Override
//    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state)
//    {
//
//        drawHorizontal(c, parent);
//        drawVertical(c, parent);
//
//    }
//
//    private int getSpanCount(RecyclerView parent)
//    {
//        // 列数
//        int spanCount = -1;
//        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
//        if (layoutManager instanceof GridLayoutManager)
//        {
//
//            spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
//        } else if (layoutManager instanceof StaggeredGridLayoutManager)
//        {
//            spanCount = ((StaggeredGridLayoutManager) layoutManager)
//                    .getSpanCount();
//        }
//        return spanCount;
//    }
//
//    public void drawHorizontal(Canvas c, RecyclerView parent)
//    {
//        int childCount = parent.getChildCount();
//        for (int i = 0; i < childCount; i++)
//        {
//            final View child = parent.getChildAt(i);
//            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
//                    .getLayoutParams();
//            final int left = child.getLeft() - params.leftMargin;
//            final int right = child.getRight() + params.rightMargin
//                    + mDivider.getIntrinsicWidth();
//            final int top = child.getBottom() + params.bottomMargin;
//            final int bottom = top + mDivider.getIntrinsicHeight();
//            mDivider.setBounds(left, top, right, bottom);
//            mDivider.draw(c);
//        }
//    }
//
//    public void drawVertical(Canvas c, RecyclerView parent)
//    {
//        final int childCount = parent.getChildCount();
//        for (int i = 0; i < childCount; i++)
//        {
//            final View child = parent.getChildAt(i);
//
//            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
//                    .getLayoutParams();
//            final int top = child.getTop() - params.topMargin;
//            final int bottom = child.getBottom() + params.bottomMargin;
//            final int left = child.getRight() + params.rightMargin;
//            final int right = left + mDivider.getIntrinsicWidth();
//
//            mDivider.setBounds(left, top, right, bottom);
//            mDivider.draw(c);
//        }
//    }
//
//    private boolean isLastColum(RecyclerView parent, int pos, int spanCount,
//                                int childCount)
//    {
//        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
//        if (layoutManager instanceof GridLayoutManager)
//        {
//            if ((pos + 1) % spanCount == 0)// 如果是最后一列，则不需要绘制右边
//            {
//                return true;
//            }
//        } else if (layoutManager instanceof StaggeredGridLayoutManager)
//        {
//            int orientation = ((StaggeredGridLayoutManager) layoutManager)
//                    .getOrientation();
//            if (orientation == StaggeredGridLayoutManager.VERTICAL)
//            {
//                if ((pos + 1) % spanCount == 0)// 如果是最后一列，则不需要绘制右边
//                {
//                    return true;
//                }
//            } else
//            {
//                childCount = childCount - childCount % spanCount;
//                if (pos >= childCount)// 如果是最后一列，则不需要绘制右边
//                    return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean isLastRaw(RecyclerView parent, int pos, int spanCount,
//                              int childCount)
//    {
//        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
//        if (layoutManager instanceof GridLayoutManager)
//        {
//            childCount = childCount - childCount % spanCount;
//            if (pos >= childCount)// 如果是最后一行，则不需要绘制底部
//                return true;
//        } else if (layoutManager instanceof StaggeredGridLayoutManager)
//        {
//            int orientation = ((StaggeredGridLayoutManager) layoutManager)
//                    .getOrientation();
//            // StaggeredGridLayoutManager 且纵向滚动
//            if (orientation == StaggeredGridLayoutManager.VERTICAL)
//            {
//                childCount = childCount - childCount % spanCount;
//                // 如果是最后一行，则不需要绘制底部
//                if (pos >= childCount)
//                    return true;
//            } else
//            // StaggeredGridLayoutManager 且横向滚动
//            {
//                // 如果是最后一行，则不需要绘制底部
//                if ((pos + 1) % spanCount == 0)
//                {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public void getItemOffsets(Rect outRect, int itemPosition,
//                               RecyclerView parent)
//    {
//        int spanCount = getSpanCount(parent);
//        int childCount = parent.getAdapter().getItemCount();
//        if (isLastRaw(parent, itemPosition, spanCount, childCount))// 如果是最后一行，则不需要绘制底部
//        {
//            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
//        } else if (isLastColum(parent, itemPosition, spanCount, childCount))// 如果是最后一列，则不需要绘制右边
//        {
//            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
//        } else
//        {
//            outRect.set(0, 0, mDivider.getIntrinsicWidth(),
//                    mDivider.getIntrinsicHeight());
//        }
//    }
//
//    @Override
//    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
//    }
}
