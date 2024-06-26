package com.example.bookingticket.PayPage_SettingPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bookingticket.MainActivity;
import com.example.bookingticket.R;

public class SettingPage extends AppCompatActivity {

    private LinearLayout backpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.settingpage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backpage = findViewById(R.id.btn_backpage);

        backpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}