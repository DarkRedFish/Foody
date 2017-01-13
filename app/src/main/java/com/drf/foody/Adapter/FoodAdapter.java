package com.drf.foody.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.drf.foody.FoodDetailActivity;
import com.drf.foody.Object.Food;
import com.drf.foody.R;

import java.util.ArrayList;


/**
 * Created by Jonathan on 14/06/15.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private ArrayList<Food> mDataset;


    public FoodAdapter(ArrayList<Food> data) {
        mDataset = data;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v;

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;

        //return null;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final Food food = mDataset.get(position);

        holder.name.setText(food.getName());
        holder.description.setText(food.getDescription());
        holder.price.setText(food.getPrice());


        holder.image.setImageResource(food.getLittleImageId());
        //holder.image.setText(food.getImage());
        holder.id.setText(food.getId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FoodDetailActivity.class);
                intent.putExtra("FOOD_IMAGE", food.getImage());
                intent.putExtra("FOOD_IMAGE_ID", food.getImageId());
                intent.putExtra("FOOD_NAME", food.getName());
                intent.putExtra("FOOD_ID", food.getId());
                intent.putExtra("FOOD_DESCRIPTION", food.getDescription());
                intent.putExtra("FOOD_PRICE", food.getPrice());

                v.getContext().startActivity(intent);
            }
        });
    }




    public void add(int position, Food item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(Food item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

   // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView        name;
        public TextView        description;
        public TextView        price;
        public ImageView        image;
        public TextView        id;

        public ViewHolder(View v) {
            super(v);

            name       = (TextView) v.findViewById(R.id.name);
            description       = (TextView) v.findViewById(R.id.description);
            price       = (TextView) v.findViewById(R.id.price);

            image       = (ImageView) v.findViewById(R.id.image);
            id       = (TextView) v.findViewById(R.id.id);
        }
    }
}
