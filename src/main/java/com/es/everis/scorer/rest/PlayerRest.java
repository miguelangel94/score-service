package com.es.everis.scorer.rest;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRest implements Serializable {

  private static final long serialVersionUID = 7899610993817997180L;

  @JsonProperty("name")
  private String name;
  @JsonProperty("score")
  private int score;


}
