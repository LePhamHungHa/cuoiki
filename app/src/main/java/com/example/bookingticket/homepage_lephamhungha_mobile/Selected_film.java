package com.example.bookingticket.homepage_lephamhungha_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bookingticket.R;

public class Selected_film extends AppCompatActivity {
    LinearLayout ngayThang1, ngayThang2, ngayThang3, ngayThang4, ngayThang5, ngayThang6, ngayThang7, time_film1;
    TextView thu2,thu3, thu4, thu5, thu6,thu7, cn, ngay1, ngay2, ngay3, ngay4, ngay5, ngay6, ngay7;

    Button choose_time;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selected_film);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Drawable background_actived = getResources().getDrawable(R.drawable.bg_click);

        ngayThang1 = findViewById(R.id.ngaythang1);
        thu2 = ngayThang1.findViewById(R.id.thu2);
        ngay1 = ngayThang1.findViewById(R.id.ngay1);

        ngayThang2 = findViewById(R.id.ngaythang2);
        thu3 = ngayThang2.findViewById(R.id.thu3);
        ngay2 = ngayThang2.findViewById(R.id.ngay2);
        ngayThang3 = findViewById(R.id.ngaythang3);
        thu4 = ngayThang3.findViewById(R.id.thu4);
        ngay3 = ngayThang3.findViewById(R.id.ngay3);
        ngayThang4 = findViewById(R.id.ngaythang4);
        thu5 = ngayThang4.findViewById(R.id.thu5);
        ngay4 = ngayThang4.findViewById(R.id.ngay4);
        ngayThang5 = findViewById(R.id.ngaythang5);
        thu6 = ngayThang5.findViewById(R.id.thu6);
        ngay5 = ngayThang5.findViewById(R.id.ngay5);
        ngayThang6 = findViewById(R.id.ngaythang6);
        thu7 = ngayThang6.findViewById(R.id.thu7);
        ngay6 = ngayThang6.findViewById(R.id.ngay6);
        ngayThang7 = findViewById(R.id.ngaythang7);
        cn = ngayThang7.findViewById(R.id.cn);
        ngay7 = ngayThang7.findViewById(R.id.ngay7);
        time_film1 = findViewById(R.id.time_film1);
        choose_time = findViewById(R.id.choose_time);

        ngayThang1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngayThang1.setBackground(background_actived);
//                thu2.setTextColor(getResources().getColor(R.color.active_color));
//                ngay1.setTextColor(getResources().getColor(R.color.active_color));
            }
        });
        ngayThang2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngayThang2.setBackground(background_actived);
//                thu3.setTextColor(getResources().getColor(R.color.active_color));
//                ngay2.setTextColor(getResources().getColor(R.color.active_color));
            }
        });
        ngayThang3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngayThang3.setBackground(background_actived);
//                thu4.setTextColor(getResources().getColor(R.color.active_color));
//                ngay3.setTextColor(getResources().getColor(R.color.active_color));
            }
        });
        ngayThang4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngayThang4.setBackground(background_actived);
//                thu5.setTextColor(getResources().getColor(R.color.active_color));
//                ngay4.setTextColor(getResources().getColor(R.color.active_color));
            }
        });
        ngayThang5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngayThang5.setBackground(background_actived);
//                thu6.setTextColor(getResources().getColor(R.color.active_color));
//                ngay5.setTextColor(getResources().getColor(R.color.active_color));
            }
        });
        ngayThang6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngayThang6.setBackground(background_actived);
//                thu7.setTextColor(getResources().getColor(R.color.active_color));
//                ngay6.setTextColor(getResources().getColor(R.color.active_color));
            }
        });
        ngayThang7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngayThang7.setBackground(background_actived);
//                cn.setTextColor(getResources().getColor(R.color.active_color));
//                ngay7.setTextColor(getResources().getColor(R.color.active_color));
            }
        });

        time_film1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Selected_film.this, ScreeningActivity.class);
                startActivity(intent);
            }
        });
        choose_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Selected_film.this, ScreeningActivity.class);
                startActivity(intent);
            }
        });

    }
}