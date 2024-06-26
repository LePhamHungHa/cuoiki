package com.example.bookingticket.API;

import com.example.bookingticket.LoginPage.LoginResponse;
import com.example.bookingticket.LoginPage.LoginResquest;
import com.example.bookingticket.Model.Theater;
import com.example.bookingticket.Model.User.UserBody;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yy").create();
  ;

    Interceptor interceptor = chain -> {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
//        builder.addHeader("Authorization", "Bearer ");
        return chain.proceed(builder.build());
    };
    OkHttpClient.Builder okBuilder = new OkHttpClient.Builder().addInterceptor(interceptor);
    ApiService api = new Retrofit.Builder()
            .baseUrl("http://3.25.140.171:8080/api/")
            .client(okBuilder.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @POST("register")
    Call<UserBody> register(@Body UserBody userBody);

    @POST("login")
    Call<LoginResponse> login(@Body LoginResquest loginResquest);

    @GET("theaters")
    Call<List<Theater>> getAllTheaters();



}
