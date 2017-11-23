package com.example.behaviordemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.behaviordemo.R;

import java.util.List;

/**
 * Created by cc on 2017/11/22.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private List<String> mDatas;

    public MyAdapter(List<String> datas) {
        mDatas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.text);

        }
    }
}
