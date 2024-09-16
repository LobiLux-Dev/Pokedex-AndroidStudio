package me.lobilux.pokedex.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import me.lobilux.pokedex.R;
import me.lobilux.pokedex.ui.list.PokemonsActivity;

public class PokedexActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        Button buttonPokemons = findViewById(R.id.button_pokemons);

        buttonPokemons.setOnClickListener(view -> {
            Intent intent = new Intent(PokedexActivity.this, PokemonsActivity.class);
            startActivity(intent);
        });
    }
}
