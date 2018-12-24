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
import com.superman.drag.helper.SwipeItemTouchHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwipeRecycleviewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SwipeAdapter adapter;
    String[] datas = {"你", "是", "最", "棒", "的", "你", "是", "最", "棒", "的", "你", "是", "最", "棒", "的", "你", "是", "最", "棒", "的", "你", "是", "最", "棒", "的"};
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_recycleview);
        recyclerView = findViewById(R.id.recy);
        adapter = new SwipeAdapter();
        list = Arrays.asList(datas);
        list = new ArrayList<>(list);
        adapter.setDatas(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeItemTouchHelper(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, adapter, new SwipeItemTouchHelper.onDeleteListener() {
            @Override
            public void onDelete(int postion) {
                list.remove(postion);
                adapter.setDatas(list);
                adapter.notifyItemRemoved(postion);
            }
        }));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
