package me.lobilux.pokedex.ui.list;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import me.lobilux.pokedex.R;
import me.lobilux.pokedex.data.model.common.NamedAPIResource;

public class PokemonsAdapter extends RecyclerView.Adapter<PokemonsAdapter.PokemonsViewHolder> {
    private ArrayList<NamedAPIResource> pokemonList;

    public PokemonsAdapter(ArrayList<NamedAPIResource> pokemonList) {
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
        NamedAPIResource pokemon = pokemonList.get(position);
        holder.name.setText(pokemon.getName());
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public static class PokemonsViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public PokemonsViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
