package com.example.tentative3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.io.*;
import java.lang.*;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;

import java.util.ArrayList;

import static com.example.tentative3.MainActivity.EXTRA_URL;
import static com.example.tentative3.MainActivity.EXTRA_NUM;
import static com.example.tentative3.MainActivity.EXTRA_NAME;
import static com.example.tentative3.MainActivity.EXTRA_TYPE;
import static com.example.tentative3.MainActivity.EXTRA_HEIGHT;
import static com.example.tentative3.MainActivity.EXTRA_WEIGHT;
import static com.example.tentative3.MainActivity.EXTRA_WEAKNESSES;


public class DetailActivity extends AppCompatActivity {

    public void printType(String typeList, LinearLayout gallery, LayoutInflater inflater, int layout, int id){
        if(typeList.contains("Bug")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typebug);

            gallery.addView(view);
        }
        if(typeList.contains("Dark")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typedark);

            gallery.addView(view);
        }
        if(typeList.contains("Dragon")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typedragon);

            gallery.addView(view);
        }
        if(typeList.contains("Electric")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typeelectric);

            gallery.addView(view);
        }
        if(typeList.contains("Fairy")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typefairy);

            gallery.addView(view);
        }
        if(typeList.contains("Fighting")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typefighting);

            gallery.addView(view);
        }
        if(typeList.contains("Fire")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typefire);

            gallery.addView(view);
        }
        if(typeList.contains("Flying")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typeflying);

            gallery.addView(view);
        }
        if(typeList.contains("Ghost")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typeghost);

            gallery.addView(view);
        }
        if(typeList.contains("Grass")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typegrass);

            gallery.addView(view);
        }
        if(typeList.contains("Ground")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typeground);

            gallery.addView(view);
        }
        if(typeList.contains("Ice")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typeice);

            gallery.addView(view);
        }
        if(typeList.contains("Normal")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typenormal);

            gallery.addView(view);
        }
        if(typeList.contains("Poison")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typepoison);

            gallery.addView(view);
        }
        if(typeList.contains("Psychic")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typepsychic);

            gallery.addView(view);
        }
        if(typeList.contains("Rock")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typerock);

            gallery.addView(view);
        }
        if(typeList.contains("Steel")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typesteel);

            gallery.addView(view);
        }
        if(typeList.contains("Water")==true){
            View view = inflater.inflate(layout,gallery,false);
            ImageView imageViewType = view.findViewById(id);
            imageViewType.setImageResource(R.drawable.typewater);

            gallery.addView(view);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String pokemonUrl = intent.getStringExtra(EXTRA_URL);
        String pokemonName = intent.getStringExtra(EXTRA_NAME);
        String pokemonNumero = intent.getStringExtra(EXTRA_NUM);
        String pokemonType = intent.getStringExtra(EXTRA_TYPE);
        String pokemonHeight = intent.getStringExtra(EXTRA_HEIGHT);
        String pokemonWeight = intent.getStringExtra(EXTRA_WEIGHT);
        String pokemonWeaknesses = intent.getStringExtra(EXTRA_WEAKNESSES);



        ImageView imageView = findViewById(R.id.imageViewDetail);
        TextView textViewName = findViewById(R.id.nameViewDetail);
        TextView textViewNum = findViewById(R.id.numViewDetail);
        TextView textViewHeight = findViewById(R.id.heightViewDetail);
        TextView textViewWeight = findViewById(R.id.weightViewDetail);

        LinearLayout gallery = findViewById(R.id.gallery);
        LayoutInflater inflater = LayoutInflater.from(this);

        LinearLayout gallery2 = findViewById(R.id.gallery2);
        LayoutInflater inflater2 = LayoutInflater.from(this);


        Picasso.get().load(pokemonUrl).into(imageView);
        textViewName.setText(pokemonName);
        textViewNum.setText("Number : #"+ pokemonNumero);
        printType(pokemonType, gallery, inflater, R.layout.listoftype, R.id.typeViewDetail);
        textViewHeight.setText("Height : " + pokemonHeight);
        textViewWeight.setText("Weight : " + pokemonWeight);
        printType(pokemonWeaknesses, gallery2,  inflater2, R.layout.listofweaknesses, R.id.weaknessesViewDetail);

    }
}
