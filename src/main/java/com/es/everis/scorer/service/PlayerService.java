package com.es.everis.scorer.service;

import java.util.List;
import com.es.everis.scorer.exceptions.ScorerServiceException;
import com.es.everis.scorer.rest.PlayerRest;

public interface PlayerService {
  PlayerRest createPlayer(String name) throws ScorerServiceException;

  PlayerRest retrievePlayer(String name) throws ScorerServiceException;

  List<PlayerRest> retrievePlayerList() throws ScorerServiceException;
}
