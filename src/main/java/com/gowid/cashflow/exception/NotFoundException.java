package com.gowid.cashflow.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 404 Not Found(찾을 수 없음)
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Getter
@Setter
public class NotFoundException extends BaseException {

    public NotFoundException(ResultType resultType) {
        super(resultType);
    }

    public NotFoundException(ResultType resultType, String extraMessage) {
        super(resultType, extraMessage);
    }

    public NotFoundException(String extraMessage) {
        super(ResultType.NOT_FOUND, extraMessage);
    }

}
