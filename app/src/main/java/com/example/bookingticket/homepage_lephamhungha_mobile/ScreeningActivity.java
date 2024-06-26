package com.example.bookingticket.homepage_lephamhungha_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookingticket.R;

public class ScreeningActivity extends AppCompatActivity {

    private ImageView backpage;
    private TextView amount1, amount2, amount3;
    private Button plus1, plus2, plus3, minus1, minus2, minus3;
    private TextView txt_count_seat, txt_sum_seat;
    private int seatPrice = 70000; // Giá vé người lớn
     private ImageButton imageButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screening);

        // Ánh xạ các thành phần từ XML
        backpage = findViewById(R.id.btn_backpage);
        amount1 = findViewById(R.id.amount1);
        amount2 = findViewById(R.id.amount2);
        amount3 = findViewById(R.id.amount3);
        plus1 = findViewById(R.id.plus1);
        plus2 = findViewById(R.id.plus2);
        plus3 = findViewById(R.id.plus3);
        minus1 = findViewById(R.id.minus1);
        minus2 = findViewById(R.id.minus2);
        minus3 = findViewById(R.id.minus3);
        txt_count_seat = findViewById(R.id.txt_count_seat);
        txt_sum_seat = findViewById(R.id.txt_sum_seat);
        imageButton3 = findViewById(R.id.imageButton3);

        // Thiết lập sự kiện onClick cho nút quay lại
        backpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScreeningActivity.this, Selected_film.class);
                startActivity(intent);
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScreeningActivity.this, SeatActivity.class);
                startActivity(intent);
            }
        });
        // Thiết lập sự kiện onClick cho nút +
        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementAmount(amount1);
            }
        });

        plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementAmount(amount2);
            }
        });

        plus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementAmount(amount3);
            }
        });

        // Thiết lập sự kiện onClick cho nút -
        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementAmount(amount1);
            }
        });

        minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementAmount(amount2);
            }
        });

        minus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementAmount(amount3);
            }
        });
    }

    // Phương thức tăng giá trị số lượng và cập nhật hiển thị
    private void incrementAmount(TextView textView) {
        int currentAmount = Integer.parseInt(textView.getText().toString());
        currentAmount++;
        textView.setText(String.valueOf(currentAmount));
        updateSelectedSeatsAndPrice();
    }

    // Phương thức giảm giá trị số lượng và cập nhật hiển thị
    private void decrementAmount(TextView textView) {
        int currentAmount = Integer.parseInt(textView.getText().toString());
        if (currentAmount > 0) {
            currentAmount--;
            textView.setText(String.valueOf(currentAmount));
            updateSelectedSeatsAndPrice();
        }
    }

    // Phương thức cập nhật số lượng ghế và tổng giá vé
    private void updateSelectedSeatsAndPrice() {
        int totalSeats = Integer.parseInt(amount1.getText().toString()) +
                Integer.parseInt(amount2.getText().toString()) +
                Integer.parseInt(amount3.getText().toString());

        int totalPrice = Integer.parseInt(amount1.getText().toString()) * seatPrice +
                Integer.parseInt(amount2.getText().toString()) * 45000 + // Giá vé HSSV
                Integer.parseInt(amount3.getText().toString()) * 145000; // Giá vé đôi người lớn

        txt_count_seat.setText(String.format("%d Ghế:", totalSeats));
        txt_sum_seat.setText(String.format("Tổng cộng: %,d đ", totalPrice));
    }
}
