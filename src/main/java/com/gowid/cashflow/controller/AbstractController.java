package com.gowid.cashflow.controller;

import com.gowid.cashflow.dto.ResponseDTO;
import com.gowid.cashflow.dto.ResponseDTO.APIResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractController {

  protected <T> ResponseDTO<T> ok() {
    return ok(null, APIResult.getSuccess());
  }

  protected <T> ResponseDTO<T> ok(T data) {
    return ok(data, APIResult.getSuccess());
  }

  protected <T> ResponseDTO<T> ok(T data, APIResult result) {
    ResponseDTO<T> dto = new ResponseDTO<>();
    dto.setResult(result);
    dto.setData(data);

    return dto;
  }
}
