package com.gowid.cashflow.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 400 Bad Request(잘못된 요청)
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class BadRequestException extends BaseException {

    public BadRequestException(ResultType resultType) {
        super(resultType);
    }

    public BadRequestException(ResultType resultType, String extraMessage) {
        super(resultType, extraMessage);
    }

    public BadRequestException(String extraMessage) {
        super(ResultType.NOT_FOUND, extraMessage);
    }

}
