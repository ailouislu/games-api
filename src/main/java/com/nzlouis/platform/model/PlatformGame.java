package com.nzlouis.platform.model;

import com.nzlouis.game.model.Game;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Louis
 */
@Entity
@Data
public class PlatformGame {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    public PlatformGame() {
    }

    public PlatformGame(int id, Platform platform, Game game) {
        super();
        this.id = id;
        this.platform = platform;
        this.game = game;
    }
}