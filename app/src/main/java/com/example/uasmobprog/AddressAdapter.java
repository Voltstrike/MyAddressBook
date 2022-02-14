package com.example.uasmobprog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.MyViewHolder> {
    Context context;
    public AddressAdapter(Context ct){
        context = ct;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.list_address,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(EmployeeDetail.address.get(position).getFirst() + EmployeeDetail.address.get(position).getLast());
//        holder.text2.setText("City: "+EmployeeDetail.address.get(position).getCity()+", "+EmployeeDetail.address.get(position).getCountry());
//        Glide.with(holder.image.getContext()).load(EmployeeDetail.address.get(position).getPicture()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return EmployeeDetail.address.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1,text2;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1.findViewById(R.id.AddName);
            text2.findViewById(R.id.AddCity);
            image.findViewById(R.id.AddImage);
        }
    }
}
