package com.es.everis.scorer.controllers;

import java.util.List;
import com.es.everis.scorer.exceptions.ScorerServiceException;
import com.es.everis.scorer.responses.ScorerResponse;
import com.es.everis.scorer.rest.PlayerRest;

public interface PlayerController {

  ScorerResponse<PlayerRest> createPlayer(String name) throws ScorerServiceException;

  ScorerResponse<List<PlayerRest>> retrievePlayerList() throws ScorerServiceException;

}
