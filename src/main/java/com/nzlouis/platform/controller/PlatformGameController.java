package com.nzlouis.platform.controller;

import com.nzlouis.platform.model.PlatformGame;
import com.nzlouis.platform.repository.IPlatformGameRepository;
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
@RequestMapping("/api/platformGames")
@Tag(name = "PlatformGames")
@CrossOrigin("*")
public class PlatformGameController {
    private static final Logger logger= LoggerFactory.getLogger(PlatformGameController.class);

    @Autowired
    IPlatformGameRepository platformGameRepository;

    @Operation(summary ="Creates a new platform game.")
    @PostMapping
    public R<PlatformGame> addPlatformGame(@RequestBody PlatformGame platformGame) {
        try {
            platformGameRepository.save(platformGame);
        } catch (Exception e) {
            logger.error("Creates a new platform game fails:" + e.getMessage());
        }

        return new R<PlatformGame>().success();
    }

    @Operation(summary ="Update an existing platform game.")
    @PutMapping("")
    public R<PlatformGame> updatePlatformGame(@Parameter(description="Update an existing platform game.")@RequestBody PlatformGame platformGame) {
        try {
            platformGameRepository.save(platformGame);
        } catch (Exception e) {
            logger.error("Update an existing platform game fails:" + e.getMessage());
        }

        return new R<PlatformGame>().success();
    }

    @Operation(summary ="Retrieve an existing platform game.")
    @GetMapping("/{id}")
    public R<PlatformGame> findPlatformGameById(@Parameter(description="A platform game's id")@PathVariable String id) {
        PlatformGame platformGame = null;
        try {
            platformGame = platformGameRepository.findById(Integer.valueOf(id)).orElse(new PlatformGame());
        } catch (Exception e) {
            logger.error("Retrieve an existing platform game fails:" + e.getMessage());
        }

        return new R<PlatformGame>().success().data(platformGame);
    }


    @Operation(summary ="Delete an existing platform game.")
    @DeleteMapping(value = "/{id}")
    public R<PlatformGame> deletePlatformGame(@Parameter(description="Delete an existing platform game.")@RequestParam(value = "id") final String id) {
        try {
            platformGameRepository.deleteById(Integer.valueOf(id));
        } catch (Exception e) {
            logger.error("Delete an existing platform game fails:" + e.getMessage());
        }

        return new R<PlatformGame>().success();
    }


    @Operation(summary ="Find the platform game list")
    @GetMapping("")
    @ResponseBody
    public R<List<PlatformGame>> findPlatformGames() {
        List<PlatformGame> platformGameList = null;
        try {
            platformGameList = platformGameRepository.findAll();

        } catch (Exception e) {
            logger.error("Find the platform game list fails:" + e.getMessage());
        }

        return new R<List<PlatformGame>>().success().data(platformGameList);
    }

}