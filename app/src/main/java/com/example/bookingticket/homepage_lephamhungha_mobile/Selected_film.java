package com.example.bookingticket.homepage_lephamhungha_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
    TextView thu2, thu3, thu4, thu5, thu6, thu7, cn, ngay1, ngay2, ngay3, ngay4, ngay5, ngay6, ngay7;

    ImageView backpagetohome;
    Button choose_time;
    Drawable background_actived, activity_color;
    LinearLayout[] allNgayThang;

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

        background_actived = getResources().getDrawable(R.drawable.bg_click);
        activity_color = getResources().getDrawable(R.drawable.bg_item_thu);

        ngayThang1 = findViewById(R.id.ngaythang1);
        ngayThang2 = findViewById(R.id.ngaythang2);
        ngayThang3 = findViewById(R.id.ngaythang3);
        ngayThang4 = findViewById(R.id.ngaythang4);
        ngayThang5 = findViewById(R.id.ngaythang5);
        ngayThang6 = findViewById(R.id.ngaythang6);
        ngayThang7 = findViewById(R.id.ngaythang7);
        allNgayThang = new LinearLayout[]{ngayThang1, ngayThang2, ngayThang3, ngayThang4, ngayThang5, ngayThang6, ngayThang7};

        thu2 = ngayThang1.findViewById(R.id.thu2);
        thu3 = ngayThang2.findViewById(R.id.thu3);
        thu4 = ngayThang3.findViewById(R.id.thu4);
        thu5 = ngayThang4.findViewById(R.id.thu5);
        thu6 = ngayThang5.findViewById(R.id.thu6);
        thu7 = ngayThang6.findViewById(R.id.thu7);
        cn = ngayThang7.findViewById(R.id.cn);
        ngay1 = ngayThang1.findViewById(R.id.ngay1);
        ngay2 = ngayThang2.findViewById(R.id.ngay2);
        ngay3 = ngayThang3.findViewById(R.id.ngay3);
        ngay4 = ngayThang4.findViewById(R.id.ngay4);
        ngay5 = ngayThang5.findViewById(R.id.ngay5);
        ngay6 = ngayThang6.findViewById(R.id.ngay6);
        ngay7 = ngayThang7.findViewById(R.id.ngay7);

        resetNgayThangColors();

        setNgayThangClickListener();

        time_film1 = findViewById(R.id.time_film1);
        choose_time = findViewById(R.id.choose_time);
        backpagetohome = findViewById(R.id.backpagetohome);

        time_film1.setOnClickListener(v -> {
            Intent intent = new Intent(Selected_film.this, ScreeningActivity.class);
            startActivity(intent);
        });

        choose_time.setOnClickListener(v -> {
            Intent intent = new Intent(Selected_film.this, ScreeningActivity.class);
            startActivity(intent);
        });

        backpagetohome.setOnClickListener(v -> {
            Intent intent = new Intent(Selected_film.this, MainHome.class);
            startActivity(intent);
        });
    }

    private void resetNgayThangColors() {
        for (LinearLayout ngayThang : allNgayThang) {
            ngayThang.setBackground(activity_color);
        }
        thu2.setTextColor(getResources().getColor(R.color.white));
        thu3.setTextColor(getResources().getColor(R.color.white));
        thu4.setTextColor(getResources().getColor(R.color.white));
        thu5.setTextColor(getResources().getColor(R.color.white));
        thu6.setTextColor(getResources().getColor(R.color.white));
        thu7.setTextColor(getResources().getColor(R.color.white));
        cn.setTextColor(getResources().getColor(R.color.white));
        ngay1.setTextColor(getResources().getColor(R.color.yellow));
        ngay2.setTextColor(getResources().getColor(R.color.yellow));
        ngay3.setTextColor(getResources().getColor(R.color.yellow));
        ngay4.setTextColor(getResources().getColor(R.color.yellow));
        ngay5.setTextColor(getResources().getColor(R.color.yellow));
        ngay6.setTextColor(getResources().getColor(R.color.yellow));
        ngay7.setTextColor(getResources().getColor(R.color.yellow));
    }

    @SuppressLint("ResourceType")
    private void setNgayThangClickListener() {
        for (LinearLayout ngayThang : allNgayThang) {
            ngayThang.setOnClickListener(v -> {
                resetNgayThangColors();
                ngayThang.setBackground(background_actived);
                if (ngayThang == ngayThang1) {
                    thu2.setTextColor(getResources().getColor(R.color.black));
                    ngay1.setTextColor(getResources().getColor(R.color.black));
                } else if (ngayThang == ngayThang2) {
                    thu3.setTextColor(getResources().getColor(R.color.black));
                    ngay2.setTextColor(getResources().getColor(R.color.black));
                } else if (ngayThang == ngayThang3) {
                    thu4.setTextColor(getResources().getColor(R.color.black));
                    ngay3.setTextColor(getResources().getColor(R.color.black));
                } else if (ngayThang == ngayThang4) {
                    thu5.setTextColor(getResources().getColor(R.color.black));
                    ngay4.setTextColor(getResources().getColor(R.color.black));
                } else if (ngayThang == ngayThang5) {
                    thu6.setTextColor(getResources().getColor(R.color.black));
                    ngay5.setTextColor(getResources().getColor(R.color.black));
                } else if (ngayThang == ngayThang6) {
                    thu7.setTextColor(getResources().getColor(R.color.black));
                    ngay6.setTextColor(getResources().getColor(R.color.black));
                } else if (ngayThang == ngayThang7) {
                    cn.setTextColor(getResources().getColor(R.color.black));
                    ngay7.setTextColor(getResources().getColor(R.color.black));
                }
            });
        }
    }
}



