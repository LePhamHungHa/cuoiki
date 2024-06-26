package com.example.bookingticket.homepage_lephamhungha_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookingticket.R;

public class Cinema extends AppCompatActivity {

    private ImageView iconHome, iconFilm, iconPicture, iconPerson;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);

        // Nhận màu từ Intent
        int tabNewsColor = getIntent().getIntExtra("tabNewsColor", -1);
        int tabOffersColor = getIntent().getIntExtra("tabOffersColor", -1);

        // Ánh xạ các thành phần trong layout XML

        iconHome = findViewById(R.id.icon_home);
        iconFilm = findViewById(R.id.icon_film);
        iconPicture = findViewById(R.id.icon_picture);
        iconPerson = findViewById(R.id.icon_person);

        // Thiết lập sự kiện onClickListener cho các icon
        iconHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cinema.this, MainHome.class);
                startActivity(intent);

                resetIcons();
                iconHome.setImageResource(R.drawable.iconhome_selected);
            }
        });

        iconFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetIcons();
                iconFilm.setImageResource(R.drawable.iconfilm_selected);
            }
        });

        iconPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cinema.this, News_main.class);
                startActivity(intent);
                resetIcons();
                iconPicture.setImageResource(R.drawable.iconpicture_selected);
            }
        });

        iconPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetIcons();
                iconPerson.setImageResource(R.drawable.iconperson_selected);
            }
        });
    }
// Phương thức để thiết lập lại tất cả các icon về trạng thái ban đầu
    private void resetIcons() {
        iconHome.setImageResource(R.drawable.iconhomes_bottom);
        iconFilm.setImageResource(R.drawable.iconfilm_bottom);
        iconPicture.setImageResource(R.drawable.iconpictures_bottom);
        iconPerson.setImageResource(R.drawable.iconpersons_bottom);
    }

}