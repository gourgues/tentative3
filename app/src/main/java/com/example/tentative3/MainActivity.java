package com.example.tentative3;

import android.app.ProgressDialog;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;

import javax.crypto.NullCipher;


public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener{
    public static final String EXTRA_URL = "pokemonImage";
    public static final String EXTRA_NAME = "pokemonName";
    public static final String EXTRA_NUM = "pokemonNumero";
    public static final String EXTRA_TYPE = "pokemonType";
    public static final String EXTRA_HEIGHT = "pokemonHeight";
    public static final String EXTRA_WEIGHT = "pokemonWeight";
    public static final String EXTRA_WEAKNESSES = "pokemonWeaknesses";



    private static final String URL_DATA = "https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/pokedex.json";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private MyAdapter mAdapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        listItems = new ArrayList<>();

        loadRecyclerViewData();
    }

    public static String remover(String oldString) {
       String newString = oldString.replace(',','-');
       newString = newString.replace('"',' ');
       newString = newString.replace("[","");
       newString = newString.replace("]","");
       newString = newString.replace("(Male)","");
       newString = newString.replace("(Female)","");

        return newString;
    }

    private void loadRecyclerViewData(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading data ...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s){
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("pokemon");

                            for(int i = 0; i<array.length(); i++){
                                JSONObject o = array.getJSONObject(i);
                               /** ListItem item = new ListItem(
                                        o.getString("name"),
                                        o.getString("num"),
                                        o.getString("img")
                                );
                                listItems.add(item);*/
                               String pokemonName = o.getString("name");
                               String pokemonNumero = o.getString("num");
                               String pokemonImage = o.getString("img");
                               String pokemonType = o.getString("type");
                               String pokemonHeight = o.getString("height");
                               String pokemonWeight = o.getString("weight");
                               String pokemonWeaknesses = o.getString("weaknesses");

                               pokemonType = remover(pokemonType);
                               pokemonWeaknesses = remover(pokemonWeaknesses);
                               pokemonName = remover(pokemonName);

                               //String[] pokemonType2 = toStringArray(pokemonType);

                               listItems.add(new ListItem(pokemonName, pokemonNumero, pokemonImage, pokemonType, pokemonHeight, pokemonWeight, pokemonWeaknesses));
                            }

                           // adapter = new MyAdapter(listItems, getApplicationContext());
                           // recyclerView.setAdapter(adapter);

                            mAdapter = new MyAdapter(listItems, MainActivity.this);
                            recyclerView.setAdapter(mAdapter);
                            mAdapter.setOnItemClickListener(MainActivity.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        ListItem clickedItem = listItems.get(position);

        detailIntent.putExtra(EXTRA_URL, clickedItem.getImageUrl());
        detailIntent.putExtra(EXTRA_NAME, clickedItem.getHead());
        detailIntent.putExtra(EXTRA_NUM, clickedItem.getDesc());
        detailIntent.putExtra(EXTRA_TYPE, clickedItem.getType());
        detailIntent.putExtra(EXTRA_HEIGHT, clickedItem.getHeight());
        detailIntent.putExtra(EXTRA_WEIGHT, clickedItem.getWeight());
        detailIntent.putExtra(EXTRA_WEAKNESSES, clickedItem.getWeaknesses());

        startActivity(detailIntent);
    }
}
