package com.example.testbookingticket.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testbookingticket.Model.Theater;
import com.example.testbookingticket.R;

import java.util.ArrayList;
import java.util.List;

public class TheaterAdapter extends RecyclerView.Adapter<TheaterAdapter.TheaterViewHolder> {
    private List<Theater> theaters = new ArrayList<>();

    public void setTheaters(List<Theater> theaters) {
        this.theaters = theaters;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TheaterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_theater, parent, false);
        return new TheaterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheaterViewHolder holder, int position) {
        Theater theater = theaters.get(position);
        holder.tenTextView.setText(theater.gettheater_name());
        holder.tinhTextView.setText(theater.getprovince());
    }

    @Override
    public int getItemCount() {
        return theaters.size();
    }

    static class TheaterViewHolder extends RecyclerView.ViewHolder {
        TextView tenTextView;
        TextView tinhTextView;

        TheaterViewHolder(@NonNull View itemView) {
            super(itemView);
            tenTextView = itemView.findViewById(R.id.theater_name);
            tinhTextView = itemView.findViewById(R.id.province);
        }
    }
}
