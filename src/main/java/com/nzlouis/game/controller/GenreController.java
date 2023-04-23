package com.nzlouis.game.controller;

import com.nzlouis.game.model.Genre;
import com.nzlouis.game.repository.IGenreRepository;
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
@RequestMapping("/api/genre")
@Tag(name = "Genre")
@CrossOrigin("*")
public class GenreController {
	private static final Logger logger= LoggerFactory.getLogger(GenreController.class);

	@Autowired
	IGenreRepository genresRepository;

	@Operation(summary ="Creates a new genres.")
	@PostMapping
	public R<Genre> addGenres(@RequestBody Genre genres) {
		try {
			genresRepository.save(genres);
		} catch (Exception e) {
			logger.error("Creates a new genres fails:" + e.getMessage());
		}

		return new R<Genre>().success();
	}

	@Operation(summary ="Update an existing genres.")
	@PutMapping("")
	public R<Genre> updateGenres(@Parameter(description="Update an existing genres.")@RequestBody Genre genres) {
		try {
			genresRepository.save(genres);
		} catch (Exception e) {
			logger.error("Update an existing genres fails:" + e.getMessage());
		}

		return new R<Genre>().success();
	}

	@Operation(summary ="Retrieve an existing genres.")
	@GetMapping("/{id}")
	public R<Genre> findGenresById(@Parameter(description="A genres's id")@PathVariable String id) {
		Genre genres = null;
		try {
			genres = genresRepository.findById(Integer.valueOf(id)).orElse(new Genre());
		} catch (Exception e) {
			logger.error("Retrieve an existing genres fails:" + e.getMessage());
		}

		return new R<Genre>().success().data(genres);
	}


	@Operation(summary ="Delete an existing genres.")
	@DeleteMapping(value = "/{id}")
	public R<Genre> deleteGenres(@Parameter(description="Delete an existing genres.")@RequestParam(value = "id") final String id) {
		try {
			genresRepository.deleteById(Integer.valueOf(id));
		} catch (Exception e) {
			logger.error("Delete an existing genres fails:" + e.getMessage());
		}

		return new R<Genre>().success();
	}


	@Operation(summary ="Find the genres list")
	@GetMapping("")
	@ResponseBody
	public R<List<Genre>> findGenres() {
		List<Genre> genresList = null;
		try {
			genresList = genresRepository.findAll();

		} catch (Exception e) {
			logger.error("Find the genres list fails:" + e.getMessage());
		}

		return new R<List<Genre>>().success().data(genresList);
	}
	
}














