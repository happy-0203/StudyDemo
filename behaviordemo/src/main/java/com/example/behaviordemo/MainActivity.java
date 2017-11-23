package com.example.behaviordemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.behaviordemo.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private Toolbar mToolbar;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview);
        mFab = findViewById(R.id.fab);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        initData();
        MyAdapter adapter = new MyAdapter(mDatas);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);


    }

    private void initData() {
        mDatas = new ArrayList<>();


        for (int i = 0; i < 100; i++) {
            mDatas.add("条目" + i);
        }
    }

}

