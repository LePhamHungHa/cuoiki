package com.example.bookingticket.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.bookingticket.R;

import java.util.ArrayList;

public class SlideAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<Integer> images;
    private ArrayList<String> captions;

    public SlideAdapter(Context context, ArrayList<Integer> images, ArrayList<String> captions) {
        this.context = context;
        this.images = images;
        this.captions = this.captions;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayout = null;
        int layoutId = 0;

        switch (position) {
            case 0:
                layoutId = R.layout.imagemovie_hinh1;
                break;
            case 1:
                layoutId = R.layout.imagemovie_hinh2;
                break;
            case 2:
                layoutId = R.layout.imagemovie_hinh3;
                break;
            case 3:
                layoutId = R.layout.imagemovie_hinh4;
                break;
        }

        if (layoutId != 0) {
            slideLayout = inflater.inflate(layoutId, container, false);
            ImageView imageView = slideLayout.findViewById(R.id.imageView_slide);
            TextView titleTextView = slideLayout.findViewById(R.id.titleTextView);
            imageView.setImageResource(images.get(position));


            container.addView(slideLayout);
        }

        return slideLayout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
