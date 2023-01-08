package com.example.shoppingapp.ui.HomeFrag;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.widget.ButtonBarLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.shoppingapp.R;


public class HomeFragment extends Fragment {
    private ImageView imgView1,imgView2,imgView3;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container,false);

        imgView1 = view.findViewById(R.id.imageView91);
        imgView2 = view.findViewById(R.id.imageView111);
        imgView3 = view.findViewById(R.id.imageView141);

        imgView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgView1.setImageResource(R.drawable.ic_baseline_shopping_cart2_24);
            }
        });

        imgView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgView2.setImageResource(R.drawable.ic_baseline_shopping_cart2_24);
            }
        });

        imgView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgView3.setImageResource(R.drawable.ic_baseline_shopping_cart2_24);
            }
        });

        return view;
    }
}