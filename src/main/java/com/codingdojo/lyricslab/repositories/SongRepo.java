package com.codingdojo.lyricslab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.examendos.models.User;
import com.codingdojo.lyricslab.models.Song;

public interface SongRepo extends CrudRepository<Song, Long> {

	@Query(value = "SELECT * FROM songs WHERE user_id == :id", nativeQuery = true)
	List<Song> findAll(Long id);
	List<Song> findAllByYo(User usuario);

}
