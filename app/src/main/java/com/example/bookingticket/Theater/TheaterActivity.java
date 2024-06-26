package com.example.bookingticket.Theater;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingticket.Adapter.TheaterAdapter;
import com.example.bookingticket.Model.Theater;
import com.example.bookingticket.R;

import java.util.List;

public class TheaterActivity extends AppCompatActivity {
    private TheaterViewModel theaterViewModel;
    private RecyclerView rcvTheater;
    private TheaterAdapter theaterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater);

        theaterViewModel = new ViewModelProvider(this).get(TheaterViewModel.class);

        rcvTheater = findViewById(R.id.rcv_theater);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvTheater.setLayoutManager(linearLayoutManager);
        theaterAdapter = new TheaterAdapter();
        rcvTheater.setAdapter(theaterAdapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvTheater.addItemDecoration(itemDecoration);

        theaterViewModel.getTheaters().observe(this, new Observer<List<Theater>>() {
            @Override
            public void onChanged(@Nullable List<Theater> theaters) {
                theaterAdapter.setTheaters(theaters);
            }
        });
    }
}
