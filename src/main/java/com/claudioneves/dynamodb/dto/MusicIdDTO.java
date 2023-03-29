package com.claudioneves.dynamodb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MusicIdDTO {

    @JsonProperty("Artist")
    @NotNull
    @NotBlank
    private String artist;

    @JsonProperty("SongTitle")
    @NotNull
    @NotBlank
    private String songTitle;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }
}
