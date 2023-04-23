package com.nzlouis.game.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Louis
 */
@Entity
@Data
public class Game {
    @Id
    private int id;
    private String slug;
    private String name;
    private int added;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    public Game() {
    }
    public Game(int id, String slug, String name, int added, Genre genre) {
        super();
        this.id = id;
        this.slug = slug;
        this.name = name;
        this.added = added;
        this.genre = genre;
    }
}