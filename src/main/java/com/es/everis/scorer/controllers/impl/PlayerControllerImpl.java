package com.es.everis.scorer.controllers.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  @PostMapping(value = RestConstants.RESOURCE_PLAYER, produces = MediaType.APPLICATION_JSON_VALUE)
  public ScorerResponse<PlayerRest> createPlayer(@RequestBody final String name)
      throws ScorerServiceException {

    final PlayerRest player = playerService.retrievePlayer(name);
    if (player != null) {

      return new ScorerResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.SEE_OTHER),
          CommonConstants.OK, player);
    }

    return new ScorerResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.CREATED),
        CommonConstants.OK, playerService.createPlayer(name));

  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = RestConstants.RESOURCE_PLAYER, produces = MediaType.APPLICATION_JSON_VALUE)
  public ScorerResponse<List<PlayerRest>> retrievePlayerList() throws ScorerServiceException {
    return new ScorerResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
        CommonConstants.OK, playerService.retrievePlayerList());
  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = RestConstants.RESOURCE_PLAYER + RestConstants.PARAMETER_NAME_PLAYER,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ScorerResponse<PlayerRest> updateScoreByPlayerName(@PathVariable final String name)
      throws ScorerServiceException {
    return new ScorerResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
        CommonConstants.OK, playerService.updateScoreByPlayerName(name));
  }
}
