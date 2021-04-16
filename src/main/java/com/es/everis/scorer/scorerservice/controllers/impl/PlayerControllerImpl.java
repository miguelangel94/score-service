package com.es.everis.scorer.scorerservice.controllers.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.es.everis.scorer.scorerservice.controllers.PlayerController;
import com.es.everis.scorer.scorerservice.utils.RestConstants;


@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1)
public class PlayerControllerImpl implements PlayerController {


  @Override
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = RestConstants.PARAMETER_PLAYER, produces = MediaType.APPLICATION_JSON_VALUE)

  public String createPlayer(@RequestParam final String name) {
    return null;

  }

}
