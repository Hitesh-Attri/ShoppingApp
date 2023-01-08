package com.example.shoppingapp.ui.cartFragment;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.shoppingapp.MyDBHelper;
import com.example.shoppingapp.R;


public class CartFragment extends Fragment {
    Button btnPlaceOrder;
    MyDBHelper myDBHelper;

    public CartFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container,false);
        myDBHelper = new MyDBHelper(getContext());

        btnPlaceOrder = view.findViewById(R.id.buttonPlaceOrder);
        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myDBHelper.isItemInCart()){
                    myDBHelper.deleteTableCart();;
                    Toast.makeText(getContext(), "Your order has successfully placed", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getContext(), "No items in your cart", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}