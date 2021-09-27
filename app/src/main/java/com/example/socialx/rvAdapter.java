package com.example.socialx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rvAdapter extends RecyclerView.Adapter<rvAdapter.rvViewHolder> {

    @Override
    public rvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new rvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rvViewHolder holder, int position) {

        holder.Bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    ArrayList<categories> list;
    public rvAdapter(ArrayList<categories> list){

        this.list = list;
    }

    public static class rvViewHolder extends RecyclerView.ViewHolder{

        public rvViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void Bind(categories service){

            TextView name = itemView.findViewById(R.id.category_title);
            name.setText(service.title);

            ImageView image = itemView.findViewById(R.id.category_image);
            image.setImageResource(service.image);
            image.setBackgroundResource(R.drawable.background_category);

        }
    }
}

