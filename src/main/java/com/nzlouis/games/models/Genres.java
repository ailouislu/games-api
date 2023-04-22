package com.nzlouis.games.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


/**
 * @author Louis
 */
@Entity
@Data
public class Genres {
    @Id
    private int id;
    private String name;
    private String slug;
    private int gamesCount;
    private String imageBackground;
    public Genres() {
    }
    public Genres(int id, String name, String slug, int gamesCount, String imageBackground) {
        super();
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.gamesCount = gamesCount;
        this.imageBackground = imageBackground;
    }
}
