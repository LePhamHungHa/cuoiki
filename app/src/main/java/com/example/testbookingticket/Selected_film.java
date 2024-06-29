package com.example.testbookingticket;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Selected_film extends AppCompatActivity {
    LinearLayout[] ngayThang;
    TextView[] thu;
    TextView[] ngay;

    ImageView backpagetohome;
    Button choose_time;
    Drawable background_actived, activity_color;

    LinearLayout time_film1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_film);

        background_actived = getResources().getDrawable(R.drawable.bg_click);
        activity_color = getResources().getDrawable(R.drawable.bg_item_thu);

        ngayThang = new LinearLayout[]{
                findViewById(R.id.ngaythang1),
                findViewById(R.id.ngaythang2),
                findViewById(R.id.ngaythang3),
                findViewById(R.id.ngaythang4),
                findViewById(R.id.ngaythang5),
                findViewById(R.id.ngaythang6),
                findViewById(R.id.ngaythang7)
        };

        thu = new TextView[]{
                findViewById(R.id.thu2),
                findViewById(R.id.thu3),
                findViewById(R.id.thu4),
                findViewById(R.id.thu5),
                findViewById(R.id.thu6),
                findViewById(R.id.thu7),
                findViewById(R.id.cn)
        };

        ngay = new TextView[]{
                findViewById(R.id.ngay1),
                findViewById(R.id.ngay2),
                findViewById(R.id.ngay3),
                findViewById(R.id.ngay4),
                findViewById(R.id.ngay5),
                findViewById(R.id.ngay6),
                findViewById(R.id.ngay7)
        };

        resetNgayThangColors();
        setNgayThangClickListener();


        selectNgayThang(0);

        time_film1 = findViewById(R.id.time_film1);
        choose_time = findViewById(R.id.choose_time);
        backpagetohome = findViewById(R.id.backpagetohome);

        time_film1.setOnClickListener(v -> navigateToScreeningActivity());
        choose_time.setOnClickListener(v -> navigateToScreeningActivity());
        backpagetohome.setOnClickListener(v -> navigateToMainHome());

    }


    private void resetNgayThangColors() {
        for (LinearLayout layout : ngayThang) {
            layout.setBackground(activity_color);
        }
        for (TextView text : thu) {
            text.setTextColor(getResources().getColor(R.color.white));
        }
        for (TextView text : ngay) {
            text.setTextColor(getResources().getColor(R.color.yellow));
        }
    }

    private void setNgayThangClickListener() {
        for (int i = 0; i < ngayThang.length; i++) {
            int finalI = i;
            ngayThang[i].setOnClickListener(v -> selectNgayThang(finalI));
        }
    }

    private void selectNgayThang(int index) {
        resetNgayThangColors();
        ngayThang[index].setBackground(background_actived);
        thu[index].setTextColor(getResources().getColor(R.color.black));
        ngay[index].setTextColor(getResources().getColor(R.color.black));
    }

    private void navigateToScreeningActivity() {
        Intent intent = new Intent(Selected_film.this, ScreeningActivity.class);
        startActivity(intent);
    }

    private void navigateToMainHome() {
        Intent intent = new Intent(Selected_film.this, MainActivity.class);
        startActivity(intent);
    }
}
