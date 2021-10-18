package com.code.lahiri.basicbankingapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.code.lahiri.basicbankingapp.Adapters.Main_Adapter;
import com.code.lahiri.basicbankingapp.DBHelper;
import com.code.lahiri.basicbankingapp.Models.Main_Models;
import com.code.lahiri.basicbankingapp.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public HomeFragment() {

    }
    RecyclerView recycle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recycle = view.findViewById(R.id.recycle);
        DBHelper db = new DBHelper(getContext());
        ArrayList<Main_Models> list = db.readCustomersPicName();
        Main_Adapter adapter = new Main_Adapter(list, getContext());
        recycle.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycle.setLayoutManager(layoutManager);
        return view;
    }
}