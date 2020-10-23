package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    Context cn;
    ArrayList user_id,user_mob;
    public UsersAdapter(Context cn,ArrayList user_id,ArrayList user_mob){
        this.user_id=user_id;
        this.user_mob=user_mob;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_myview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         holder.txtview1.setText(String.valueOf(user_id.get(position)));
         holder.txtview.setText(String.valueOf(user_mob.get(position)));
    }

    @Override
    public int getItemCount() {
        return user_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtview,txtview1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtview1 = itemView.findViewById(R.id.txt1);
            txtview = itemView.findViewById(R.id.txt2);
        }
    }
}
