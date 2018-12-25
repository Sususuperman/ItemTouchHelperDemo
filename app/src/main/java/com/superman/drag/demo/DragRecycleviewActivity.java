package com.superman.drag.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.superman.drag.DragAdapter;
import com.superman.drag.R;
import com.superman.drag.SwipeAdapter;
import com.superman.drag.helper.DragItemTouchHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DragRecycleviewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SwipeAdapter adapter;
    String[] datas = {"你", "是", "最", "棒", "的", "你", "是", "最", "棒", "的", "你", "是", "最", "棒", "的", "你", "是", "最", "棒", "的", "你", "是", "最", "棒", "的"};
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_recycleview);
        recyclerView = findViewById(R.id.recy);
        adapter = new SwipeAdapter();
        list = Arrays.asList(datas);
        list = new ArrayList<>(list);
        adapter.setDatas(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new DragItemTouchHelper(new DragItemTouchHelper.onMoveListener() {
            @Override
            public void onMove(int from, int to) {
                Collections.swap(list, from, to);
                //这个方法很关键，调换list的顺序
                adapter.notifyItemMoved(from, to);
            }
        }));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
