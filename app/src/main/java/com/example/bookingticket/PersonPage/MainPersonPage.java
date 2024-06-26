package com.example.bookingticket.PersonPage;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bookingticket.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPersonPage extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
//        bottomNavigationView = findViewById(R.id.bottom_nav);
////
////        bottomNavigationView.setOnItemSelectedListener(menuItem -> {
////            int itemId = menuItem.getItemId();
////            if (itemId == R.id.home) {
////                replaceFragment(new HomeFragment());
////                return true;
////            } else if (itemId == R.id.theaters) {
////                replaceFragment(new TheatersFragment());
////                return true;
////            } else if (itemId == R.id.image) {
////                replaceFragment(new ImageFragment());
////                return true;
////            } else if (itemId == R.id.person) {
////                replaceFragment(new PersonFragment());
////                return true;
////            } else {
////                return false;
////            }
////        });
////
////        replaceFragment(new PersonFragment());
////    }
//
//    private void replaceFragment(Fragment fragment) {
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}
