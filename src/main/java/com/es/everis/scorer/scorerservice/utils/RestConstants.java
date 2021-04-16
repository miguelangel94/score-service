package com.es.everis.scorer.scorerservice.utils;

public class RestConstants {

  public static final String APPLICATION_NAME = "/tictactoe";
  public static final String API_VERSION_1 = "/v1";
  public static final String SUCCESS = "Success";
  public static final String RESOURCE_ARTIST = "/artists";
  public static final String RESOURCE_ARTIST_ID = "/artist/{id_artist}";
  public static final String RESOURCE_ALBUM = "/albums";
  public static final String RESOURCE_SONG = "/songs";
  public static final String RESOURCE_ID = "/{id}";
  public static final String RESOURCE_NUMBER = "/{number}";
  public static final String PARAMETER_PLAYER = "players";
  public static final String PARAMETER_ALBUM = "albums";
  public static final String PARAMETER_SONG = "songs";

  private RestConstants() {
    throw new IllegalStateException("Utility Class");
  }

}
