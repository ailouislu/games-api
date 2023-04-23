package com.nzlouis.platform.controller;

import com.nzlouis.platform.model.Platform;
import com.nzlouis.platform.repository.IPlatformRepository;
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
@RequestMapping("/api/platform")
@Tag(name = "Platform")
@CrossOrigin("*")
public class PlatformController {
    private static final Logger logger= LoggerFactory.getLogger(PlatformController.class);

    @Autowired
    IPlatformRepository platformRepository;

    @Operation(summary ="Creates a new platform.")
    @PostMapping
    public R<Platform> addPlatform(@RequestBody Platform platform) {
        try {
            platformRepository.save(platform);
        } catch (Exception e) {
            logger.error("Creates a new platform fails:" + e.getMessage());
        }

        return new R<Platform>().success();
    }

    @Operation(summary ="Update an existing platform.")
    @PutMapping("")
    public R<Platform> updatePlatform(@Parameter(description="Update an existing platform.")@RequestBody Platform platform) {
        try {
            platformRepository.save(platform);
        } catch (Exception e) {
            logger.error("Update an existing platform fails:" + e.getMessage());
        }

        return new R<Platform>().success();
    }

    @Operation(summary ="Retrieve an existing platform.")
    @GetMapping("/{id}")
    public R<Platform> findPlatformById(@Parameter(description="A platform's id")@PathVariable String id) {
        Platform platform = null;
        try {
            platform = platformRepository.findById(Integer.valueOf(id)).orElse(new Platform());
        } catch (Exception e) {
            logger.error("Retrieve an existing platform fails:" + e.getMessage());
        }

        return new R<Platform>().success().data(platform);
    }


    @Operation(summary ="Delete an existing platform.")
    @DeleteMapping(value = "/{id}")
    public R<Platform> deletePlatform(@Parameter(description="Delete an existing platform.")@RequestParam(value = "id") final String id) {
        try {
            platformRepository.deleteById(Integer.valueOf(id));
        } catch (Exception e) {
            logger.error("Delete an existing platform fails:" + e.getMessage());
        }

        return new R<Platform>().success();
    }


    @Operation(summary ="Find the platform list")
    @GetMapping("")
    @ResponseBody
    public R<List<Platform>> findPlatforms() {
        List<Platform> platformList = null;
        try {
            platformList = platformRepository.findAll();

        } catch (Exception e) {
            logger.error("Find the platform list fails:" + e.getMessage());
        }

        return new R<List<Platform>>().success().data(platformList);
    }

}