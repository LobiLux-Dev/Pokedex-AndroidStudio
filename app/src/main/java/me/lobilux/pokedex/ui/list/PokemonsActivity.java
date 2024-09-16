package me.lobilux.pokedex.ui.list;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import me.lobilux.pokedex.R;
import me.lobilux.pokedex.data.model.PokemonList;
import me.lobilux.pokedex.repository.PokemonRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PokemonsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PokemonRepository pokemonRepository = new PokemonRepository();

        pokemonRepository.getPokemonList(9999, 0, new Callback<PokemonList>() {
            @Override
            public void onResponse(Call<PokemonList> call, Response<PokemonList> response) {
                if (response.isSuccessful()) {
                    PokemonList pokemonPagination = response.body();

                    if (pokemonPagination != null) {
                        adapter = new PokemonsAdapter(pokemonPagination.getResults());
                        recyclerView.setAdapter(adapter);
                    }
                }
//                TODO: Implement logic for unsatisfactory response
//                else {
//
//                }
            }

            @Override
            public void onFailure(Call<PokemonList> call, Throwable throwable) {
//               TODO: Implement api failure logic
            }
        });
    }
}
