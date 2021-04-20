package com.es.everis.scorer.rest;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PlayerRest implements Serializable {

  private static final long serialVersionUID = -1332589825268712909L;

  private final String name;
  private final int score;


}
