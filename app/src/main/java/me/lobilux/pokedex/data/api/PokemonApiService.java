package me.lobilux.pokedex.data.api;

import me.lobilux.pokedex.data.model.PokemonIndexCollection;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonApiService {
    @GET
    Call<PokemonIndexCollection> getPokemonIndexCollection(@Query("limit") int limit, @Query("offset") int offset);
}
