package com.example.demomvvmapplication.data.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demomvvmapplication.R;
import com.example.demomvvmapplication.data.pojo.UserDetail;


import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    List<UserDetail> allUserData;
    Context context;

    public CustomAdapter(List<UserDetail> allUserData, Context context) {
        this.allUserData = allUserData;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout,parent,false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CustomViewHolder holder, int position) {

        holder.name.setText(allUserData.get(position).getName());
        holder.username.setText(allUserData.get(position).getUsername());
        holder.address.setText(allUserData.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return allUserData.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView name, username, address;

        public CustomViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            username = itemView.findViewById(R.id.user_name);
            address = itemView.findViewById(R.id.address);
        }
    }
}
