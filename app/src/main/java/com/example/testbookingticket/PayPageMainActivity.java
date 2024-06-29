package com.example.testbookingticket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.testbookingticket.ComboPageActivity;
import com.example.testbookingticket.R;


public class PayPageMainActivity extends AppCompatActivity {
    private ImageView btn_backpage;
    private RadioButton radioBank, radioMomo, radioZaloPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_page_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.paypage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_backpage = findViewById(R.id.btn_backpage);
        radioBank = findViewById(R.id.radio_bank);
        radioMomo = findViewById(R.id.radio_momo);
        radioZaloPay = findViewById(R.id.radio_zalopay);

        btn_backpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayPageMainActivity.this, ComboPageActivity.class);
                startActivity(intent);
            }
        });


        radioBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                radioBank.setChecked(true);
                radioMomo.setChecked(false);
                radioZaloPay.setChecked(false);
            }
        });

        radioMomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioBank.setChecked(false);
                radioMomo.setChecked(true);
                radioZaloPay.setChecked(false);
            }
        });

        radioZaloPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioBank.setChecked(false);
                radioMomo.setChecked(false);
                radioZaloPay.setChecked(true);
            }
        });
    }
}