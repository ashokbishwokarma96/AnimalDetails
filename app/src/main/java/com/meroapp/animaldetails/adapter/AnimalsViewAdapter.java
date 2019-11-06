package com.meroapp.animaldetails.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meroapp.animaldetails.R;
import com.meroapp.animaldetails.model.Animals;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AnimalsViewAdapter extends RecyclerView.Adapter<AnimalsViewAdapter.AnimalsViewHolder> {

    Context mContext;
    List<Animals> animalsList;

    public AnimalsViewAdapter(Context mContext, List<Animals> animalsList) {
        this.mContext = mContext;
        this.animalsList = animalsList;
    }

    @NonNull
    @Override
    public AnimalsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_listitem,parent,false);
        return new AnimalsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalsViewHolder holder, int position) {

        Animals animals = animalsList.get(position);
        holder.imageAnimals.setImageResource(animals.getImageId());
        holder.textViewName.setText(animals.getName());
        holder.textViewGender.setText(animals.getGender());
        holder.textViewAge.setText(animals.getAge());

    }

    @Override
    public int getItemCount() {
        return animalsList.size();
    }

    public class AnimalsViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageAnimals;
        TextView textViewName, textViewGender, textViewAge;

        public AnimalsViewHolder(@NonNull View itemView) {
            super(itemView);

            imageAnimals = itemView.findViewById(R.id.imageAnimals);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewGender = itemView.findViewById(R.id.textViewGender);
            textViewAge = itemView.findViewById(R.id.textViewAge);
        }
    }


}


