package com.example.robottest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //  聊天消息的列表，用RecyclerView展示
    private RecyclerView recyclerView;

    //  输入框，输入聊天信息
    private EditText editText;

    //  发送按钮
    private Button mButton;

    //  聊天信息的集合
    private List<Chat> list = new ArrayList<>();

    //  RecyclerView的适配器Adapter
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  初始化控件
        //  根据activity 的id 绑定相关组件
        recyclerView = findViewById(R.id.recycler);
        editText = findViewById(R.id.et_text);
        //  发送按钮设置
        mButton = findViewById(R.id.btn_send);
        //  监听按钮，根据OnClick函数触发相对应的事件
        mButton.setOnClickListener(this);

        //  加载数据
        initData();
        //  设置布局管理
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //  设置Recyclerview中展现多条数据的方式
        recyclerView.setLayoutManager(linearLayoutManager);
        //  创建适配器对象
        recyclerViewAdapter = new RecyclerViewAdapter(this, list);
        //  Recyclerview组件对象设置适配器对象，显示Recyclerview组件
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    /**
     * 初始化聊天数据
     * 往聊天的集合里面随便加点text，随便填几句话
     */
    private void initData() {
        Chat c1 = new Chat("Hello", Chat.TYPE_RECEIVED);
        list.add(c1);
        Chat c2 = new Chat("你好，你现在会些什么呢？", Chat.TYPE_SENT);
        list.add(c2);
        Chat c3 = new Chat("我是图灵机器人，你可以向我提问哦。", Chat.TYPE_RECEIVED);
        list.add(c3);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                /**
                 * 1，获取输入框的内容
                 * 2，判断是否为空
                 * 3，发送后清空当前的输入框
                 */
//              1,获取输入框的内容
                String text = editText.getText().toString();
//              2,判断当前输入框的内容是否为空，如果不为空的时候 ↓
                if (!TextUtils.isEmpty(text)) {
//                  把要发送的数据添加到addData方法中，并把数据类型也填入，这里我们的类型是TYPE_SENT，发送数据类型
                    addData(text, Chat.TYPE_SENT);
//                  清空输入框
                    editText.setText("");
//                  把发送的文本数据传递到request方法中，请求数据
                    request(text);
                }
                break;
        }
    }

    /**
     * 通过传递进来的text和type创建数据实体类
     * 添加到聊天数据集合list中
     */
    private void addData(String text, int type) {
        Chat c = new Chat(text, type);
        list.add(c);
        //  当有新消息时，刷新显示
        recyclerViewAdapter.notifyItemInserted(list.size() - 1);
        //  定位的最后一行
        recyclerView.scrollToPosition(list.size() - 1);
    }

    /**
     * 请求数据函数
     */
    private void request(String text) {
//      把输入的文本数据存储在请求实体类中
        Ask ask = new Ask();
        Ask.UserInfoBean info = new Ask.UserInfoBean();
//        设置机器人的ApiKey，这里直接用老师给的那个
        info.setApiKey("d9a3e3f5b2fe42489e93ee8965bb3587");
//        设置用户的UserId
        info.setUserId("756474");
//        请求对象设置UserInfo
        ask.setUserInfo(info);
//        创建一个inputTextBean对象
        Ask.PerceptionBean.InputTextBean inputTextBean = new Ask.PerceptionBean.InputTextBean();
//        将输入的文本数据text通过 inputTextBean对象的set函数存储起来
        inputTextBean.setText(text);
//        创建一个PerceptionBean的对象
        Ask.PerceptionBean perBean = new Ask.PerceptionBean();
//        将上面储存了text的文本数据的inputTextBean存储到刚刚创建的PerceptionBean对象里面
        perBean.setInputText(inputTextBean);
//        设置 perBean
        ask.setPerception(perBean);

//       创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://openapi.tuling123.com/")   //  设置网络请求url，后面一段写在网络请求接口里面
                .addConverterFactory(GsonConverterFactory.create())     //  Gson解析，这里用retrofit2里面的Gson转换器实现
                .build();
//       创建网络请求接口Api的实例
        Api api = retrofit.create(Api.class);
//      Take为响应实体类，用来接受机器人返回的回复数据
        Call<Take> call = api.request(ask);
//      调用call中的enqueue方法，这是一个异步请求，不会阻塞线程，类似于OKHttp中的enqueue
        call.enqueue(new Callback<Take>() {
//            onResponse和onFailure都是在主线程中执行
            //          请求数据成功，通过Log.d  打印相关信息
            @Override
            public void onResponse(Call<Take> call, Response<Take> response) {
                /**
                 * 接收到的机器人回复的数据
                 * Results里面有个数组，第一个元素{}里就有Values,里面有需要的text
                 * */
                String mText= response.body().getResults().get(0).getValues().getText();
//              把接受到的数据传入addData方法中，类型是TYPE_RECEIVED接收数据
                addData(mText, Chat.TYPE_RECEIVED);
                Log.d("Succeed：","接受到的机器人回复的数据： "+mText);
            }
            //            请求数据失败，通过Log.d  打印相关信息
            @Override
            public void onFailure(Call<Take> call, Throwable t) {
                Log.d("False：","请求失败： "+t.toString());
            }
        });
    }
}