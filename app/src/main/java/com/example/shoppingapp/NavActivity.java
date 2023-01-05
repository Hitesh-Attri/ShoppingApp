package com.example.shoppingapp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.shoppingapp.ui.AccFragment.AccountFragment;
import com.example.shoppingapp.ui.cartFragment.CartFragment;
import com.example.shoppingapp.ui.home.homeFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.shoppingapp.databinding.ActivityNavBinding;
/*
public class NavActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    private AppBarConfiguration mAppBarConfiguration;
private ActivityNavBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityNavBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNav.toolbar);
        binding.appBarNav.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
//        DrawerLayout drawer = binding.drawerLayout;

        NavigationView navigationView2 = findViewById(R.id.nav_view);
        navigationView2.setNavigationItemSelectedListener(this);
        if(savedInstanceState==null){
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_nav,new homeFragment()).commit();
        navigationView2.setCheckedItem(R.id.nav_home);}
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_nav,new homeFragment()).commit();
                break;
            case R.id.nav_AccInfo:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_nav,new AccountFragment()).commit();
                break;
            case R.id.nav_cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_nav,new CartFragment()).commit();
                break;
            case R.id.signOutText:
                Toast.makeText(this, "sign out action here", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nav);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

 */

public class NavActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_nav,
                    new homeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_nav,
                        new homeFragment()).commit();
                break;
            case R.id.nav_AccInfo:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_nav,
                        new AccountFragment()).commit();
                break;
            case R.id.nav_cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_nav,
                        new CartFragment()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}