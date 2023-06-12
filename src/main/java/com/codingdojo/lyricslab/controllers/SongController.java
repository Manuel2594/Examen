package com.codingdojo.lyricslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.examendos.models.User;
import com.codingdojo.examendos.services.UserService;
import com.codingdojo.lyricslab.models.Song;
import com.codingdojo.lyricslab.services.SongService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class SongController {
	@Autowired
	private UserService userService;
	@Autowired
	private SongService songService;
	
	@GetMapping("/home")
	public String dashboard(Model viewModel, HttpSession sesion) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}

		User usuarioLog = userService.findUserById(userId);

		viewModel.addAttribute("usuario", usuarioLog);
		viewModel.addAttribute("song_yo", songService.SongYo(usuarioLog));
		return "home.jsp";
	}
	
	@GetMapping("/songs/new")
	public String formularioSongs(@ModelAttribute("songs") Song song,
			HttpSession sesion, Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}

		User usuarioLog = userService.findUserById(userId);

		viewModel.addAttribute("usuario", usuarioLog);
		return "newsong.jsp";
	}

	@PostMapping("/songs/new")
	public String crearProj(@Valid @ModelAttribute("songs") Song song, BindingResult resultado,
			HttpSession sesion, Model viewModel) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		User usuarioLog = userService.findUserById(userId);
		if(resultado.hasErrors()) {
			viewModel.addAttribute("usuario", usuarioLog);
			return "newsong.jsp";
		}
		songService.crearSong(song);
		return "redirect:/home";
	}
	
	@GetMapping("/songs/{idSongs}")
	public String mostrarProyecto(Model viewModel, HttpSession sesion, @PathVariable("idSongs") Long idSongs) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		Song canta = songService.findSongById(idSongs);
		viewModel.addAttribute("cancion", canta);
		return "mostrar.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/songs/{idCancion}/edit")
	public String formularioEditProj(@ModelAttribute("cancion") Song song,
			HttpSession sesion, Model viewModel, @PathVariable("idCancion") Long idCancion ) {
		Long userId = (Long) sesion.getAttribute("userID");
		if (userId == null) {
			return "redirect:/";
		}
		Song cancionEditar = songService.findSongById(idCancion);
		User usuarioLog = userService.findUserById(userId);

		viewModel.addAttribute("usuario", usuarioLog);
		viewModel.addAttribute("cancion", cancionEditar);
		return "edit.jsp";
	}

	@PutMapping("/songs/{id}/edit")
    public String guardarEdit(@Valid @ModelAttribute("cancion") Song song, BindingResult result,
            @PathVariable("id") Long id, HttpSession sesion, Model m) {
        Long userId = (Long) sesion.getAttribute("userID");
        if (userId == null) {
            return "redirect:/";
        }
        Song pro = songService.findSongById(id);
        if (result.hasErrors()) {
            if (pro == null) {
                return "redirect:/home";
            }
            m.addAttribute("usuario", userService.findUserById(userId));
            return "edit.jsp";
        }

        songService.crearSong(song);
        return "redirect:/home";
    }
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/songs/delete/{id}")
	public String BorrarSong(@PathVariable("id") Long id, HttpSession sesion) {
		Long userLog = (Long) sesion.getAttribute("userID");
		if (userLog == null) {
			return "redirect:/";
	}
		Song song = songService.findSongById(id);
	if(userLog == song.getYo().getId()){
		
		songService.borrarSong(id);
		return"redirect:/home";
	}
	return"redirect:/home";
	}	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userID", null);
		return "redirect:/";
	}
}
