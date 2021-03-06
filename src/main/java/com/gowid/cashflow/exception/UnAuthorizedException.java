package com.gowid.cashflow.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 401 Unauthorized(권한 없음)
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class UnAuthorizedException extends BaseException {

    private static final long serialVersionUID = 2074542044459042228L;

    public UnAuthorizedException(ResultType resultType) {
        super(resultType);
    }

    public UnAuthorizedException(ResultType resultType, String extraMessage) {
        super(resultType, extraMessage);
    }

    public UnAuthorizedException(String extraMessage) {
        super(ResultType.AUTHENTICATION_FAILURE, extraMessage);
    }

}
