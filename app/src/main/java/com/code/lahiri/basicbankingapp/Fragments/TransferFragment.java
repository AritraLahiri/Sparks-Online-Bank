package com.code.lahiri.basicbankingapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.code.lahiri.basicbankingapp.DBHelper;
import com.code.lahiri.basicbankingapp.R;

import java.util.ArrayList;

public class TransferFragment extends Fragment {

    public TransferFragment() {
        // Required empty public constructor
    }

    AutoCompleteTextView sender;
    AutoCompleteTextView receiver;
    EditText amount;
    Button btn;
    ArrayList<String> name;
    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transfer, container, false);
        DBHelper db = new DBHelper(getContext());
        sender = (AutoCompleteTextView) view.findViewById(R.id.act_sender);
        receiver = (AutoCompleteTextView) view.findViewById(R.id.act_receiver);
        btn = view.findViewById(R.id.transfer);
        name = db.getCustomerNames();
        amount = view.findViewById(R.id.amount);
        adapter = new ArrayAdapter<>(getContext(), R.layout.text_view_drop, name);
        sender.setAdapter(adapter);
        sender.setThreshold(1);
        receiver.setThreshold(1);
        receiver.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String senderName = sender.getText().toString();
                String receiverName = receiver.getText().toString();
                String amt = amount.getText().toString();
                if (senderName.length() < 1 || receiverName.length() < 1 || amount.length() < 1)
                    Toast.makeText(getContext(), "Please select all fields", Toast.LENGTH_SHORT).show();
                else if (senderName.equals(receiverName))
                    Toast.makeText(getContext(), "Sender and Receiver Same", Toast.LENGTH_SHORT).show();
                else {
                    Boolean isDeducted = db.updateData(senderName, "S", Integer.parseInt(amt));
                    Boolean isAdded = db.updateData(receiverName, "R", Integer.parseInt(amt));
                    Boolean isListed = db.insertData(senderName, receiverName, amt);
                    if (isDeducted && isAdded && isListed)
                        Toast.makeText(getContext(), "Transferred Fund! ", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getContext(), "Transaction FAILED :( ", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;

    }
}