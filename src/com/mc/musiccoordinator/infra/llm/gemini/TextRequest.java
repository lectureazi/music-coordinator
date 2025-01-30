package com.mc.musiccoordinator.infra.llm.gemini;

import com.google.gson.Gson;
import com.mc.musiccoordinator.infra.llm.BaseRequest;
import com.mc.musiccoordinator.infra.llm.ResponseFormat;
import com.mc.musiccoordinator.infra.llm.gemini.dto.TextContent;
import com.mc.musiccoordinator.infra.llm.gemini.dto.TextPart;
import com.mc.musiccoordinator.infra.llm.gemini.dto.TextRequestDocument;

import java.util.List;

public class TextRequest implements BaseRequest {

    private String text;

    public <T> TextRequest(String text, ResponseFormat<T> format) {
        this.text = text;
        this.text += "메타데이터는 적지마. " + format.formatToJson() + " 형식으로 응답해줘.";
    }

    @Override
    public String toJson() {
        Gson gson = new Gson();
        TextPart part = new TextPart(text);
        TextContent content = new TextContent(List.of(part));
        TextRequestDocument doc = new TextRequestDocument(List.of(content));
        return gson.toJson(doc);
    }
}
