package com.example.testbookingticket.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.testbookingticket.API.ApiService;
import com.example.testbookingticket.Model.Theater;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TheaterRepository {
    private ApiService apiService;
    private MutableLiveData<List<Theater>> theatersLiveData = new MutableLiveData<>();

    public TheaterRepository() {
        this.apiService = ApiService.api;
    }

    public MutableLiveData<List<Theater>> getAllTheaters() {
        apiService.getAllTheaters().enqueue(new Callback<List<Theater>>() {
            @Override
            public void onResponse(Call<List<Theater>> call, Response<List<Theater>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    theatersLiveData.postValue(response.body());
                    Log.e("Theater", ""+response.body());

                } else {
                    Log.e("Theater", "Response not successful or body is null");
                }
            }

            @Override
            public void onFailure(Call<List<Theater>> call, Throwable t) {
                Log.e("Theater", "Failed to fetch data", t);
            }
        });
        return theatersLiveData;
    }
}
