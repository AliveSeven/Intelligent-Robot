package com.example.robottest;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * 声明控件
 * RecyclerView的Hodler类
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder{
    //  展示单条数据的界面组件对象
    LinearLayout leftLayout;
    LinearLayout rightLayout;
    TextView leftChat;
    TextView rightChat;

    //  构造方法：将组件（ui）与组件对象（java类）关联起来
    public RecyclerViewHolder(View view){
        super(view);
        //  根据页面的id关联组件对象 ↓
        leftLayout = itemView.findViewById(R.id.left_layout);
        rightLayout = itemView.findViewById(R.id.right_layout);
        leftChat = itemView.findViewById(R.id.tv_left_text);
        rightChat = itemView.findViewById(R.id.tv_right_text);
    }

}
