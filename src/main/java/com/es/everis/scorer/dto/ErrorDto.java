package com.es.everis.scorer.dto;

import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ErrorDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private String value;

  public ErrorDto(final String name, final String value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof ErrorDto)) {
      return false;
    }
    final ErrorDto castOther = (ErrorDto) other;
    return new EqualsBuilder().append(name, castOther.name).append(value, castOther.value)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(name).append(value).toHashCode();
  }

}
