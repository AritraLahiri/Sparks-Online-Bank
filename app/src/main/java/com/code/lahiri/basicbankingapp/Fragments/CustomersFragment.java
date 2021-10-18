package com.code.lahiri.basicbankingapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.code.lahiri.basicbankingapp.Adapters.CustomersAdapter;
import com.code.lahiri.basicbankingapp.DBHelper;
import com.code.lahiri.basicbankingapp.Models.CustomersModel;
import com.code.lahiri.basicbankingapp.R;

import java.util.ArrayList;

public class CustomersFragment extends Fragment {

    public CustomersFragment() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customers, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        DBHelper db = new DBHelper(getContext());
        ArrayList<CustomersModel> list = db.readCustomers();
        //        db.insertDataCustomer("Aritra" , "aritralahiri17@gmail.com" , "466/4,", 100, "" , 987538185);
//        db.insertDataCustomer("Amit" , "amit17@gmail.com" , "691,/ New York,", 200, "" , 98656236);
//        db.insertDataCustomer("Sumit" , "sumit17@gmail.com" , "466/4 Behala Purba,", 300, "" , 987898566);
//        db.insertDataCustomer("Priya" , "priya17@gmail.com" , "31/1, Salt Lake ", 400, "" , 987565322);
//        db.insertDataCustomer("Rimi" , "rimit17@gmail.com" , "12/0,behgharia city ", 500, "" , 988838185);
//        db.insertDataCustomer("Somobroto" , "somomo17@gmail.com" , "466/4, bibirhat road", 600, "" , 807538185);
//        db.insertDataCustomer("Akash" , "akash17@gmail.com" , "Sector 5 , Salt lake", 700, "" , 997538185);
//        db.insertDataCustomer("Arnab" , "arnab17@gmail.com" , "4/3, Mominput bridge crossing", 800, "" , 93371185);
//        db.insertDataCustomer("Shreya" , "shreya17@gmail.com" , "12/B , Anwar shah road", 900, "" , 911538185);
//        db.insertDataCustomer("Shubho" , "shubho17@gmail.com" , "16/b, Sanfrancisco City", 1000, "" , 03313656);
        CustomersAdapter adapter = new CustomersAdapter(list, getContext());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}
