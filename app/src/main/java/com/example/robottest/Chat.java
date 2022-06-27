package com.example.robottest;

//  聊天消息的实体类Chat
public class Chat {
    // 初始化接收信息变量 为0
    public static final int TYPE_RECEIVED = 0;
    // 初始化发送信息变量 为1
    public static final int TYPE_SENT = 1;

    //    聊天对话文本
    private String text;
    //    标识，聊天的类型
    private int type;

    public Chat(String text, int type) {
        this.text = text;
        this.type = type;
    }

    //  生成get和set方法
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * 重写toString方法，以便用于调试的时候如果出现了BUG
     * 可以用Log.d将其打印出来，Debug用
     * */
    @Override
    public String toString() {
        return "Chat{" +
                "text='" + text + '\'' +
                ", type=" + type +
                '}';
    }
}
