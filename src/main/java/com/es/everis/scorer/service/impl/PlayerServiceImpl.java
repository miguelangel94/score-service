package com.es.everis.scorer.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.es.everis.scorer.entities.Player;
import com.es.everis.scorer.exceptions.NotFoundException;
import com.es.everis.scorer.exceptions.ScorerServiceException;
import com.es.everis.scorer.repositories.PlayerRepository;
import com.es.everis.scorer.rest.PlayerRest;
import com.es.everis.scorer.service.PlayerService;
import com.es.everis.scorer.utils.ExceptionConstants;
import com.es.everis.scorer.utils.converters.PlayerConverter;

@Service
public class PlayerServiceImpl implements PlayerService {

  @Autowired
  PlayerRepository playerRepository;

  @Override
  public PlayerRest createPlayer(String name) throws ScorerServiceException {
    final Player player = playerRepository.save(Player.builder().name(name).build());
    return PlayerConverter.toRest(player);

  }

  @Override
  public PlayerRest retrievePlayer(String name) throws ScorerServiceException {
    final Optional<Player> player = playerRepository.findByName(name);
    if (player.isPresent()) {
      return PlayerConverter.toRest(player.get());
    }
    return null;
  }

  @Override
  public List<PlayerRest> retrievePlayerList() throws ScorerServiceException {
    return playerRepository.findAll().stream().map(player -> PlayerConverter.toRest(player))
        .collect(Collectors.toList());
  }

  @Override
  public PlayerRest updateScoreByPlayerName(String name, int score) throws ScorerServiceException {
    final Player player = playerRepository.findByName(name)
        .orElseThrow(() -> new NotFoundException(ExceptionConstants.CODE404_1,
            ExceptionConstants.MESSAGE_PLAYER_NOT_FOUND));
    player.setScore(score);
    return PlayerConverter.toRest(playerRepository.save(player));

  }
}
