package com.example.testbookingticket.Repository;

import androidx.annotation.OptIn;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;

import com.example.testbookingticket.API.ApiService;
import com.example.testbookingticket.LoginPage.LoginResponse;
import com.example.testbookingticket.LoginPage.LoginResquest;
import com.example.testbookingticket.Model.User.UserBody;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private ApiService apiService;

    public UserRepository() {
        this.apiService = ApiService.api;
    }

    public LiveData<UserBody> register(UserBody userBody) {
        final MediatorLiveData<UserBody> data = new MediatorLiveData<>();
        apiService.register(userBody)
                .enqueue(new Callback<UserBody>() {
                    @OptIn(markerClass = UnstableApi.class)
                    @Override
                    public void onResponse(Call<UserBody> call, Response<UserBody> response) {
                        if (response.isSuccessful()) {
                            Log.d("SignUpActivity", "API response: " + response.body());
                            // Đảm bảo rằng bạn đã xử lý dữ liệu phản hồi ở đây nếu cần
                            data.postValue(response.body()); // hoặc data.setValue(response.body());
//                            new Handler(Looper.getMainLooper()).post(() -> data.setValue(response.body()));
                        } else {
                            try {
                                String errorBody = response.errorBody().string();
                                Log.e("SignUpActivity", "Failed to register user. Error: " + errorBody);
                            } catch (IOException e) {
                                Log.e("SignUpActivity", "Failed to get error response");
                            }
                            data.postValue(null); // hoặc data.setValue(null);
                        }
                    }
                    @OptIn(markerClass = UnstableApi.class)
                    @Override
                    public void onFailure(Call<UserBody> call, Throwable t) {
                        Log.e("SignUpActivity", "Failed to register user", t);
                        data.postValue(null); // hoặc data.setValue(null);
                    }
                });
        return data;
    }

    public LiveData<LoginResponse> login(LoginResquest loginResquest) {
        final MediatorLiveData<LoginResponse> data = new MediatorLiveData<>();
        apiService.login(new LoginResquest(loginResquest.getUsername(), loginResquest.getPassword()))
                .enqueue(new Callback<LoginResponse>() {
                    @OptIn(markerClass = UnstableApi.class)
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()) {
                            data.postValue(response.body());
                            Log.e("Login", response.body() + "");
                        } else {
                            try {
                                String errorBody = response.errorBody().string();
                                Log.e("Login", "Failed to Login user. Error: " + errorBody);
                            } catch (IOException e) {
                                Log.e("Login", "Failed to get error response");
                            }
                            data.postValue(null); // hoặc data.setValue(null);
                        }
                    }
                    @OptIn(markerClass = UnstableApi.class)
                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.e("Login", "Failed to login user", t);
                        data.postValue(null); // hoặc data.setValue(null);
                    }
                });

        return data;
    }
}
