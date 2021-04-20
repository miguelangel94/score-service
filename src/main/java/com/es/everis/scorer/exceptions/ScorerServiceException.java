package com.es.everis.scorer.exceptions;

import java.util.ArrayList;
import java.util.List;
import com.es.everis.scorer.dto.ErrorDto;

public class ScorerServiceException extends Exception {

  private static final long serialVersionUID = 6173659257108201607L;

  private final String code;

  private final int responseCode;

  private final List<ErrorDto> errorList = new ArrayList<>();

  public ScorerServiceException(final String code, final int responseCode, final String message) {
    super(message);
    this.code = code;
    this.responseCode = responseCode;
  }

  public ScorerServiceException(final String code, final int responseCode, final String message,
      final List<ErrorDto> errorList) {
    super(message);
    this.code = code;
    this.responseCode = responseCode;
    this.errorList.addAll(errorList);
  }

  public String getCode() {
    return this.code;
  }

  public int getResponseCode() {
    return responseCode;
  }

  public List<ErrorDto> getErrorList() {
    return errorList;
  }

}
