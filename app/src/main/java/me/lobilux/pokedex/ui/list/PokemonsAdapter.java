package me.lobilux.pokedex.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import me.lobilux.pokedex.R;
import me.lobilux.pokedex.data.model.Pokemon;

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

        holder.name.setText(new StringBuilder(pokemon.getName().substring(0, 1).toUpperCase() + pokemon.getName().substring(1)));
        holder.id.setText(new StringBuilder("#" + pokemon.getId()));

        Glide.with(holder.itemView.getContext()).load(pokemon.getSprites().getFront_default()).placeholder(R.drawable.placeholder_image).error(R.drawable.error_placeholder).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public static class PokemonsViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        ImageView image;
        TextView name;

        public PokemonsViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
        }
    }
}
