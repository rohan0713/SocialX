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

public class iAdapter extends RecyclerView.Adapter<iAdapter.iViewHolder> {

    @Override
    public iViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.more_items, parent, false);
        return new iViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull iViewHolder holder, int position) {

        holder.Bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    ArrayList<categories> list;
    public iAdapter(ArrayList<categories> list){

        this.list = list;
    }

    public static class iViewHolder extends RecyclerView.ViewHolder{

        public iViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void Bind(categories service){

//            TextView name = itemView.findViewById(R.id.category_title);
//            name.setText(service.title);

            ImageView image = itemView.findViewById(R.id.imageView);
            image.setImageResource(service.image);
        }
    }
}

