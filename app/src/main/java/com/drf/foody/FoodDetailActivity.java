package com.drf.foody;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.drf.foody.Object.Food;

import static android.R.id.edit;

public class FoodDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(this.getResources().getColor(R.color.colorAccent));
        }

        final Food food = new Food();
        food.setName(getIntent().getStringExtra("FOOD_NAME"));
        food.setDescription(getIntent().getStringExtra("FOOD_DESCRIPTION"));
        food.setId(getIntent().getStringExtra("FOOD_ID"));
        food.setPrice(getIntent().getStringExtra("FOOD_PRICE"));
        food.setImage(getIntent().getStringExtra("FOOD_IMAGE"));
        food.setImageId(getIntent().getIntExtra("FOOD_IMAGE_ID", 0));

        setTitle(food.getName());

        setContentView(R.layout.activity_food_detail);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView foodName = (TextView) findViewById(R.id.foodName);
        TextView foodDescription = (TextView) findViewById(R.id.foodDescription);
        TextView foodPrice = (TextView) findViewById(R.id.foodPrice);
        ImageView foodImage = (ImageView) findViewById(R.id.foodImage);
        TextView foodId = (TextView) findViewById(R.id.foodId);

        Button shop = (Button) findViewById(R.id.shopButton);

        foodDescription.setText(food.getDescription());
        foodName.setText(food.getName());
        foodId.setText(food.getId());
        foodImage.setImageResource(food.getImageId());
        foodPrice.setText(food.getPrice());

        final FoodDetailActivity copy = this;

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Ion.with(v.getContext()).load("PUT", getString(R.string.main_api_url) + "/book/updateNote?book_id=" + food.getStudentId() + "&note_id=" + food.getId())
                        .setHeader("School", schoolId).setHeader("Authentification", authId)
                        .setBodyParameter("title", food.getName()).setBodyParameter("comment", food.getComment())
                        .setBodyParameter("value", markValue.getText().toString()).setBodyParameter("coefficient", food.getCoefficient())
                        .asString().setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {

                        System.out.println(result);
                        copy.finish();
                    }
                });
                */
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;


        }

        return super.onOptionsItemSelected(item);
    }
}
