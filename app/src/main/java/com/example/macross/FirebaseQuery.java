package com.example.macross;

import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class FirebaseQuery {

    FirebaseAuth auth = FirebaseAuth.getInstance();
    public FirebaseDatabase database = FirebaseDatabase.getInstance();

    private ArrayList<Food> foods = new ArrayList<>();



    public void getFoods() {
        DatabaseReference foodRef = database.getReference("Player");
        foodRef.child("User").child(auth.getUid()).child("Items").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Food food = new Food();
                    food.name = (String) snapshot.child("name").getValue();
                    foods.add(food);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }


    public void getDailyValues() {
        DatabaseReference dailyRef = database.getReference("DailyValues");
        dailyRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    DailyValues dv = new DailyValues();
                    dv.calories = (String) snapshot.child("calories").getValue();
                    dv.protein = (String) snapshot.child("protein").getValue();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    public void compareValues() {

    }




}
