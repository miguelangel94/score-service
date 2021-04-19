package com.es.everis.scorer.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.es.everis.scorer.controllers.PlayerController;
import com.es.everis.scorer.exceptions.ScorerServiceException;
import com.es.everis.scorer.responses.ScorerResponse;
import com.es.everis.scorer.rest.PlayerRest;
import com.es.everis.scorer.service.PlayerService;
import com.es.everis.scorer.utils.CommonConstants;
import com.es.everis.scorer.utils.RestConstants;


@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1)
public class PlayerControllerImpl implements PlayerController {

  @Autowired
  PlayerService playerService;

  @Override
  @ResponseStatus(HttpStatus.OK)
  @PostMapping(value = RestConstants.PARAMETER_PLAYER, produces = MediaType.APPLICATION_JSON_VALUE)
  public ScorerResponse<PlayerRest> createPlayer(@RequestBody final String name)
      throws ScorerServiceException {
    return new ScorerResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
        CommonConstants.OK, playerService.createPlayer(name));

  }
}
