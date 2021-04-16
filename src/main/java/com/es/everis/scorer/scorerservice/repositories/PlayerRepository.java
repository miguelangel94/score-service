package com.es.everis.scorer.scorerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.es.everis.scorer.scorerservice.entities.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
