package com.nzlouis.games.controllers;

import com.nzlouis.games.models.Genres;
import com.nzlouis.games.repositories.IGenresRepository;
import com.nzlouis.utils.response.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Louis
 *
 */
@RestController
@RequestMapping("/api/genres")
@Tag(name = "default")
@CrossOrigin("*")
public class GenresController {
	private static final Logger logger= LoggerFactory.getLogger(GenresController.class);

	@Autowired
	IGenresRepository genresRepository;

	@Operation(summary ="Creates a new genres.")
	@PostMapping
	public R<Genres> addGenres(@RequestBody Genres genres) {
		try {
			genresRepository.save(genres);
		} catch (Exception e) {
			logger.error("Creates a new genres fails:" + e.getMessage());
		}

		return new R<Genres>().success();
	}

	@Operation(summary ="Update an existing genres.")
	@PutMapping("")
	public R<Genres> updateGenres(@Parameter(description="Update an existing genres.")@RequestBody Genres genres) {
		try {
			genresRepository.save(genres);
		} catch (Exception e) {
			logger.error("Update an existing genres fails:" + e.getMessage());
		}

		return new R<Genres>().success();
	}

	@Operation(summary ="Retrieve an existing genres.")
	@GetMapping("/{id}")
	public R<Genres> findGenresById(@Parameter(description="A genres's id")@PathVariable String id) {
		Genres genres = null;
		try {
			genres = genresRepository.findById(Integer.valueOf(id)).orElse(new Genres());
		} catch (Exception e) {
			logger.error("Retrieve an existing genres fails:" + e.getMessage());
		}

		return new R<Genres>().success().data(genres);
	}


	@Operation(summary ="Delete an existing genres.")
	@DeleteMapping(value = "/{id}")
	public R<Genres> deleteGenres(@Parameter(description="Delete an existing genres.")@RequestParam(value = "id") final String id) {
		try {
			genresRepository.deleteById(Integer.valueOf(id));
		} catch (Exception e) {
			logger.error("Delete an existing genres fails:" + e.getMessage());
		}

		return new R<Genres>().success();
	}


	@Operation(summary ="Find the genres list")
	@GetMapping("")
	@ResponseBody
	public R<List<Genres>> findGenres() {
		List<Genres> genresList = null;
		try {
			genresList = genresRepository.findAll();

		} catch (Exception e) {
			logger.error("Find the genres list fails:" + e.getMessage());
		}

		return new R<List<Genres>>().success().data(genresList);
	}
	
}














