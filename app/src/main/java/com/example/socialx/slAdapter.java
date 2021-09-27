package com.example.socialx;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class slAdapter extends RecyclerView.Adapter<slAdapter.slViewHolder> {

    @Override
    public slViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seller_item, parent, false);
        return new slViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull slViewHolder holder, int position) {

        holder.Bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    ArrayList<categories> list;
    public slAdapter(ArrayList<categories> list){

        this.list = list;
    }

    public static class slViewHolder extends RecyclerView.ViewHolder{

        public slViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void Bind(categories service){

            TextView name = itemView.findViewById(R.id.sTitle);
            name.setText(service.title);

            ImageView image = itemView.findViewById(R.id.sImage);
            image.setImageResource(service.image);

        }
    }
}

