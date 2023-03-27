package com.claudioneves.dynamodb.controller.impl;

import com.claudioneves.dynamodb.controller.AppController;
import com.claudioneves.dynamodb.dto.MusicDTO;
import com.claudioneves.dynamodb.model.Music;
import com.claudioneves.dynamodb.model.MusicId;
import com.claudioneves.dynamodb.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class AppControllerImpl implements AppController {

    private MusicService musicService;

    @Autowired
    public AppControllerImpl(MusicService musicService) {
        this.musicService = musicService;
    }

    public AppControllerImpl(){


    }


    @GetMapping("Music/albumtitle")
    @Override
    public ResponseEntity<List<Music>> findMusicByAlbumTitle(@Param("albumTitle") String albumTitle) {
        return ResponseEntity.ok(musicService.findByAlbumTitle(albumTitle));
    }

    @GetMapping("Music/artist")
    @Override
    public ResponseEntity<List<Music>> findMusicByArtist(@Param("artist") String artist) {
        return ResponseEntity.ok(musicService.findByArtist(artist));
    }

    @GetMapping("Music/artistsongtitle")
    @Override
    public ResponseEntity<List<Music>> findMusicByArtistSongTitle(@Param("artist") String artist, @Param("songTitle") String songTitle) {
        return ResponseEntity.ok(musicService.findByArtistSongTitle(artist,songTitle));
    }

    @GetMapping("Music/artistalbumtitle")
    @Override
    public ResponseEntity<List<Music>> findMusicByArtistAlbumTitle(@Param("artist") String artist, @Param("albumTitle") String albumTitle) {
        return ResponseEntity.ok(musicService.findByArtistAlbumTitle(artist,albumTitle));
    }

    @GetMapping("Music/songtitleyear")
    @Override
    public ResponseEntity<List<Music>> findMusicBySongTitleYear(@Param("songTitle") String songTitle, @Param("year") String year) {
        return ResponseEntity.ok(musicService.findBySongTitleYear(songTitle,year));
    }

    @GetMapping("Music/all")
    @Override
    public ResponseEntity<List<Music>> allMusics() {
        return ResponseEntity.ok(musicService.findAllMusics());
    }
}
