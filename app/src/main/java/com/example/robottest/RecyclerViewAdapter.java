package com.example.robottest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * 描述: 聊天布局适配器
 * RecyclerView的Adapter类
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {


    //    聊天信息的上下文
    private Context context;

    //    聊天对话列表
    private List<Chat> mlist;

    public RecyclerViewAdapter(Context context, List<Chat> list) {
        this.context = context;
        this.mlist = list;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//          加载展示单条数据的布局文件chat_item.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false);
        return new RecyclerViewHolder(view);
    }

//    展示单挑数据
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Chat chat = mlist.get(position);
//        根据chat 的类型来判断是图灵机器人的信息还是我自己的信息
        if (chat.getType() == Chat.TYPE_RECEIVED) {
//           如果收的的数据是左边，就显示左边的消息布局，将右边的消息布局隐藏
            holder.leftLayout.setVisibility(View.VISIBLE);
//            隐藏右边布局
            holder.rightLayout.setVisibility(View.GONE);
//            左边布局设置text
            holder.leftChat.setText(chat.getText());
        } else if (chat.getType() == chat.TYPE_SENT) {
//           如果发出的消息是右边，就显示右边的消息布局，将左边的消息布局隐藏
            holder.rightLayout.setVisibility(View.VISIBLE);
//            隐藏左边布局
            holder.leftLayout.setVisibility(View.GONE);
//            右边布局设置text
            holder.rightChat.setText(chat.getText());
        }
    }

    //  获取所有数据的数量
    @Override
    public int getItemCount() {
        return mlist.size();
    }

}