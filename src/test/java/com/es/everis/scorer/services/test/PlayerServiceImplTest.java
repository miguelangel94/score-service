package com.es.everis.scorer.services.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
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


  private static final String NAME_STRING = "Any";
  private static final int SCORE = 99;
  private static final int ID = 1;
  private final Player PLAYER_ENTITY = new Player();
  private final List<Player> PLAYER_ENTITY_LIST = new ArrayList<>();
  private static final PlayerRest PLAYER_REST = new PlayerRest(NAME_STRING, SCORE);


  @Before
  public void initMocks() {
    MockitoAnnotations.initMocks(this);
    PLAYER_ENTITY.setName(NAME_STRING);
    PLAYER_REST.builder().name(PLAYER_ENTITY.getName()).score(PLAYER_ENTITY.getScore()).build();
    PLAYER_ENTITY_LIST.add(PLAYER_ENTITY);
  }

  @Test
  public void createPlayerWhenNameNotExistTest() throws ScorerServiceException {
    when(playerRepository.save(Mockito.any(Player.class))).thenReturn(PLAYER_ENTITY);
    final PlayerRest response = playerServiceImpl.createPlayer(NAME_STRING);
    Mockito.verify(playerRepository, times(1)).save(Mockito.any(Player.class));
    assertNotNull(response);

  }

  @Test
  public void retrievePlayerWhenAlreadyExistsTest() throws ScorerServiceException {
    Mockito.when(playerRepository.findByName(Mockito.anyString()))
        .thenReturn(Optional.of(PLAYER_ENTITY));
    final PlayerRest response = playerServiceImpl.retrievePlayer(NAME_STRING);
    assertNotNull(response);
  }

  @Test
  public void retrievePlayerWhenNotExistsTest() throws ScorerServiceException {
    Mockito.when(playerRepository.findByName(Mockito.anyString())).thenReturn(Optional.empty());
    final PlayerRest response = playerServiceImpl.retrievePlayer(NAME_STRING);
    assertNull(response);
  }

  @Test
  public void retrievePlayerListTest() throws ScorerServiceException {
    when(playerRepository.findAll()).thenReturn(PLAYER_ENTITY_LIST);
    final List<PlayerRest> response = playerServiceImpl.retrievePlayerList();
    assertNotNull(response);
    assertEquals(NAME_STRING, response.get(0).getName());

  }
}
