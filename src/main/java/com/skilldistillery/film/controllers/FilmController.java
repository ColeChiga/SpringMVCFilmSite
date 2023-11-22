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
	private FilmDAO filmDao;

	@RequestMapping(path = { "home.do", "/" })
	public String goToHome() {
		return "WEB-INF/home.jsp";
	}
	
	@RequestMapping(path = { "keywordForm" })
	public String keywordForm() {
		return "WEB-INF/keywordForm.html";
	}
	
	@RequestMapping(path = "GetFilmData.do", method = RequestMethod.GET, params = "keyword")
	public ModelAndView getStateByName(String keyword) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", filmDao.searchByKeyword(keyword));
		mv.setViewName("WEB-INF/result.jsp");
		return mv;
	}
	
	@RequestMapping(path = "GetFilmData.do", method = RequestMethod.GET, params = "id")
	public ModelAndView getStateByName(int filmId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", filmDao.findById(filmId));
		mv.setViewName("WEB-INF/result.jsp");
		return mv;
	}
	
}
