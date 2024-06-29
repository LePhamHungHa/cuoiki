package com.example.testbookingticket;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.testbookingticket.Adapter.SapChieuAdapter;
import com.example.testbookingticket.Adapter.SlideAdapter;
import com.example.testbookingticket.Adapter.UuDaiSlideAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ViewPager viewPager;
    private ViewPager viewPagerUuDai;
    private RecyclerView recyclerViewSapChieu;
    private SlideAdapter slideAdapter;
    private UuDaiSlideAdapter uuDaiSlideAdapter;
    private SapChieuAdapter sapChieuAdapter;
    private ArrayList<Integer> images;
    private ArrayList<Integer> uuDaiImages;
    private ArrayList<Integer> sapChieuImages;
    private ArrayList<String> captions;
    private FrameLayout tintuc, list_film, phimsapchieu;

    private Handler handler;
    private Runnable slideRunnable;
    private Runnable uuDaiRunnable;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Thiết lập padding cho layout để tránh việc nội dung bị che khuất bởi thanh điều hướng
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            v.setPadding(insets.getSystemWindowInsetLeft(), insets.getSystemWindowInsetTop(),
                    insets.getSystemWindowInsetRight(), insets.getSystemWindowInsetBottom());
            return insets;
        });

        // Khởi tạo ViewPager cho nội dung chính
        viewPager = rootView.findViewById(R.id.viewPager);
        images = new ArrayList<>();
        captions = new ArrayList<>();
        initMainViewPager();

        // Khởi tạo ViewPager cho ưu đãi
        viewPagerUuDai = rootView.findViewById(R.id.viewPageruudai);
        uuDaiImages = new ArrayList<>();
        initUuDaiViewPager();

        // Khởi tạo RecyclerView cho phim sắp chiếu
        recyclerViewSapChieu = rootView.findViewById(R.id.recyclerViewSapChieu);
        sapChieuImages = new ArrayList<>();
        initSapChieuRecyclerView();

        tintuc = rootView.findViewById(R.id.tintuc);
        list_film = rootView.findViewById(R.id.list_film);

        list_film.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), Selected_film.class);
            startActivity(intent);
        });

        tintuc.setOnClickListener(v -> {
            // Khởi tạo Intent để chuyển đến trang NewsActivity
            Intent intent = new Intent(requireActivity(), NewsActivity.class);
            startActivity(intent);
        });

        // Bắt đầu tự động cuộn trang cho ViewPager Phim và ưu đãi
        startAutoScrollMainViewPager();
        startAutoScrollUuDaiViewPager();

        return rootView;
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
        slideAdapter = new SlideAdapter(requireContext(), images, captions);
        viewPager.setAdapter(slideAdapter);
    }

    private void initUuDaiViewPager() {
        uuDaiImages.add(R.drawable.hinhuudai1);
        uuDaiImages.add(R.drawable.hinhuudai2);
        uuDaiImages.add(R.drawable.hinhuudai3);
        uuDaiImages.add(R.drawable.hinhuudai4);
        uuDaiSlideAdapter = new UuDaiSlideAdapter(requireContext(), uuDaiImages);
        viewPagerUuDai.setAdapter(uuDaiSlideAdapter);
    }

    private void initSapChieuRecyclerView() {
        sapChieuImages.add(R.drawable.phimsapchieuhinh5);
        sapChieuImages.add(R.drawable.phimsapchieuhinh2);
        sapChieuImages.add(R.drawable.phimsapchieuhinh3);
        sapChieuImages.add(R.drawable.phimsapchieuhinh4);
        sapChieuImages.add(R.drawable.phimsapchieuhinh1);
        sapChieuAdapter = new SapChieuAdapter(requireContext(), sapChieuImages);
        recyclerViewSapChieu.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewSapChieu.setAdapter(sapChieuAdapter);
    }

    private void startAutoScrollMainViewPager() {
        handler = new Handler();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Loại bỏ các callbacks của handler khi Fragment bị hủy
        if (handler != null) {
            handler.removeCallbacks(slideRunnable);
            handler.removeCallbacks(uuDaiRunnable);
        }
    }
}
