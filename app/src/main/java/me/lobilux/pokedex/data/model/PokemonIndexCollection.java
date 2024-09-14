package me.lobilux.pokedex.data.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class PokemonIndexCollection {
    private int count;
    private Object next;
    private Object previous;
    private ArrayList<Result> results;

    public int getCount() {
        return count;
    }

    public Object getNext() {
        return next;
    }

    public Object getPrevious() {
        return previous;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    @NonNull
    @Override
    public String toString() {
        return "PokemonIndexCollection { " + "count: " + count + ", next: " + next + ", previous: " + previous + ", results: " + results + " }";
    }

    public static class Result {
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }

        @NonNull
        @Override
        public String toString() {
            return "Result { " + "name: '" + name + '\'' + ", url: '" + url + '\'' + " }";
        }
    }
}
