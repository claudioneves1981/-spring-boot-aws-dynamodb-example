package com.claudioneves.dynamodb.controller;

import com.claudioneves.dynamodb.dto.MusicDTO;
import com.claudioneves.dynamodb.model.Music;
import com.claudioneves.dynamodb.model.MusicId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(value = "Manage Music Albuns")
    public interface AppController {

        @ApiOperation(value = "find music by album title")
        @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success find music"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
        })
        ResponseEntity<List<Music>> findMusicByAlbumTitle(String albumTitle);

        @ApiOperation(value = "find music by artist")
        @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success find music"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
        })
        ResponseEntity<List<Music>> findMusicByArtist(String artist);

        @ApiOperation(value = "find music by artist song title")
        @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success find music"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
        })
        ResponseEntity<List<Music>> findMusicByArtistSongTitle(String artist, String songTitle);

        @ApiOperation(value = "find music by artist album title")
        @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success find music"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
        })
        ResponseEntity<List<Music>> findMusicByArtistAlbumTitle(String artist, String albumTitle);

        @ApiOperation(value = "find music by song title year")
        @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success find music"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
        })
        ResponseEntity<List<Music>> findMusicBySongTitleYear(String songTitle, String year);

        @ApiOperation(value = "find all musics")
        @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucess find all musics"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
        })
        ResponseEntity<List<Music>> allMusics();
}
