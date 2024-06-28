package com.example.bookingticket.PersonPage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.bookingticket.LoginPage.LoginActivity;
import com.example.bookingticket.R;
import com.example.bookingticket.SettingPage;
import com.example.bookingticket.SignupPage.SignUpActivity;
import com.example.bookingticket.Theater.TheaterActivity;
import com.example.bookingticket.homepage_lephamhungha_mobile.Cinema;
import com.example.bookingticket.homepage_lephamhungha_mobile.MainHome;
import com.example.bookingticket.homepage_lephamhungha_mobile.News_main;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPersonPageFragment extends AppCompatActivity {
    private ImageView iconHome, iconFilm, iconPicture, iconPerson, settings;
    private Handler handler;
    private Runnable slideRunnable;
    private Runnable uuDaiRunnable;

    private Button btn_register, btn_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_person);

        iconHome = findViewById(R.id.icon_home);
        iconFilm = findViewById(R.id.icon_film);
        iconPicture = findViewById(R.id.icon_picture);
        iconPerson = findViewById(R.id.icon_person);
        btn_register = findViewById(R.id.btn_register);
        btn_login = findViewById(R.id.btn_login);
        settings = findViewById(R.id.settings);


        // Su kien login

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPersonPageFragment.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPersonPageFragment.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPersonPageFragment.this, SettingPage.class);
                startActivity(intent);
            }
        });


        // Thiết lập sự kiện onClickListener cho các icon
        iconHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetIcons();
                iconHome.setImageResource(R.drawable.iconhome_selected);
                // Thêm code xử lý khi click vào icon Home
            }
        });

        iconFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPersonPageFragment.this, Cinema.class);
                // Gửi màu hiện tại của Bottom Navigation cho Cinema
                intent.putExtra("iconfilm_selected", ContextCompat.getColor(MainPersonPageFragment.this, R.color.holo_pink));
                startActivity(intent);
                resetIcons();
                iconFilm.setImageResource(R.drawable.iconfilm_selected);
            }
        });

        iconPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPersonPageFragment.this, News_main.class);
                // Gửi màu hiện tại của Bottom Navigation cho News_main
                intent.putExtra("iconpicture_selected", ContextCompat.getColor(MainPersonPageFragment.this, R.color.holo_pink));
                startActivity(intent);
                resetIcons();
                iconPicture.setImageResource(R.drawable.iconpicture_selected);
            }
        });

        iconPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Không cần chuyển sang MainPersonPage vì đã ở trong MainPersonPageFragment
                resetIcons();
                iconPerson.setImageResource(R.drawable.iconperson_selected);
                // Thêm code xử lý khi click vào icon Person
            }
        });
    }

    // Phương thức để reset tất cả các icon về trạng thái ban đầu
    private void resetIcons() {
        iconHome.setImageResource(R.drawable.iconhomes_bottom);
        iconFilm.setImageResource(R.drawable.iconfilm_bottom);
        iconPicture.setImageResource(R.drawable.iconpictures_bottom);
        iconPerson.setImageResource(R.drawable.iconpersons_bottom);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Loại bỏ các callbacks của handler khi Activity bị hủy
        if (handler != null) {
            handler.removeCallbacks(slideRunnable);
            handler.removeCallbacks(uuDaiRunnable);
        }
    }
}
