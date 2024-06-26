package com.example.bookingticket.homepage_lephamhungha_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.bookingticket.Adapter.SapChieuAdapter;
import com.example.bookingticket.Adapter.SlideAdapter;
import com.example.bookingticket.Adapter.UuDaiSlideAdapter;
import com.example.bookingticket.LoginPage.LoginActivity;
import com.example.bookingticket.PersonPage.MainPersonPageFragment;
import com.example.bookingticket.PersonPage.PersonFragment;
import com.example.bookingticket.R;

import java.util.ArrayList;

public class MainHome extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPager viewPagerUuDai;
    private RecyclerView recyclerViewSapChieu;
    private ImageView iconHome, iconFilm, iconPicture, iconPerson;
    private SlideAdapter slideAdapter;
    private UuDaiSlideAdapter uuDaiSlideAdapter;
    private SapChieuAdapter sapChieuAdapter;
    private ArrayList<Integer> images;
    private ArrayList<Integer> uuDaiImages;
    private ArrayList<Integer> sapChieuImages;
    private ArrayList<String> captions;
    private FrameLayout tintuc,list_film, phimsapchieu;


    private Handler handler;
    private Runnable slideRunnable;
    private Runnable uuDaiRunnable;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Thiết lập padding cho layout để tránh việc nội dung bị che khuất bởi thanh điều hướng
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            v.setPadding(insets.getSystemWindowInsetLeft(), insets.getSystemWindowInsetTop(),
                    insets.getSystemWindowInsetRight(), insets.getSystemWindowInsetBottom());
            return insets;
        });


        // Khởi tạo ViewPager cho nội dung chính
        viewPager = findViewById(R.id.viewPager);
        images = new ArrayList<>();
        captions = new ArrayList<>();
        initMainViewPager();

        // Khởi tạo ViewPager cho ưu đãi
        viewPagerUuDai = findViewById(R.id.viewPageruudai);
        uuDaiImages = new ArrayList<>();
        initUuDaiViewPager();

        // Khởi tạo RecyclerView cho phim sắp chiếu
        recyclerViewSapChieu = findViewById(R.id.recyclerViewSapChieu);
        sapChieuImages = new ArrayList<>();
        initSapChieuRecyclerView();

        // Bắt đầu tự động cuộn trang cho ViewPager Phim
        handler = new Handler();
        startAutoScrollMainViewPager();

        // Bắt đầu tự động cuộn trang cho ViewPager ưu đãi
        startAutoScrollUuDaiViewPager();


        // Ánh xạ các thành phần trong layout XML

        iconHome = findViewById(R.id.icon_home);
        iconFilm = findViewById(R.id.icon_film);
        iconPicture = findViewById(R.id.icon_picture);
        iconPerson = findViewById(R.id.icon_person);
        tintuc = findViewById(R.id.tintuc);
        list_film = findViewById(R.id.list_film);
//        phimsapchieu = findViewById(R.id.phimsapchieu);
//
        list_film.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainHome.this, Selected_film.class);
                startActivity(intent);
            }
        });

        tintuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khởi tạo Intent để chuyển đến trang NewsActivity
                Intent intent = new Intent(MainHome.this, NewsActivity.class);
                startActivity(intent);
            }
        });

        // Thiết lập sự kiện onClickListener cho các icon
        iconHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetIcons();
                iconHome.setImageResource(R.drawable.iconhome_selected);
            }
        });

        iconFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainHome.this, Cinema.class);
                // Gửi màu hiện tại của Bottom Navigation cho News_main
                intent.putExtra("iconfilm_selected", ContextCompat.getColor(MainHome.this, R.color.holo_pink));
                startActivity(intent);
                resetIcons();
                iconFilm.setImageResource(R.drawable.iconfilm_selected);
            }
        });

        iconPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainHome.this, News_main.class);
                // Gửi màu hiện tại của Bottom Navigation cho News_main
                intent.putExtra("iconpicture_selected", ContextCompat.getColor(MainHome.this, R.color.holo_pink));

                startActivity(intent);
                resetIcons();
                iconPicture.setImageResource(R.drawable.iconpicture_selected);
            }
        });

        iconPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainHome.this, MainPersonPageFragment.class);
                startActivity(intent);
                resetIcons();
                iconPerson.setImageResource(R.drawable.iconperson_selected);
            }
        });
        }


    private void initMainViewPager() {
        images.add(R.drawable.hinh1);
        images.add(R.drawable.hinh2);
        images.add(R.drawable.hinh3);
        images.add(R.drawable.hinh4);
        captions.add("Tà Khúc Triệu Vong (T18)");
        captions.add("TAROT (T18)");
        captions.add("Lật mặt 7 (Một điều ước)");
        captions.add("Godzilla vs Kong");
        slideAdapter = new SlideAdapter(this, images, captions);
        viewPager.setAdapter(slideAdapter);
    }

    private void initUuDaiViewPager() {
        uuDaiImages.add(R.drawable.hinhuudai1);
        uuDaiImages.add(R.drawable.hinhuudai2);
        uuDaiImages.add(R.drawable.hinhuudai3);
        uuDaiImages.add(R.drawable.hinhuudai4);
        uuDaiSlideAdapter = new UuDaiSlideAdapter(this, uuDaiImages);
        viewPagerUuDai.setAdapter(uuDaiSlideAdapter);
    }

    private void initSapChieuRecyclerView() {
        sapChieuImages.add(R.drawable.phimsapchieuhinh5);
        sapChieuImages.add(R.drawable.phimsapchieuhinh2);
        sapChieuImages.add(R.drawable.phimsapchieuhinh3);
        sapChieuImages.add(R.drawable.phimsapchieuhinh4);
        sapChieuImages.add(R.drawable.phimsapchieuhinh1);
        sapChieuAdapter = new SapChieuAdapter(this, sapChieuImages);
        recyclerViewSapChieu.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewSapChieu.setAdapter(sapChieuAdapter);
    }

    private void startAutoScrollMainViewPager() {
        slideRunnable = new Runnable() {
            @Override
            public void run() {
                int currentItem = viewPager.getCurrentItem();
                int totalItems = slideAdapter.getCount();
                currentItem = (currentItem + 1) % totalItems;
                viewPager.setCurrentItem(currentItem, true); // true để có hiệu ứng cuộn mượt mà
                handler.postDelayed(this, 8000); // 8000 milliseconds = 8 giây
            }
        };
        handler.postDelayed(slideRunnable, 8000); // Bắt đầu cuộn trang sau 8 giây đầu tiên
    }

    private void startAutoScrollUuDaiViewPager() {
        uuDaiRunnable = new Runnable() {
            @Override
            public void run() {
                int currentItem = viewPagerUuDai.getCurrentItem();
                int totalItems = uuDaiSlideAdapter.getCount();
                currentItem = (currentItem + 1) % totalItems;
                viewPagerUuDai.setCurrentItem(currentItem, true); // true để có hiệu ứng cuộn mượt mà
                handler.postDelayed(this, 5000); // 5000 milliseconds = 5 giây
            }
        };
        handler.postDelayed(uuDaiRunnable, 5000); // Bắt đầu cuộn trang sau 5 giây đầu tiên
    }



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
        handler.removeCallbacks(slideRunnable);
        handler.removeCallbacks(uuDaiRunnable);
    }
}
