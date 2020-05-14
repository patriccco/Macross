package com.example.macross;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {


    private ArrayList<Food> foods;
    private int resId;
    private TextView info;
    private ImageView img;
    private long currItem;
    Context context;


    public class ViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        public TextView name;
        public TextView info;
        public ImageView img;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            name = v.findViewById(R.id.foodName);
            info = v.findViewById(R.id.info);
            img = v.findViewById(R.id.foodPic);
        }
    }

    FoodAdapter(ArrayList<Food> foods, int resId, TextView info, ImageView img) {
        this.foods = foods;
        this.resId = resId;
        this.info = info;
        this.img = img;
    }

    public void add(int position, Food food) {
        foods.add(position, food);
        notifyItemInserted(position);
    }

    public Food getFood(int position) {return foods.get(position); }



    // Create new views (invoked by the layout manager)
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.food_row_layout, parent, false);
        //ViewHolder vh = new ViewHolder(v);
        //return vh;
        return new ViewHolder(v);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from data set at this position
        // - replace the contents of the view with that element

        final Food food = getFood(position);
        holder.name.setText(food.name);
        holder.info.setText(String.valueOf(food.info));
        holder.img.setImageResource(food.resId);
        holder.layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(food.resId);
                info.setText(food.info);

                // gets the recycler position
                currItem = holder.getAdapterPosition();

                // intent passes the value of currItem to the activities
                Intent intent = new Intent("pass-food");
                intent.putExtra("food",currItem);
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            }
        });
    }

    // Return the size of data set (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return foods.size();
    }

}
