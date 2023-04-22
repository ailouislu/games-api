package com.nzlouis.games.repositories;

import com.nzlouis.games.models.Genres;
import com.nzlouis.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 *  @author Louis
 *  Interface IUserRepository
 */
public interface IGenresRepository extends JpaRepository<Genres, Integer> {

}


