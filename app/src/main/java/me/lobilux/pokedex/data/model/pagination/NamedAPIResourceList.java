package me.lobilux.pokedex.data.model.pagination;

import java.util.ArrayList;

import lombok.Getter;
import lombok.ToString;

import me.lobilux.pokedex.data.model.common.NamedAPIResource;

@Getter
@ToString
public class NamedAPIResourceList {
    private int count;
    private String next;
    private String previous;
    private ArrayList<NamedAPIResource> results;
}
