package com.example.bookingticket.homepage_lephamhungha_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookingticket.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SeatActivity extends AppCompatActivity {

    private TextView tvSelectedSeats;
    private TextView tvTotalPrice;
    private ArrayList<String> selectedSeats = new ArrayList<>();
    private final int seatPrice = 45000;

    private GridLayout seatLayout;

    private ImageView tocombo;
    private HashSet<String> soldSeats = new HashSet<>(Arrays.asList("D02", "D03", "D04"));

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);

        seatLayout = findViewById(R.id.seatLayout);
        tvSelectedSeats = findViewById(R.id.tvSelectedSeats);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        tocombo = findViewById(R.id.tocombo);

        // Thêm ghế động
        addSeats();

        tocombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeatActivity.this, ComboPageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addSeats() {
        String[] seatNames = {
                "A01", "A02", "A03", "A04", "A05", "A06", "A07", "A08", "A09", "A10",
                "B01", "B02", "B03", "B04", "B05", "B06", "B07", "B08", "B09", "B10",
                "C01", "C02", "C03", "C04", "C05", "C06", "C07", "C08", "C09", "C10",
                "D01", "D02", "D03", "D04", "D05", "D06", "D07", "D08", "D09", "D10",
                "E01", "E02", "E03", "E04", "E05", "E06", "E07", "E08", "E09", "E10",
                "F01", "F02", "F03", "F04", "F05", "F06", "F07", "F08", "F09", "F10",
                "G01", "G02", "G03", "G04", "G05", "G06", "G07", "G08", "G09", "G10",
                "H01", "H02", "H03", "H04", "H05", "H06", "H07", "H08", "H09", "H10",
                "I01", "I02", "I03", "I04", "I05", "I06", "I07", "I08", "I09", "I10",
                "J01", "J02", "J03", "J04", "J05", "J06", "J07", "J08", "J09", "J10"
        };

        for (String seatName : seatNames) {
            Button seat = new Button(this);
            seat.setText(seatName);
            seat.setTextSize(12);
            seat.setPadding(8, 8, 8, 8);

            if (soldSeats.contains(seatName)) {
                seat.setBackgroundColor(Color.GRAY); // Màu ghế đã bán
                seat.setEnabled(false); // Không thể chọn ghế đã bán
            } else {
                seat.setBackgroundColor(Color.GREEN); // Màu ghế trống
                seat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (selectedSeats.contains(seatName)) {
                            selectedSeats.remove(seatName);
                            seat.setBackgroundColor(Color.GREEN); // Ghế trống
                        } else {
                            selectedSeats.add(seatName);
                            seat.setBackgroundColor(Color.YELLOW); // Ghế đã chọn
                        }
                        updateSelectedSeatsAndPrice();
                    }
                });
            }

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 0;
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
            params.setMargins(4, 4, 4, 4);
            seat.setLayoutParams(params);

            seatLayout.addView(seat);
        }
    }

    private void updateSelectedSeatsAndPrice() {
        StringBuilder seats = new StringBuilder();
        for (String seat : selectedSeats) {
            seats.append(seat).append(", ");
        }
        if (seats.length() > 0) {
            seats.setLength(seats.length() - 2);  // Xóa dấu phẩy và khoảng trắng cuối cùng
        }

        tvSelectedSeats.setText(String.format("%d Ghế: %s", selectedSeats.size(), seats.toString()));
        tvTotalPrice.setText(String.format("Tổng cộng: %,d", selectedSeats.size() * seatPrice));
    }
}