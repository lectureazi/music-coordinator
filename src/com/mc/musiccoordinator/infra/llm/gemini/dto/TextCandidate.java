package com.mc.musiccoordinator.infra.llm.gemini.dto;

public class TextCandidate {
    private TextContent content;

    public TextCandidate(TextContent content) {
        this.content = content;
    }

    public TextContent getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "TextCandidate{" +
                "content=" + content +
                '}';
    }
}
