package me.lobilux.pokedex.data.model.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VersionGameIndex {
    private int game_index;
    private NamedAPIResource version;
}
