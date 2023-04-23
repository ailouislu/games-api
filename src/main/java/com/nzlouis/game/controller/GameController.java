package com.nzlouis.game.controller;

import com.nzlouis.game.model.Game;
import com.nzlouis.game.repository.IGameRepository;
import com.nzlouis.utils.response.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@Tag(name = "Game")
@CrossOrigin("*")
public class GameController {
    private static final Logger logger= LoggerFactory.getLogger(GameController.class);

    @Autowired
    IGameRepository gamesRepository;

    @Operation(summary ="Creates a new game.")
    @PostMapping
    public R<Game> addGame(@RequestBody Game game) {
        try {
            gamesRepository.save(game);
        } catch (Exception e) {
            logger.error("Creates a new game fails:" + e.getMessage());
        }

        return new R<Game>().success();
    }

    @Operation(summary ="Update an existing game.")
    @PutMapping("")
    public R<Game> updateGame(@Parameter(description="Update an existing game.")@RequestBody Game game) {
        try {
            gamesRepository.save(game);
        } catch (Exception e) {
            logger.error("Update an existing game fails:" + e.getMessage());
        }

        return new R<Game>().success();
    }

    @Operation(summary ="Retrieve an existing game.")
    @GetMapping("/{id}")
    public R<Game> findGameById(@Parameter(description="A game's id")@PathVariable String id) {
        Game game = null;
        try {
            game = gamesRepository.findById(Integer.valueOf(id)).orElse(new Game());
        } catch (Exception e) {
            logger.error("Retrieve an existing game fails:" + e.getMessage());
        }

        return new R<Game>().success().data(game);
    }


    @Operation(summary ="Delete an existing game.")
    @DeleteMapping(value = "/{id}")
    public R<Game> deleteGame(@Parameter(description="Delete an existing game.")@RequestParam(value = "id") final String id) {
        try {
            gamesRepository.deleteById(Integer.valueOf(id));
        } catch (Exception e) {
            logger.error("Delete an existing game fails:" + e.getMessage());
        }

        return new R<Game>().success();
    }


    @Operation(summary ="Find the game list")
    @GetMapping("")
    @ResponseBody
    public R<List<Game>> findGames() {
        List<Game> gameList = null;
        try {
            gameList = gamesRepository.findAll();

        } catch (Exception e) {
            logger.error("Find the game list fails:" + e.getMessage());
        }

        return new R<List<Game>>().success().data(gameList);
    }

}