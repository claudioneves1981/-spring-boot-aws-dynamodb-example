package com.claudioneves.dynamodb.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.claudioneves.dynamodb.model.MusicId;

public class MusicIdTypeConverter implements DynamoDBTypeConverter<String, MusicId> {

    @Override
    public String convert(MusicId musicId) {
        MusicId itemMusic = (MusicId) musicId;
        String music = null;
        try {
            if (itemMusic != null) {
                music = "{\"artist\": \""+musicId.getArtist()+"\","+
                        "\"songTitle\": \""+musicId.getSongTitle()+"\"}";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return music;
    }


    @Override
    public MusicId unconvert(String s) {
        MusicId itemMusic = new MusicId();
        try {
            if (s != null && s.length() != 0) {
                String[] data = s.split(",");
                itemMusic.setArtist(data[0].substring(data[0].indexOf(':'),data[0].indexOf(',')).trim());
                itemMusic.setSongTitle(data[1].substring(data[1].indexOf(':'),data[0].indexOf('}')));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return itemMusic;
    }
}

