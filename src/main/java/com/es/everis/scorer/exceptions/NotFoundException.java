package com.es.everis.scorer.exceptions;

import java.util.Arrays;
import org.springframework.http.HttpStatus;
import com.es.everis.scorer.dto.ErrorDto;

public class NotFoundException extends ScorerServiceException {

  private static final long serialVersionUID = 1419856382856533644L;

  public NotFoundException(final String message) {
    super(String.valueOf(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND.value(), message);
  }

  public NotFoundException(final String code, final String message) {
    super(code, HttpStatus.NOT_FOUND.value(), message);
  }

  public NotFoundException(final String code, final String message, final ErrorDto data) {
    super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
  }
}
