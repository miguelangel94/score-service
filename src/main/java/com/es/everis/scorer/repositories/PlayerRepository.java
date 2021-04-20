package com.es.everis.scorer.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.es.everis.scorer.entities.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

  Optional<Player> findByName(String name);

}
