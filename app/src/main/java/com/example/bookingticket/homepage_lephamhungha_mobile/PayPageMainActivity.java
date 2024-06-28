package com.example.bookingticket.homepage_lephamhungha_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bookingticket.R;

public class PayPageMainActivity extends AppCompatActivity {
    private ImageView btn_backpage;
    private RadioGroup paymentMethodGroup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pay_page_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.paypage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_backpage = findViewById(R.id.btn_backpage);
        paymentMethodGroup = findViewById(R.id.payment_method_group);


        btn_backpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayPageMainActivity.this, ComboPageActivity.class);
                startActivity(intent);
            }
        });

        paymentMethodGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton radioButton = findViewById(checkedId);
                if (radioButton != null) {

                    if (radioButton.getId() == R.id.radio_bank) {

                    } else if (radioButton.getId() == R.id.radio_momo) {

                    } else if (radioButton.getId() == R.id.radio_zalopay) {

                    }
                }
            }
        });
    }
}