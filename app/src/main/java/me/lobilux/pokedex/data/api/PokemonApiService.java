package me.lobilux.pokedex.data.api;

import me.lobilux.pokedex.data.model.Pokemon;
import me.lobilux.pokedex.data.model.PokemonList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokemonApiService {
    @GET("pokemon")
    Call<PokemonList> getPokemonList(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{name}")
    Call<Pokemon> getPokemon(@Path("name") String name);
}
