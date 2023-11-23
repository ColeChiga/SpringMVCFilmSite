package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.*;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDao = new FilmDaoJdbcImpl();

	@RequestMapping(path = { "home.do", "/" })
	public String goToHome() {
		return "WEB-INF/home.jsp";
	}
	
	@RequestMapping(path = { "keywordForm" })
	public String keywordForm() {
		return "WEB-INF/keywordForm.html";
	}
	
	@RequestMapping(path = "GetFilmData.do", method = RequestMethod.GET, params = "keyword")
	public ModelAndView getFilmsByKeyword(String keyword) {
		ModelAndView mv = new ModelAndView();
		System.out.println("GetFilmsByKeyword accessed successfully: " + keyword);
		mv.addObject("film", filmDao.searchByKeyword(keyword));
		mv.addObject("keyword", keyword);
		mv.setViewName("WEB-INF/films.jsp");
		return mv;
	}
	
	@RequestMapping(path = "GetFilmData.do", method = RequestMethod.GET, params = "id")
	public ModelAndView getFilmByID(int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", filmDao.findById(id));
		mv.setViewName("WEB-INF/singleFilm.jsp");
		return mv;
	}
	
}
