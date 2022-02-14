package com.example.uasmobprog;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
   ArrayList<Employee> employee;

   public MyAdapter(ArrayList<Employee> employee){
       this.employee = employee;
   }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_employee,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        String registered = null;

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            Date date = (Date) format.parse(employee.get(position).getRegistered().getDate());
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
            registered = sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.text1.setText(employee.get(position).getName().getFirst() + " " + employee.get(position).getName().getLast());
        holder.text2.setText("City: "+employee.get(position).getLocation().getCity() + ", "+employee.get(position).getLocation().getCountry());
        holder.text3.setText("Phone: "+employee.get(position).getPhone() + "/ " + employee.get(position).getCell());
        holder.text4.setText("Member Since: " + registered);
        Glide.with(holder.img.getContext()).load(employee.get(position).getPicture().getMedium()).into(holder.img);
        holder.cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EmployeeDetail.class);
                intent.putExtra("first",employee.get(holder.getAdapterPosition()).getName().getFirst());
                intent.putExtra("last",employee.get(holder.getAdapterPosition()).getName().getLast());
                intent.putExtra("city",employee.get(holder.getAdapterPosition()).getLocation().getCity());
                intent.putExtra("country",employee.get(holder.getAdapterPosition()).getLocation().getCountry());
                intent.putExtra("phone",employee.get(holder.getAdapterPosition()).getPhone());
                intent.putExtra("cell",employee.get(holder.getAdapterPosition()).getCell());
                intent.putExtra("email",employee.get(holder.getAdapterPosition()).getEmail());
                intent.putExtra("lat",employee.get(holder.getAdapterPosition()).getLocation().getCoordinates().getLatitude());
                intent.putExtra("long",employee.get(holder.getAdapterPosition()).getLocation().getCoordinates().getLongitude());
                intent.putExtra("register",employee.get(holder.getAdapterPosition()).getRegistered().getDate());
                intent.putExtra("picture",employee.get(holder.getAdapterPosition()).getPicture().getThumbnail());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return employee.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       TextView text1, text2, text3, text4;
       ImageView img;
       ConstraintLayout cl;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.Name);
            text2 = itemView.findViewById(R.id.City);
            text3 = itemView.findViewById(R.id.Phone);
            text4 = itemView.findViewById(R.id.Membership);
            img = itemView.findViewById(R.id.employeepic);
            cl = itemView.findViewById(R.id.constraint);
        }
    }
}
