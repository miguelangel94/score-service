package com.es.everis.scorer.services.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.es.everis.scorer.entities.Player;
import com.es.everis.scorer.exceptions.ScorerServiceException;
import com.es.everis.scorer.repositories.PlayerRepository;
import com.es.everis.scorer.rest.PlayerRest;
import com.es.everis.scorer.service.impl.PlayerServiceImpl;


public class PlayerServiceImplTest {

  @Mock
  private PlayerRepository playerRepository;

  @InjectMocks
  private PlayerServiceImpl playerServiceImpl;


  private static final String STRING = "Any";
  private static final int SCORE = 99;
  private static final int ID = 1;
  private final Player PLAYER_ENTITY = new Player();
  private static final PlayerRest PLAYER_REST = new PlayerRest(STRING, SCORE);


  @Before
  public void initMocks() {
    MockitoAnnotations.initMocks(this);
    PLAYER_REST.builder().name(PLAYER_ENTITY.getName()).score(PLAYER_ENTITY.getSCORE()).build();
  }

  @Test
  public void createPlayerWhenNameNotExistTest() throws ScorerServiceException {
    Mockito.when(playerRepository.findByName(Mockito.anyString())).thenReturn(Optional.empty());
    when(playerRepository.save(Mockito.any(Player.class))).thenReturn(PLAYER_ENTITY);
    final PlayerRest response = playerServiceImpl.createPlayer(STRING);
    Mockito.verify(playerRepository, times(1)).save(Mockito.any(Player.class));
    assertNotNull(response);

  }

  @Test
  public void createPlayerWhenPlayerAlreadyExistsTest() throws ScorerServiceException {
    Mockito.when(playerRepository.findByName(Mockito.anyString()))
        .thenReturn(Optional.of(PLAYER_ENTITY));
    playerServiceImpl.createPlayer(STRING);
    Mockito.verify(playerRepository, times(0)).save(Mockito.any(Player.class));


  }
}
