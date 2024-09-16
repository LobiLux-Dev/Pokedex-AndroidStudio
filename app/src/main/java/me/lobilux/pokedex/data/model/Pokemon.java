package me.lobilux.pokedex.data.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.ToString;

import me.lobilux.pokedex.data.model.common.NamedAPIResource;
import me.lobilux.pokedex.data.model.common.VersionGameIndex;

@Getter
@ToString
public class Pokemon {
    private ArrayList<PokemonAbility> abilities;
    private int base_experience;
    private PokemonCries cries;
    private ArrayList<NamedAPIResource> forms;
    private ArrayList<VersionGameIndex> game_indices;
    private int height;
    private int id;
    private boolean is_default;
    private String location_area_encounters;
    private ArrayList<PokemonMove> moves;
    private String name;
    private int order;
    private ArrayList<PokemonHeldItem> held_items;
    private ArrayList<PokemonTypePast> past_types;
    private NamedAPIResource species;
    private PokemonSprites sprites;
    private ArrayList<PokemonStat> stats;
    private ArrayList<PokemonType> types;
    private int weight;

    @Getter
    @ToString
    public static class PokemonAbility {
        private NamedAPIResource ability;
        private boolean is_hidden;
        private int slot;
    }

    @Getter
    @ToString
    public static class PokemonCries {
        private String latest;
        private String legacy;
    }

    @Getter
    @ToString
    public static class PokemonHeldItem {
        private NamedAPIResource item;
        private PokemonHeldItemVersion version_details;

        @Getter
        @ToString
        public static class PokemonHeldItemVersion {
            private int rarity;
            private NamedAPIResource version;
        }
    }

    @Getter
    @ToString
    public static class PokemonMove {
        private NamedAPIResource move;
        private ArrayList<PokemonMoveVersion> version_group_details;

        @Getter
        @ToString
        public static class PokemonMoveVersion {
            private int level_learned_at;
            private NamedAPIResource move_learn_method;
            private NamedAPIResource version_group;
        }
    }

    @Getter
    @ToString
    public static class PokemonSprites {
        private String back_default;
        private String back_female;
        private String back_shiny;
        private String back_shiny_female;
        private String front_default;
        private String front_female;
        private String front_shiny;
        private String front_shiny_female;
    }

    @Getter
    @ToString
    public static class PokemonStat {
        private int base_stat;
        private int effort;
        private NamedAPIResource stat;
    }

    @Getter
    @ToString
    public static class PokemonTypePast {
        private NamedAPIResource generation;
        private ArrayList<PokemonType> types;
    }

    @Getter
    @ToString
    public static class PokemonType {
        private int slot;
        private NamedAPIResource type;
    }
}
