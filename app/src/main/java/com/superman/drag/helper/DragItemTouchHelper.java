package com.superman.drag.helper;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.Collections;

/**
 * 作者 Superman
 * 日期 2018/12/24 13:49.
 * 文件 DragRecycleViewByItemTouchHelper
 * 描述 可拖拽的touchhelper
 */

public class DragItemTouchHelper extends ItemTouchHelper.Callback {
    private onMoveListener listener;

    public DragItemTouchHelper(onMoveListener listener) {
        this.listener = listener;
    }

    //getMovementFlags用于设置是否处理拖拽事件和滑动事件，以及拖拽和滑动操作的方向，
    // 比如如果是列表类型的RecyclerView，拖拽只有UP、DOWN两个方向，而如果是网格类型的则有UP、DOWN、LEFT、RIGHT四个方向：
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //列表只有上下两个方向，网格有上下左右四个方向。
        int dragFlags;//拖拽标志
        int swipeFlags;//移除标志
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
            swipeFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
            ;
        } else {
            dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            swipeFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        }
        return makeMovementFlags(dragFlags, swipeFlags); //返回0表示不做拖拽和滑动处理。
    }

    //当getMovementFlags()方法返回不是0的时候，我们长按item的时候会不断回调onMove()方法，在方法中我们可以拿到当前拖拽
    //的item的viewholder和已经拖拽到所处位置的item的viewholder（target）。这两个东西有了，我们就可以处理和交换他们的数据了
    //然后调用Adapter的notifyItemMoved方法来刷新item
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int from = viewHolder.getAdapterPosition();//拖拽的位置
        int to = target.getAdapterPosition();//拖拽到的目标位置
        if (listener != null) {
            listener.onMove(from, to);
        }
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
    }

    //当长按选中item的时候（拖拽开始的时候）调用
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    //当手指松开的时候（拖拽完成的时候）调用
    //若需要实现保存当前列表的顺序，可以在这个方法完成后，进行缓存。然后再次进入页面时读取缓存即可。
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setBackgroundColor(0);
        super.clearView(recyclerView, viewHolder);
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();//默认返回的true，返回false表示可以自己定义拖拽过程，可以在recycleview添加长按事件处理（比如有些可以拖拽有些不能。）
    }

    public interface onMoveListener {
        void onMove(int from, int to);
    }
}
