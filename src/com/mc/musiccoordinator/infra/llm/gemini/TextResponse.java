package com.mc.musiccoordinator.infra.llm.gemini;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mc.musiccoordinator.infra.error.CommonException;
import com.mc.musiccoordinator.infra.error.code.ErrorCode;
import com.mc.musiccoordinator.infra.error.code.IllegalGeminiResponseException;
import com.mc.musiccoordinator.infra.llm.BaseResponse;
import com.mc.musiccoordinator.infra.llm.gemini.dto.TextResponseDocument;

public class TextResponse implements BaseResponse {
    private String responseText;

    public TextResponse(String responseText) {
        this.responseText = responseText;
    }

    @Override
    public <T> T response(Class<T> target) {

        try{
            Gson gson = new Gson();
            TextResponseDocument response = gson.fromJson(responseText, TextResponseDocument.class);
            String text = response
                    .getCandidates()
                    .getFirst()
                    .getContent()
                    .getParts()
                    .getFirst()
                    .getText();
            return gson.fromJson(text, target);
        } catch (JsonSyntaxException e){
            throw new IllegalGeminiResponseException(ErrorCode.NOT_VALID_GEMINI_RESPONSE);
        }
    }
}
