package com.claudioneves.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.claudioneves.dynamodb.dto.MusicIdDTO;
import lombok.Builder;

@Builder
public class MusicId {

    private static final long serialVersionUID = 1L;

    private String artist;
    private String songTitle;


    @DynamoDBHashKey
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @DynamoDBRangeKey
    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public MusicId(String artist, String songTitle) {
        this.artist = artist;
        this.songTitle = songTitle;
    }

    public MusicId() {

    }
}
