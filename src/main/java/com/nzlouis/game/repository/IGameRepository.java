package com.nzlouis.game.repository;

import com.nzlouis.game.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 *  @author Louis
 *  Interface IGamesRepository
 */
public interface IGameRepository extends JpaRepository<Game, Integer> {

}


