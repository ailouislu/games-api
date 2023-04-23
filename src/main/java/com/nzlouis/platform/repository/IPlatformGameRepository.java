package com.nzlouis.platform.repository;

import com.nzlouis.platform.model.PlatformGame;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 *  @author Louis
 *  Interface IPlatformGameRepository
 */
public interface IPlatformGameRepository extends JpaRepository<PlatformGame, Integer> {

}


