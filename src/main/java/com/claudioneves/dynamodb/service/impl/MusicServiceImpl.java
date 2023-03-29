package com.claudioneves.dynamodb.service.impl;

import com.claudioneves.dynamodb.dto.MusicDTO;
import com.claudioneves.dynamodb.model.Music;
import com.claudioneves.dynamodb.repository.MusicRepository;
import com.claudioneves.dynamodb.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.claudioneves.dynamodb.adapter.MusicDTOAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService  {

    private MusicRepository musicRepository;


    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }


    public MusicServiceImpl(){

    }

    @Override
    public List<Music> findAllMusics() {
        return (List<Music>) musicRepository.findAll();
    }

    @Override
    public List<Music> findByAlbumTitle(String albumTitle) {

        List<Music> temp = (List<Music>) musicRepository.findAll();
        List<Music> resultado = new ArrayList<>();
        for (Music music : temp) {
            if (Objects.equals(music.getAlbumTitle(), albumTitle)) {
                resultado.add(music);
            }
        }

        return resultado;
    }

    @Override
    public List<Music> findByArtist(String artist) {

        List<Music> temp = (List<Music>) musicRepository.findAll();
        List<Music> resultado = new ArrayList<>();
        for (Music music : temp) {
            if (Objects.equals(music.getMusicId().getArtist(), artist)) {
                resultado.add(music);
            }
        }

        return resultado;
    }

    @Override
    public List<Music> findByArtistSongTitle(String artist, String songTitle) {
        List<Music> temp = (List<Music>) musicRepository.findAll();
        List<Music> resultado = new ArrayList<>();
        for (Music music : temp) {
            if (Objects.equals(music.getMusicId().getArtist(), artist) && Objects.equals(music.getMusicId().getSongTitle(), songTitle)) {
                resultado.add(music);
            }
        }

        return resultado;

    }

    @Override
    public List<Music> findByArtistAlbumTitle(String artist, String albumTitle) {

        List<Music> temp = (List<Music>) musicRepository.findAll();
        List<Music> resultado = new ArrayList<>();
        for (Music music : temp) {
            if (Objects.equals(music.getMusicId().getArtist(), artist) && Objects.equals(music.getAlbumTitle(), albumTitle)) {
                resultado.add(music);
            }
        }

        return resultado;
       // return musicRepository.findByArtistAlbumTitle(artist,albumTitle);
    }

    @Override
    public List<Music> findBySongTitleYear(String songTitle, String year) {
        List<Music> temp = (List<Music>) musicRepository.findAll();
        List<Music> resultado = new ArrayList<>();
        for (Music music : temp) {
            if (Objects.equals(music.getMusicId().getSongTitle(), songTitle) && Objects.equals(music.getSongYear(), year)) {
                resultado.add(music);
            }
        }

        return resultado;
       // return musicRepository.findBySongTitleYear(songTitle, year);
    }

    @Override
    public Music saveMusic(MusicDTO musicDTO) {
        if(musicRepository.findById(new MusicDTOAdapter(musicDTO).getMusic().getMusicId()).isPresent()) {
            throw new RuntimeException("There is already a customer with this document number");
        }
        return musicRepository.save(new MusicDTOAdapter(musicDTO).getMusic());
    }


}
