package com.es.everis.scorer.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.es.everis.scorer.entities.Player;
import com.es.everis.scorer.exceptions.ScorerServiceException;
import com.es.everis.scorer.repositories.PlayerRepository;
import com.es.everis.scorer.rest.PlayerRest;
import com.es.everis.scorer.service.PlayerService;
import com.es.everis.scorer.utils.converters.PlayerConverter;

@Service
public class PlayerServiceImpl implements PlayerService {

  @Autowired
  PlayerRepository playerRepository;

  @Override
  public PlayerRest createPlayer(String name) throws ScorerServiceException {
    final Optional<Player> playerOptional = playerRepository.findByName(name);
    if (!playerOptional.isPresent()) {
      final Player player = playerRepository.save(Player.builder().name(name).build());
      return PlayerConverter.toRest(player);
    }
    return PlayerConverter.toRest(playerOptional.get());
  }

}
