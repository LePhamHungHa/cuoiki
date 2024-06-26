package com.example.bookingticket.PersonPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookingticket.R;
import androidx.fragment.app.Fragment;

public class PersonFragment extends Fragment {

    public PersonFragment() {
        // Required empty public constructor
    }

    public View o(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false);
    }
}