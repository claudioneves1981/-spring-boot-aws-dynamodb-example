package com.claudioneves.dynamodb.repository;

import com.claudioneves.dynamodb.model.Music;
import com.claudioneves.dynamodb.model.MusicId;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface MusicRepository extends CrudRepository<Music, MusicId> {

   // List<Music> findByArtist(String artist);
}
