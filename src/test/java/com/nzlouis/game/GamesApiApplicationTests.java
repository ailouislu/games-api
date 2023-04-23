package com.nzlouis.game;

import com.nzlouis.game.controller.GenreController;
import com.nzlouis.game.model.Genre;
import com.nzlouis.game.repository.IGenreRepository;
import com.nzlouis.utils.response.R;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
class GenreControllerTest {
    @Mock
    private IGenreRepository genresRepository;
    @InjectMocks
    private GenreController genresController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void testAddGenres() {
        // Arrange
        Genre genres = new Genre();
        R<Genre> expectedResult = new R<Genre>().success();
        doNothing().when(genresRepository).save(genres);
        // Act
        R<Genre> actualResult = genresController.addGenres(genres);
        // Assert
        verify(genresRepository, times(1)).save(genres);
        assertNotNull(actualResult);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void testUpdateGenres() {
        // Arrange
        Genre genres = new Genre();
        R<Genre> expectedResult = new R<Genre>().success();
        doNothing().when(genresRepository).save(genres);
        // Act
        R<Genre> actualResult = genresController.updateGenres(genres);
        // Assert
        verify(genresRepository, times(1)).save(genres);
        assertNotNull(actualResult);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void testFindGenresById() {
        // Arrange
        int id = 1;
        Genre genres = new Genre();
        genres.setId(id);
        R<Genre> expectedResult = new R<Genre>().success().data(genres);
        when(genresRepository.findById(anyInt())).thenReturn(Optional.ofNullable(genres));
        // Act
        R<Genre> actualResult = genresController.findGenresById(String.valueOf(id));
        // Assert
        verify(genresRepository, times(1)).findById(id);
        assertNotNull(actualResult);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void testDeleteGenres() {
        // Arrange
        int id = 1;
        R<Genre> expectedResult = new R<Genre>().success();
        doNothing().when(genresRepository).deleteById(id);
        // Act
        R<Genre> actualResult = genresController.deleteGenres(String.valueOf(id));
        // Assert
        verify(genresRepository, times(1)).deleteById(id);
        assertNotNull(actualResult);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void testFindGenres() {
        // Arrange
        List<Genre> genresList = new ArrayList<>();
        genresList.add(new Genre(1, "Action", "action", 100, "action_background.jpg"));
        genresList.add(new Genre(2, "Adventure", "adventure", 50, "adventure_background.jpg"));
        genresList.add(new Genre(3, "RPG", "rpg", 75, "rpg_background.jpg"));
        genresList.add(new Genre(4, "Simulation", "simulation", 40, "simulation_background.jpg"));
        R<List<Genre>> expectedResult = new R<List<Genre>>().success().data(genresList);
        when(genresRepository.findAll()).thenReturn(genresList);
        // Act
        R<List<Genre>> actualResult = genresController.findGenres();
        // Assert
        verify(genresRepository, times(1)).findAll();
        assertNotNull(actualResult);
        assertEquals(expectedResult, actualResult);
    }
}