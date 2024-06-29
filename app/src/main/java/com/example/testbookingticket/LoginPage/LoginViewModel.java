package com.example.testbookingticket.LoginPage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testbookingticket.Repository.UserRepository;

public class LoginViewModel extends ViewModel {
    private UserRepository userRepository;

    public LoginViewModel() {
        this.userRepository = new UserRepository();
    }

    private LiveData<LoginResponse> data=  new MutableLiveData<>();

    public void login(LoginResquest loginResquest) {
        data = userRepository.login(loginResquest);
    }

    public LiveData<LoginResponse> getData() {
        return data;
    }
}
