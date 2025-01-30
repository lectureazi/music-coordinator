package com.mc.musiccoordinator.infra.llm;

public interface BaseResponse {
    <T> T response(Class<T> target);
}
