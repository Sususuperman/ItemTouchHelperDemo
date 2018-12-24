package com.superman.drag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;
import android.view.View;

import com.superman.drag.demo.DragRecycleviewActivity;
import com.superman.drag.demo.SwipeRecycleviewActivity;
import com.superman.drag.helper.DragItemTouchHelper;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void todrag(View view) {
        startActivity(new Intent(this, DragRecycleviewActivity.class));
    }

    public void toswipe(View view) {
    startActivity(new Intent(this, SwipeRecycleviewActivity.class));
    }
}
