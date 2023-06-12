package com.codingdojo.lyricslab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.examendos.models.User;
import com.codingdojo.lyricslab.models.Song;
import com.codingdojo.lyricslab.repositories.SongRepo;

@Service
public class SongService {
	@Autowired
	private SongRepo songRepo;
	
	
	public List<Song> todosLasSong(Long idUsuario) {
		return songRepo.findAll(idUsuario);
	}

	public List<Song> SongYo(User usuario) {
		return songRepo.findAllByYo(usuario);
	}

	public Song crearSong(Song song) {
		return songRepo.save(song);
	}

	public Song findSongById(Long idSong) {
		return songRepo.findById(idSong).orElse(null);
	}
	public void borrarSong(Long id ) {
		songRepo.deleteById(id);
	}

}
