package com.es.everis.scorer.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.es.everis.scorer.responses.ScorerResponse;
import com.es.everis.scorer.utils.ExceptionConstants;

@ControllerAdvice
@SuppressWarnings({"rawtypes", "unchecked"})
public class ScorerServiceExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(ScorerServiceExceptionHandler.class);

  @ExceptionHandler({Exception.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public ScorerResponse unhandledErrors(final HttpServletRequest req, final Exception ex) {
    LOGGER.error(ex.getMessage(), ex);
    return new ScorerResponse(ExceptionConstants.ERROR, ExceptionConstants.CODE500,
        ex.getMessage());
  }

  @ExceptionHandler({ScorerServiceException.class})
  @ResponseBody
  public ScorerResponse handleLmException(final HttpServletRequest request,
      final HttpServletResponse response, final ScorerServiceException ex) {
    response.setStatus(ex.getResponseCode());
    LOGGER.error(ex.getMessage(), ex);
    return new ScorerResponse(ExceptionConstants.ERROR, ex.getCode(), ex.getMessage(),
        ex.getErrorList());
  }


}
