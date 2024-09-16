package me.lobilux.pokedex.repository;

import me.lobilux.pokedex.data.api.PokemonApiClient;
import me.lobilux.pokedex.data.api.PokemonApiService;
import me.lobilux.pokedex.data.model.Pokemon;
import me.lobilux.pokedex.data.model.PokemonList;

import retrofit2.Call;
import retrofit2.Callback;

public class PokemonRepository {
    private final PokemonApiService apiService;

    public PokemonRepository() {
        apiService = PokemonApiClient.getClient().create(PokemonApiService.class);
    }

    public void getPokemonList(int limit, int offset, Callback<PokemonList> callback) {
        Call<PokemonList> call = apiService.getPokemonList(limit, offset);
        call.enqueue(callback);
    }

    public void getPokemon(String name, Callback<Pokemon> callback) {
        Call<Pokemon> call = apiService.getPokemon(name);
        call.enqueue(callback);
    }
}
