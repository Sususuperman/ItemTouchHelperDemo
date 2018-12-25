package com.superman.drag;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * 作者 Superman
 * 日期 2018/12/21 15:28.
 * 文件 DragRecycleViewByItemTouchHelper
 * 描述
 */

public class SwipeAdapter extends RecyclerView.Adapter<SwipeAdapter.ListHolder>{
    private List<String> datas;
    public void setDatas(List<String>datas){
        this.datas = datas;
    }
    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.tv.setText("第"+datas.get(position)+"个item");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
    class ListHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public ListHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
