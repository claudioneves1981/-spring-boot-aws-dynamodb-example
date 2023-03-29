package com.claudioneves.dynamodb.adapter;

import com.claudioneves.dynamodb.dto.MusicDTO;
import com.claudioneves.dynamodb.model.Music;
import com.claudioneves.dynamodb.model.MusicId;
import lombok.Builder;
import lombok.Data;

@Data
public class MusicDTOAdapter {

    private Music music;

    public MusicDTOAdapter(MusicDTO musicDTO){

         music = toModel(musicDTO);
    }

    public Music toModel(MusicDTO musicDTO){

      return Music.builder()
              .musicId(MusicId.builder()
                      .artist(musicDTO.getArtist())
                      .songTitle(musicDTO.getSongTitle())
                      .build())
              .albumTitle(musicDTO.getAlbumTitle())
              .songYear(musicDTO.getSongYear())
              .build();
    }
}
