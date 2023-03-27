package com.claudioneves.dynamodb.service;

import com.claudioneves.dynamodb.dto.MusicDTO;
import com.claudioneves.dynamodb.model.Music;
import com.claudioneves.dynamodb.model.MusicId;

import java.util.List;

public interface MusicService {
    List<Music> findAllMusics();
    List<Music> findByAlbumTitle(String albumTitle);
    List<Music> findByArtist(String artist);
    List<Music> findByArtistSongTitle(String artist, String songTitle);
    List<Music> findByArtistAlbumTitle(String artist, String albumTitle);
    List<Music> findBySongTitleYear(String songTitle, String year);
    List<Music> findBySongTitle(String songTitle);






}
