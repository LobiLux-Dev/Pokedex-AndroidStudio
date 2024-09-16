package me.lobilux.pokedex.ui.list;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;

import me.lobilux.pokedex.R;
import me.lobilux.pokedex.data.model.Pokemon;
import me.lobilux.pokedex.ui.detail.PokemonActivity;

public class PokemonsAdapter extends RecyclerView.Adapter<PokemonsAdapter.PokemonsViewHolder> {
    private final ArrayList<Pokemon> pokemonList;

    public PokemonsAdapter(ArrayList<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public PokemonsAdapter.PokemonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);

        return new PokemonsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonsAdapter.PokemonsViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);

        String name = pokemon.getName().substring(0, 1).toUpperCase() + pokemon.getName().substring(1);

        holder.name.setText(name);
        holder.id.setText(new StringBuilder("#" + pokemon.getId()));
        holder.image.setContentDescription(new StringBuilder(name + " image"));

        Glide.with(holder.itemView.getContext()).load(pokemon.getSprites().getFront_default()).placeholder(R.drawable.placeholder_image).error(R.drawable.error_placeholder).into(holder.image);

        holder.itemPokemon.setOnClickListener(view -> {
            Context context = view.getContext();
            Intent intent = new Intent(context, PokemonActivity.class);

            Gson gson = new Gson();
            String pokemonJson = gson.toJson(pokemon);

            intent.putExtra("pokemonJson", pokemonJson);

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public static class PokemonsViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        ImageView image;
        ConstraintLayout itemPokemon;
        TextView name;

        public PokemonsViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            image = itemView.findViewById(R.id.image);
            itemPokemon = itemView.findViewById(R.id.itemPokemon);
            name = itemView.findViewById(R.id.name);
        }
    }
}
