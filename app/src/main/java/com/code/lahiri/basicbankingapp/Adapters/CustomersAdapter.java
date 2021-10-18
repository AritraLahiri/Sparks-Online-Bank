package com.code.lahiri.basicbankingapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.code.lahiri.basicbankingapp.CustomerProfileActivity;
import com.code.lahiri.basicbankingapp.Models.CustomersModel;
import com.code.lahiri.basicbankingapp.R;

import java.util.ArrayList;

public class CustomersAdapter extends RecyclerView.Adapter<CustomersAdapter.viewHolder> {
    ArrayList<CustomersModel> list;
    LinearLayout linear;
    Context context;

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_customers, parent, false);
        return new viewHolder(view);
    }

    public CustomersAdapter(ArrayList<CustomersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final CustomersModel model = list.get(position);
        holder.profileImage.setImageResource(model.getImage());
        holder.name.setText(model.getName());
        holder.phone.setText(model.getPhone());
        holder.email.setText(model.getEmail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CustomerProfileActivity.class);
                intent.putExtra("name", model.getName());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView name, phone, email;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.imagePep);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.number);
            linear = itemView.findViewById(R.id.linear);

        }
    }


}
