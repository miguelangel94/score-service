package com.es.everis.scorer.responses;

import java.io.Serializable;
import com.es.everis.scorer.utils.SwaggerConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This model is the envelope")
public class ScorerResponse<T> implements Serializable {

  @ApiModelProperty(value = SwaggerConstants.RESPONSE_STATUS)
  private String status;
  @ApiModelProperty(value = SwaggerConstants.RESPONSE_CODE)
  private String code;
  @ApiModelProperty(value = SwaggerConstants.RESPONSE_MESSAGE)
  private String message;
  @ApiModelProperty(value = SwaggerConstants.RESPONSE_DATA)
  private T data;

  private static final long serialVersionUID = 7302319210373510173L;

  public ScorerResponse() {
    super();
  }

  public ScorerResponse(String status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }

  public ScorerResponse(String status, String code, String message, T data) {
    this.status = status;
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "SingapurResponse [status=" + this.status + ", code=" + this.code + ", message="
        + this.message + ", data=" + this.data + "]";
  }

}
