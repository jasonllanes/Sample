package com.example.librarysystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private Context context;
    private ArrayList id,name,email,password;

    public MyRecyclerAdapter(Context context, ArrayList id, ArrayList name, ArrayList email, ArrayList password) {
        this.context = context;
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.etID.setText(String.valueOf(id.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView etID,etName,etEmail,etPassword;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            etID = itemView.findViewById(R.id.etName);
            etName = itemView.findViewById(R.id.etName);
            etEmail = itemView.findViewById(R.id.etEmail);
            etPassword = itemView.findViewById(R.id.etPassword);
        }
    }
}
