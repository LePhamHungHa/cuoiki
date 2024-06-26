package com.example.bookingticket.homepage_lephamhungha_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.bookingticket.R;

public class OffersActivity extends AppCompatActivity {

    private Button tabNews, tabOffers;
    private ImageView iconHome, iconFilm, iconPicture, iconPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        // Ánh xạ các thành phần trong layout XML
        tabNews = findViewById(R.id.tab_news_main);
        tabOffers = findViewById(R.id.tab_offers);
        iconHome = findViewById(R.id.icon_home);
        iconFilm = findViewById(R.id.icon_film);
        iconPicture = findViewById(R.id.icon_picture);
        iconPerson = findViewById(R.id.icon_person);

        // Nhận màu nền từ MainActivity
        int tabNewsColor = getIntent().getIntExtra("tabNewsColor", -1);
        int tabOffersColor = getIntent().getIntExtra("tabOffersColor", -1);
        // Thiết lập màu nền của nút New bằng màu nhận được
        tabNews.setBackgroundColor(tabNewsColor);

        // thiết lập màu nền của nút Offer bằng màu nhận được
        tabOffers.setBackgroundColor(tabOffersColor);

        // Thiết lập sự kiện onClickListener cho tabNews
        tabNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Thiết lập sự kiện onClickListener cho tabOffers
        tabOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý sự kiện khi nút "ƯU ĐÃI" được nhấn
                Intent intent = new Intent(OffersActivity.this, News_main.class);
                startActivity(intent);
            }
        });

        tabNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay trở lại MainActivity
                Intent intent = new Intent(OffersActivity.this, News_main.class);
                intent.putExtra("tabNewsColor", ContextCompat.getColor(OffersActivity.this, R.color.holo_pink));
                intent.putExtra("tabOffersColor", ContextCompat.getColor(OffersActivity.this, R.color.fuchsia));
                startActivity(intent);
            }
        });

        //
        // Thiết lập sự kiện onClickListener cho các icon
        iconHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OffersActivity.this, MainHome.class);
                startActivity(intent);

                resetIcons();
                iconHome.setImageResource(R.drawable.iconhome_selected);
            }
        });

        iconFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OffersActivity.this, Cinema.class);
                startActivity(intent);
                resetIcons();
                iconFilm.setImageResource(R.drawable.iconfilm_selected);
            }
        });

        iconPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

