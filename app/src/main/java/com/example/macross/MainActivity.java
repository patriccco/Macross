package com.example.macross;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //open food list
    public void foodList(View view) {
        Intent foodList = new Intent(this, FoodListActivity.class);
        startActivity(foodList);
        finish();
    }


}
