package com.example.recycleview_0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinearDividerDecoration extends RecyclerView.ItemDecoration{
    private int mDriverHeight = 10;
    private int mDriverColor = 0xFFFF0000;
    private Paint mPaint;

    public LinearDividerDecoration(int orientation) {
        mOrientation = orientation;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mDriverColor);
    }
    private int mOrientation;
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if(mOrientation==LinearLayout.HORIZONTAL){
            outRect.set(0,0,mDriverHeight,0);
        }
        else{
            outRect.set(0,0,0,mDriverHeight);
        }
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        c.save();
        int childCount = parent.getChildCount();
        for(int i = 0;i<childCount;i++){
            View view = parent.getChildAt(i);
            int top = view.getBottom();
            int bottom = view.getBottom()+mDriverHeight;
            int left = 0;
            int right = parent.getWidth();
            c.drawRect(left,top,right,bottom,mPaint);
        }
        c.restore();
    }
}