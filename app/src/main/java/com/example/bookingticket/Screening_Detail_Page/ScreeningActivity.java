package com.example.bookingticket.Screening_Detail_Page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.bookingticket.MainActivity;
import com.example.bookingticket.R;

public class ScreeningActivity extends AppCompatActivity {

    public ImageView backpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screening);

        backpage = findViewById(R.id.btn_backpage);

        backpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScreeningActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}