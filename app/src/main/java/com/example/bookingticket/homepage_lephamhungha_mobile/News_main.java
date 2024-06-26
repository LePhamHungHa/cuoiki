package com.example.bookingticket.homepage_lephamhungha_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.bookingticket.R;

public class News_main extends AppCompatActivity {
    private Button tabNews, tabOffers;

    private ImageView iconHome, iconFilm, iconPicture, iconPerson;

    private LinearLayout newsMorong;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_main);

        // Ánh xạ các thành phần trong layout XML
        tabNews = findViewById(R.id.tab_news_main);
        tabOffers = findViewById(R.id.tab_offers);
        iconHome = findViewById(R.id.icon_home);
        iconFilm = findViewById(R.id.icon_film);
        iconPicture = findViewById(R.id.icon_picture);
        newsMorong = findViewById(R.id.news_morong);
        iconPerson = findViewById(R.id.icon_person);


        // Thiết lập sự kiện onClickListener cho newsMorong
        newsMorong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khởi tạo Intent để chuyển đến trang NewsActivity
                Intent intent = new Intent(News_main.this, NewsActivity.class);
                startActivity(intent);
            }
        });

        // Nhận màu nền từ OffersActivity (nếu có)
        int tabNewsColor = getIntent().getIntExtra("tabNewsColor", -1);
        int tabOffersColor = getIntent().getIntExtra("tabOffersColor", -1);

        //  thiết lập lại màu của tab News và tab Offers
        if (tabNewsColor != -1 && tabOffersColor != -1) {
            tabNews.setBackgroundColor(tabNewsColor);
            tabOffers.setBackgroundColor(tabOffersColor);
        }

        // Thiết lập sự kiện onClickListener cho tabNews
        tabNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thiết lập màu nền của nút TIN TỨC
                tabNews.setBackgroundColor(ContextCompat.getColor(News_main.this, R.color.holo_pink));
                // Thiết lập màu nền của nút ƯU ĐÃI
                tabOffers.setBackgroundColor(ContextCompat.getColor(News_main.this, R.color.fuchsia));
            }
        });

        // Thiết lập sự kiện onClickListener cho tabOffers
        tabOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thiết lập màu nền của nút TIN TỨC
                tabNews.setBackgroundColor(ContextCompat.getColor(News_main.this, R.color.fuchsia));
                // Thiết lập màu nền của nút ƯU ĐÃI
                tabOffers.setBackgroundColor(ContextCompat.getColor(News_main.this, R.color.holo_pink));

                // Khởi tạo Intent để chuyển đến OffersActivity
                Intent intent = new Intent(News_main.this, OffersActivity.class);
                intent.putExtra("tabNewsColor", ContextCompat.getColor(News_main.this, R.color.fuchsia));
                intent.putExtra("tabOffersColor", ContextCompat.getColor(News_main.this, R.color.holo_pink));
                startActivity(intent);
            }
        });


        // Thiết lập sự kiện onClickListener cho các icon
        iconHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(News_main.this, MainHome.class);
                startActivity(intent);
                resetIcons();
                iconHome.setImageResource(R.drawable.iconhome_selected);
            }
        });

        iconFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(News_main.this, Cinema.class);
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

