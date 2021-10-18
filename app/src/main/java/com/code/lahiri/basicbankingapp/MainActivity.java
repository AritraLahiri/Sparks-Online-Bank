package com.code.lahiri.basicbankingapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.code.lahiri.basicbankingapp.Fragments.CustomersFragment;
import com.code.lahiri.basicbankingapp.Fragments.HistoryFragment;
import com.code.lahiri.basicbankingapp.Fragments.HomeFragment;
import com.code.lahiri.basicbankingapp.Fragments.TransferFragment;
import com.code.lahiri.basicbankingapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, new HomeFragment());
        transaction.commit();
        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.home:
                        transaction.replace(R.id.frame, new HomeFragment());
                        break;
                    case R.id.people:
                        transaction.replace(R.id.frame, new CustomersFragment());
                        break;
                    case R.id.history:

                        transaction.replace(R.id.frame, new HistoryFragment());
                        break;
                    case R.id.transfer:
                        transaction.replace(R.id.frame, new TransferFragment());
                        break;
                }
                transaction.commit();
                return true;
            }
        });


    }
}