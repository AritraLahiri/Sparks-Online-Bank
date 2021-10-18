package com.code.lahiri.basicbankingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.code.lahiri.basicbankingapp.Models.CustomersModel;
import com.code.lahiri.basicbankingapp.databinding.ActivityCustomerProfileBinding;

import java.util.ArrayList;

public class CustomerProfileActivity extends AppCompatActivity {

    ActivityCustomerProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomerProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper db = new DBHelper(this);
        String name = getIntent().getStringExtra("name");
        ArrayList<CustomersModel> details = db.readPeopleByName(name);
        binding.profilePic.setImageResource(R.drawable.people1);
        binding.name.setText(details.get(0).getName());
        binding.email.setText("Mail :" + details.get(0).getEmail());
        binding.number.setText("Phone :" + details.get(0).getPhone());
        binding.bal.setText("Balance : $ " + details.get(0).getBalance());
        binding.address.setText("Address : $" + details.get(0).getAddress());

    }
}