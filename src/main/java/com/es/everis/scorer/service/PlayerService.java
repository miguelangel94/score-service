package com.es.everis.scorer.service;

import com.es.everis.scorer.exceptions.ScorerServiceException;
import com.es.everis.scorer.rest.PlayerRest;

public interface PlayerService {
  PlayerRest createPlayer(String name) throws ScorerServiceException;
}
