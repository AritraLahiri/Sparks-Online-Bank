package com.code.lahiri.basicbankingapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.code.lahiri.basicbankingapp.Adapters.HistoryAdapter;
import com.code.lahiri.basicbankingapp.DBHelper;
import com.code.lahiri.basicbankingapp.Models.TransactionsModel;
import com.code.lahiri.basicbankingapp.R;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {


    public HistoryFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.recycle);
        DBHelper db = new DBHelper(getContext());
        ArrayList<TransactionsModel> list = db.readTrans();
        HistoryAdapter adapter = new HistoryAdapter(list, getContext());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}