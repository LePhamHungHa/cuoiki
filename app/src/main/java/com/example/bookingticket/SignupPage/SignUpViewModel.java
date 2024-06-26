package com.example.bookingticket.SignupPage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bookingticket.Model.User.UserBody;
import com.example.bookingticket.Repository.UserRepository;


public class SignUpViewModel extends ViewModel {
    private UserRepository userRepository;

    private LiveData<UserBody> data = new MutableLiveData<>();

    public SignUpViewModel() {
        this.userRepository = new UserRepository();
    }


    public void register(UserBody userBody) {
        data = userRepository.register(userBody);
    }

    public LiveData<UserBody> getData() {
        return data;
    }
}
