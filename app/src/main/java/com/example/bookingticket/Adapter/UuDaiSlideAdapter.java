package com.example.bookingticket.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.bookingticket.R;

import java.util.ArrayList;

public class UuDaiSlideAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<Integer> uuDaiImages;
    private LayoutInflater inflater;

    public UuDaiSlideAdapter(Context context, ArrayList<Integer> uuDaiImages) {
        this.context = context;
        this.uuDaiImages = uuDaiImages;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return uuDaiImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.slideruudai_item, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(uuDaiImages.get(position));

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
