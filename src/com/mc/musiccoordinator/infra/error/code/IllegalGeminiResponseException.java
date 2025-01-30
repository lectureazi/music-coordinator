package com.mc.musiccoordinator.infra.error.code;

import com.mc.musiccoordinator.infra.error.CommonException;

public class IllegalGeminiResponseException extends CommonException {
    public IllegalGeminiResponseException(ErrorCode errorCode) {
        super(errorCode);
    }
}
