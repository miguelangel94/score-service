package com.es.everis.scorer.utils;

public class SwaggerConstants {

  private SwaggerConstants() {
    // NOOP
  }

  public static final String AUTH_RETRIEVE_MESSAGE200 = "The user exists, return token acess";
  public static final String AUTH_RETRIEVE_MESSAGE400 =
      "Bad request \r\n SPRO-400-1 Invalid input parameters, unauthorized client.";
  public static final String AUTH_RETRIEVE_MESSAGE401 =
      "Unauthorized for this service \r\n SIDS-401-1 Bad Credentials  \r\n SIDS-401-2 User account is locked\r\n SCLI-400-2 Invalid login email \r\n";
  public static final String AUTH_RETRIEVE_MESSAGE500 = "Internal server error";
  public static final String RESPONSE_STATUS = "Result of the action, for example \"Success\".";
  public static final String RESPONSE_CODE =
      "Status code, extra information related to HTTP response";
  public static final String RESPONSE_MESSAGE = "Specific message, result of the action";
  public static final String RESPONSE_DATA = "Contain data related to request";


}
