package com.mc.musiccoordinator.infra.llm;

public interface BaseChatModel {
    BaseResponse invoke(BaseRequest req);
}
