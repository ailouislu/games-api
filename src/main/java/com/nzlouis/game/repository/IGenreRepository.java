package com.nzlouis.game.repository;

import com.nzlouis.game.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 *  @author Louis
 *  Interface IGenresRepository
 */
public interface IGenreRepository extends JpaRepository<Genre, Integer> {

}


