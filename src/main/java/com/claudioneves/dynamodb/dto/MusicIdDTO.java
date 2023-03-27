package com.claudioneves.dynamodb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class MusicIdDTO implements Serializable {

    private static final long serialVersionUID = 6318931228062100559L;

    @JsonProperty("Artist")
    @NotNull
    @NotBlank
    private String artist;

    @JsonProperty("SongTitle")
    @NotNull
    @NotBlank
    private String songTitle;

    public MusicIdDTO(String artist, String songTitle) {

        this.artist = artist;
        this.songTitle = songTitle;
    }

    public MusicIdDTO() {

    }

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
