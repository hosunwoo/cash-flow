package com.gowid.cashflow.dto;

import com.gowid.cashflow.exception.BaseException;
import com.gowid.cashflow.exception.ResultType;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> implements Serializable {

  private APIResult result;
  private T data;

  public ResponseDTO(BaseException e) {
    this.result = new APIResult(e);
  }

  @Getter
  @Setter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class APIResult implements Serializable {

    private String code;
    private String desc;
    private String extraMessage;

    public APIResult(ResultType resultType) {
      this.code = resultType.getCode();
      this.desc = resultType.getDesc();
    }

    public APIResult(ResultType resultType, String extraMessage) {
      this.code = resultType.getCode();
      this.desc = resultType.getDesc();
      this.extraMessage = extraMessage;
    }

    public APIResult(BaseException ex) {
      this.code = ex.getCode();
      this.desc = ex.getDesc();
      this.extraMessage = ex.getExtraMessage();
    }

    public static APIResult getSuccess() {
      return new APIResult(ResultType.SUCCESS);
    }
  }
}
