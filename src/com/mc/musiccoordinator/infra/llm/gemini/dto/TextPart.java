package com.mc.musiccoordinator.infra.llm.gemini.dto;

public class TextPart {

    private String text;

    public TextPart(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "TextPart{" +
                "text='" + text + '\'' +
                '}';
    }
}
