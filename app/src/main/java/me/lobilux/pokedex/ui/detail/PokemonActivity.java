package me.lobilux.pokedex.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import me.lobilux.pokedex.R;
import me.lobilux.pokedex.data.model.Pokemon;

public class PokemonActivity extends AppCompatActivity {
    private TextView height;
    private TextView id;
    private ImageView image;
    private TextView name;
    private TextView weight;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        Intent intent = getIntent();
        String pokemonJson = intent.getStringExtra("pokemonJson");

        Gson gson = new Gson();
        Pokemon pokemon = gson.fromJson(pokemonJson, Pokemon.class);

        String pokemonHeight = ((float) pokemon.getHeight() / 100) + "m";
        String pokemonId = "#" + pokemon.getId();
        String pokemonName = pokemon.getName().substring(0, 1).toUpperCase() + pokemon.getName().substring(1);
        String pokemonWeight = ((float) pokemon.getWeight() / 100) + "m";

        height = findViewById(R.id.height);
        id = findViewById(R.id.id);
        image = findViewById(R.id.image);
        name = findViewById(R.id.name);
        weight = findViewById(R.id.weight);

        height.setText(pokemonHeight);
        id.setText(pokemonId);
        Glide.with(this).load(pokemon.getSprites().getFront_default()).placeholder(R.drawable.placeholder_image).error(R.drawable.error_placeholder).into(image);
        name.setText(pokemonName);
        weight.setText(pokemonWeight);
    }
}
