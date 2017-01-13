package com.drf.foody;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



import com.drf.foody.Adapter.FoodAdapter;
import com.drf.foody.Object.Food;
import com.drf.foody.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;



public class FoodListActivity extends AppCompatActivity {



    private RecyclerView mRecyclerView;
    private FoodAdapter mAdapter;
    private ArrayList<Food> foodData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(this.getResources().getColor(R.color.colorAccent));
        }

        setTitle(R.string.app_name);


        setContentView(R.layout.activity_food_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.FoodRecyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        /*
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        */


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("Info");
        menu.add("Quit");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getTitle() == "Info") {

            // Can redirect to an info activity



        }
        else if (item.getTitle() == "Quit") {

            this.finish();

        }
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;


        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        getFood();
    }

    public void getFood() {

        foodData.clear();

        Food banana = new Food();
        banana.setId("0");
        banana.setName("Banana");
        banana.setDescription("A delicious yellow fruit.");
        banana.setPrice("1€");

        banana.setImage("banana");
        setImageIds(banana);

        foodData.add(banana);
        System.out.println("Added banana");

        Food pizza = new Food();
        pizza.setId("1");
        pizza.setName("Pizza");
        pizza.setDescription("Mmmh, pizza...");
        pizza.setPrice("3€");

        pizza.setImage("pizza");
        setImageIds(pizza);

        foodData.add(pizza);
        System.out.println("Added pizza");

        Food tomato = new Food();
        tomato.setId("2");
        tomato.setName("Tomato");
        tomato.setDescription("Some says it's a vegetable, some others says it's a fruit. Let's say it's both !");
        tomato.setPrice("0,50€");

        tomato.setImage("tomato");
        setImageIds(tomato);

        foodData.add(tomato);
        System.out.println("Added tomato");

        Food orange = new Food();
        orange.setId("3");
        orange.setName("Orange");
        orange.setDescription("A delicious orange fruit.");
        orange.setPrice("1€");

        orange.setImage("orange");
        setImageIds(orange);

        foodData.add(orange);
        System.out.println("Added orange");


        Food nutella = new Food();
        nutella.setId("4");
        nutella.setName("Nutella");
        nutella.setDescription("What would the world be like without Nutella?");
        nutella.setPrice("4€");

        nutella.setImage("nutella");
        setImageIds(nutella);

        foodData.add(nutella);
        System.out.println("Added nutella");

        Food potato = new Food();
        potato.setId("5");
        potato.setName("Potato");
        potato.setDescription("The most awesome vegetable... Even if it's not even a vegetable.");
        potato.setPrice("0,50€");

        potato.setImage("potato");
        setImageIds(potato);

        foodData.add(potato);
        System.out.println("Added potato");

        FoodAdapter mAdapter = new FoodAdapter(foodData);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void setImageIds(Food food) {
        String mDrawableName = food.getImage() + "_little";
        food.setLittleImageId(getResources().getIdentifier(mDrawableName , "drawable", getPackageName()));
        food.setImageId(getResources().getIdentifier(food.getImage() , "drawable", getPackageName()));
    }
}