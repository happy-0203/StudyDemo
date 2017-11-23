package com.example.behaviordemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class NestedScrollActivity extends AppCompatActivity {

    private FloatingActionButton mFab;
    private Toolbar mToolbar;
    private ArrayList<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scroll);

        mFab = findViewById(R.id.fab);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        initData();
    }


    private void initData() {
        mDatas = new ArrayList<>();


        for (int i = 0; i < 100; i++) {
            mDatas.add("条目" + i);
        }
    }
}
