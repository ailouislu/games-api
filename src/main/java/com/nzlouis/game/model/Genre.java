package com.nzlouis.game.model;

import lombok.Data;

import javax.persistence.*;


/**
 * @author Louis
 */
@Entity
@Data
public class Genre {
    @Id
    private int id;
    private String name;
    private String slug;
    private int gamesCount;
    private String imageBackground;
    public Genre() {
    }
    public Genre(int id, String name, String slug, int gamesCount, String imageBackground) {
        super();
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.gamesCount = gamesCount;
        this.imageBackground = imageBackground;
    }
}
