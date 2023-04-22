package com.nzlouis.games.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


/**
 * @author Louis
 */
@Entity
@Getter
@Setter
@Table(name = "Genres")
public class Genres {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "slug")
    private String slug;
    @Column(name = "games_count")
    private int gamesCount;
    @Column(name = "image_background")
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
