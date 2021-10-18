package com.code.lahiri.basicbankingapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.code.lahiri.basicbankingapp.CustomerProfileActivity;
import com.code.lahiri.basicbankingapp.Models.Main_Models;
import com.code.lahiri.basicbankingapp.R;

import java.util.ArrayList;

public class Main_Adapter extends RecyclerView.Adapter<Main_Adapter.viewHolder> {

    ArrayList<Main_Models> list;
    Context context;

    public Main_Adapter(ArrayList<Main_Models> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_home_people, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final Main_Models model = list.get(position);
        holder.pic.setImageResource(model.getPic());
        holder.name.setText(model.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CustomerProfileActivity.class);
                intent.putExtra("name", model.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView pic;
        TextView name;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.pic);
            name = itemView.findViewById(R.id.name);
        }
    }

}
