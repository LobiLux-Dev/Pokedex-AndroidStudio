package me.lobilux.pokedex.repository;

import me.lobilux.pokedex.data.api.PokemonApiClient;
import me.lobilux.pokedex.data.api.PokemonApiService;
import me.lobilux.pokedex.data.model.PokemonIndexCollection;

import retrofit2.Call;
import retrofit2.Callback;

public class PokemonRepository {
    private final PokemonApiService apiService;

    public PokemonRepository() {
        apiService = PokemonApiClient.getClient().create(PokemonApiService.class);
    }

    public void getPokemonIndexCollection(int limit, int offset, Callback<PokemonIndexCollection> callback) {
        Call<PokemonIndexCollection> call = apiService.getPokemonIndexCollection(limit, offset);
        call.enqueue(callback);
    }
}
