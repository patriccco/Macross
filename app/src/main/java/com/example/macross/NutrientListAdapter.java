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

public class NutrientListAdapter extends RecyclerView.Adapter<NutrientListAdapter.ViewHolder> {

    private ArrayList<Nutrient> nutrients;
    private TextView nutrientName, nutrientValue, dailyValue;
    private long currItem;
    Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        public TextView nutrientName;
        public TextView nutrientValue;
        public TextView dailyValue;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            nutrientName = v.findViewById(R.id.nutrientName);
            nutrientValue = v.findViewById(R.id.nutrientValue);
            dailyValue = v.findViewById(R.id.dailyValue);
        }
    }

    NutrientListAdapter(ArrayList<Nutrient> nutrients, TextView nutrientName, TextView nutrientValue,
                        TextView dailyValue) {
        this.nutrients = nutrients;
        this.nutrientName = nutrientName;
        this.nutrientValue = nutrientValue;
        this.dailyValue = dailyValue;
    }

    public void add(int position, Nutrient nutrient) {
        nutrients.add(position, nutrient);
        notifyItemInserted(position);
    }

    public Nutrient getNutrient(int position) {return nutrients.get(position); }

    // Create new views (invoked by the layout manager)
    @Override
    public NutrientListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.nutrient_row_layout, parent, false);
        //ViewHolder vh = new ViewHolder(v);
        //return vh;
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from data set at this position
        // - replace the contents of the view with that element

        final Nutrient nutrient = getNutrient(position);
        holder.nutrientName.setText(nutrient.name);
        holder.nutrientValue.setText(String.valueOf(nutrient.value));
        holder.dailyValue.setText(nutrient.dailyValue);
    }

    // Return the size of data set (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return nutrients.size();
    }


}
