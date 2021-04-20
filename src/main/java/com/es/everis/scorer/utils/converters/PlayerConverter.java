package com.es.everis.scorer.utils.converters;

import com.es.everis.scorer.entities.Player;
import com.es.everis.scorer.rest.PlayerRest;

public class PlayerConverter {

  public static Player toEntity(PlayerRest playerRest) {
    return Player.builder().name(playerRest.getName()).score(playerRest.getScore()).build();
  }

  public static PlayerRest toRest(Player player) {
    return PlayerRest.builder().name(player.getName()).score(player.getScore()).build();
  }

}
