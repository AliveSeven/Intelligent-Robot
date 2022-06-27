package com.example.robottest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

// Retrofit可以将Http请求抽象成Java接口：采用注解描述网络请求参数和配置网络请求参数
// 这里用Retrofit实现Api接口

public interface Api {
     //发送json数据形式的post请求，把网络请求接口的后半部分openapi/api/v写在里面
     //Ask是请求数据实体类，Take接受数据实体类
     @POST("openapi/api/v2")
     //@body即非表单请求体，被@Body注解的ask将会被Gson转换成json发送到服务器，返回到Take。
     // 其中返回类型为Call<*>，*是接收数据的类
     Call<Take> request(@Body Ask ask);
}

