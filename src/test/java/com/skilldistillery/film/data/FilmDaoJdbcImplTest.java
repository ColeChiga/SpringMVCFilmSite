package com.skilldistillery.film.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.film.entities.Film;

class FilmDaoJdbcImplTest {

	 private FilmDaoJdbcImpl dao;

	 @BeforeEach
	 void setUp() throws Exception {
	 	dao = new FilmDaoJdbcImpl();
	 }

	 @AfterEach
	 void tearDown() throws Exception {
	 	dao = null;
	 }
	
	 @Test
	 void test_findById_returns_film() {
	 	Film film = dao.findById(1);
	 	assertNotNull(film);
	 	assertEquals("ACADEMY DINOSAUR", film.getTitle());
	 }
	 
	 @Test
	 void test_findById_returns_null_for_invalid_id() {
	 	Film film = dao.findById(1234567);
	 	assertNull(film);
	 }

	 @Test
	 void test_findByKeyword_returns_film() {
		 List<Film> film = dao.searchByKeyword("Academy Dinosaur");
		 assertNotNull(film);
		 assertEquals("ACADEMY DINOSAUR", film.get(0).getTitle());
	 }
	 
	 @Test
	 void test_findByKeyword_returns_empty_list_for_invalid_keyword() {
		 List<Film> film = dao.searchByKeyword("cdecercfcw");
		 assertEquals(0, film.size());;
	 }
}
