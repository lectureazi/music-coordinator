package com.mc.musiccoordinator.domain.song;

public class SongMessage {

    private String title;
    private String singer;
    private String reason;

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "SongMessage{" +
                "title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
