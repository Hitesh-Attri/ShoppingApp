package com.example.shoppingapp.ui.AccFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shoppingapp.AccInfoAct;
import com.example.shoppingapp.NavActivity;
import com.example.shoppingapp.R;
import com.example.shoppingapp.ui.HomeFrag.HomeFragment;


public class AccountFragment extends Fragment {
    Activity context;

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = (Activity) getContext();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_accinfo, container,false);


        return view;
    }

    public void onStart(){
        super.onStart();

        Button homeBtn = (Button) context.findViewById(R.id.backToHome);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_nav,
                        new HomeFragment()).commit();
            }
        });

    }


}