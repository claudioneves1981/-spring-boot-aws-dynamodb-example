package com.claudioneves.dynamodb.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.claudioneves.dynamodb.model.MusicId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Builder
public class MusicDTO implements Serializable {

    private static final long serialVersionUID = 6318931228062100559L;

    private MusicIdDTO musicIdDTO;

    @JsonProperty("AlbumTitle")
    @NotNull
    @NotBlank
    private String  albumTitle;

    @JsonProperty("SongYear")
    @NotNull
    @NotBlank
    private String songYear;

    @JsonProperty("Artist")
    @NotNull
    @NotBlank
    public String getArtist() {
        return musicIdDTO != null ? musicIdDTO.getArtist() : null;
    }

    public void setArtist(String artist) {
        if (musicIdDTO == null) {
            musicIdDTO = new MusicIdDTO();
        }
        musicIdDTO.setArtist(artist);
    }

    @JsonProperty("SongTitle")
    @NotNull
    @NotBlank
    public String getSongTitle() {
        return musicIdDTO != null ? musicIdDTO.getSongTitle() : null;
    }

    public void setSongTitle(String songTitle) {
        if (musicIdDTO == null) {
            musicIdDTO = new MusicIdDTO();
        }
        musicIdDTO.setSongTitle(songTitle);
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getSongYear() {
        return songYear;
    }

    public void setSongYear(String songYear) {
        this.songYear = songYear;
    }

    public MusicIdDTO getMusicIdDTO() {
        return musicIdDTO;
    }

    public void setMusicIdDTO(MusicIdDTO musicIdDTO) {
        this.musicIdDTO = musicIdDTO;
    }

}
