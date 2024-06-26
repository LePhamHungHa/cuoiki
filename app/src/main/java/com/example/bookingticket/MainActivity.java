//package com.example.bookingticket;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//
//import com.example.bookingticket.Admin.AdminActivity;
//import com.example.bookingticket.PayPage_SettingPage.PayPage;
//import com.example.bookingticket.PayPage_SettingPage.SettingPage;
//import com.example.bookingticket.PersonPage.MainPersonPage;
//import com.example.bookingticket.PersonPage.PersonFragment;
//import com.example.bookingticket.ProfilePhim.ProfilePhim;
//import com.example.bookingticket.Screening_Detail_Page.ScreeningActivity;
//import com.example.bookingticket.SignupPage.SignUpActivity;
//import com.example.bookingticket.Theater.TheaterActivity;
//
//public class MainActivity extends AppCompatActivity {
//
//    private Button trangthanhtoan, trangsetting, trangscreening, trangperson, trangprofilephim, signup;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
////
////        trangthanhtoan = findViewById(R.id.trangthanhtoan);
////        trangsetting = findViewById(R.id.trangsetting);
////        trangscreening = findViewById(R.id.trangscreening);
////        trangperson = findViewById(R.id.trangperson);
////        trangprofilephim = findViewById(R.id.trangprofilephim);
////        signup = findViewById(R.id.signup);
//
////        trangprofilephim.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(MainActivity.this, ProfilePhim.class);
////                startActivity(intent);
////            }
////        });
////
////        trangthanhtoan.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(MainActivity.this, PayPage.class);
////                startActivity(intent);
////            }
////        });
////
////        trangsetting.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(MainActivity.this, SettingPage.class);
////                startActivity(intent);
////            }
////        });
////
////        trangscreening.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(MainActivity.this, ScreeningActivity.class);
////                startActivity(intent);
////            }
////        });
//
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, AdminActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//}