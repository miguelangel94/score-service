package com.es.everis.scorer.controllers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import com.es.everis.scorer.controllers.impl.PlayerControllerImpl;
import com.es.everis.scorer.exceptions.ScorerServiceException;
import com.es.everis.scorer.responses.ScorerResponse;
import com.es.everis.scorer.rest.PlayerRest;
import com.es.everis.scorer.service.PlayerService;
import com.es.everis.scorer.utils.CommonConstants;

public class PlayerControllerImplTest {
  private static final String STRING = "Any";
  private static final int SCORE = 99;
  private static final PlayerRest PLAYER_REST = new PlayerRest(STRING, SCORE);


  @Mock
  private PlayerService playerService;

  @InjectMocks
  private PlayerControllerImpl playerControllerImpl;

  @Before
  public void initMocks() {
    MockitoAnnotations.initMocks(this);

  }

  @Test
  public void createPlayerTest() throws ScorerServiceException {

    Mockito.when(playerService.createPlayer(Mockito.anyString())).thenReturn(PLAYER_REST);

    final ScorerResponse<PlayerRest> scorerResponse =
        playerControllerImpl.createPlayer(Mockito.any());
    assertNotNull(scorerResponse);

    assertEquals(CommonConstants.SUCCESS, scorerResponse.getStatus());

    assertEquals(String.valueOf(HttpStatus.OK), scorerResponse.getCode());

    assertEquals(CommonConstants.OK, scorerResponse.getMessage());

    assertEquals(PLAYER_REST, scorerResponse.getData());
  }
}
