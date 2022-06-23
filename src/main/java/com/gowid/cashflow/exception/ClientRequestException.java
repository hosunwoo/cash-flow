package com.gowid.cashflow.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 500 Bad Gateway(클라이언트 서버 에러)
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class ClientRequestException extends BaseException {

    public ClientRequestException(ResultType resultType) {
        super(resultType);
    }

    public ClientRequestException(ResultType resultType, String extraMessage) {
        super(resultType, extraMessage);
    }

    public ClientRequestException(String extraMessage) {
        super(ResultType.CLIENT_REQUEST_ERROR, extraMessage);
    }

}
