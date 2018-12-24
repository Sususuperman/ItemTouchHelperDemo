package com.superman.drag.helper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.superman.drag.SwipeAdapter;

import java.util.Arrays;

/**
 * 作者 Superman
 * 日期 2018/12/24 16:04.
 * 文件 DragRecycleViewByItemTouchHelper
 * 描述 可移除的touchhelper
 */

public class SwipeItemTouchHelper extends ItemTouchHelper.SimpleCallback {
    private RecyclerView.Adapter adapter;
    private onDeleteListener listener;
    public SwipeItemTouchHelper(int dragDirs, int swipeDirs, SwipeAdapter adapter, onDeleteListener listener) {
        super(dragDirs, swipeDirs);
        this.adapter = adapter;
        this.listener = listener;
    }


    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        if (listener != null) {
            listener.onDelete(viewHolder.getAdapterPosition());
        }
    }

  public   interface onDeleteListener{
        void onDelete(int postion);
    }
}
