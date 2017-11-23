package com.example.cc.mddemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;

import com.example.cc.mddemo.adapter.MyAdapter;
import com.example.cc.mddemo.listener.FabScrollListener;
import com.example.cc.mddemo.listener.OnHideOrShowListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnHideOrShowListener {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private Toolbar mToolbar;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mFab = findViewById(R.id.float_button);
        mToolbar = findViewById(R.id.toobar);
        setSupportActionBar(mToolbar);

        initData();
        MyAdapter adapter = new MyAdapter(mDatas);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);


        mRecyclerView.addOnScrollListener(new FabScrollListener(this));

    }

    private void initData() {
        mDatas = new ArrayList<>();


        for (int i = 0; i < 100; i++) {
            mDatas.add("条目" + i);
        }
    }

    @Override
    public void onHide() {
        //隐藏
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mFab.getLayoutParams();
        mFab.animate().translationY(mFab.getHeight()+layoutParams.bottomMargin).setInterpolator(new AccelerateInterpolator(3));
    }

    @Override
    public void onShow() {
        //显示
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mFab.getLayoutParams();
        mFab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));
    }
}
