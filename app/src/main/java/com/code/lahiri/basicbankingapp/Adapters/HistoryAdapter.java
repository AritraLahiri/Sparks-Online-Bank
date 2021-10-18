package com.code.lahiri.basicbankingapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.code.lahiri.basicbankingapp.Models.TransactionsModel;
import com.code.lahiri.basicbankingapp.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.viewHolder> {
    ArrayList<TransactionsModel> list;
    Context context;

    public HistoryAdapter(ArrayList<TransactionsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_history, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final TransactionsModel model = list.get(position);
        holder.receiver.setText(model.getReceiver());
        holder.sender.setText(model.getSender());
        holder.amount.setText(model.getAmount());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {

        TextView sender, receiver, amount;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            sender = itemView.findViewById(R.id.sender_name);
            receiver = itemView.findViewById(R.id.receiver_name);
            amount = itemView.findViewById(R.id.amount);
        }
    }
}
