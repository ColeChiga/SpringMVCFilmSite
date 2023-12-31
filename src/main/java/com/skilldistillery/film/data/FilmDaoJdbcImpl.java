package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class FilmDaoJdbcImpl implements FilmDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private final static String USER = "student";
	private final static String PWD = "student";

	public FilmDaoJdbcImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findById(int filmId) {
		Film film = null;
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);

			String sql = "SELECT * FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				film = makeFilm(rs);
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public List<Film> searchByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			String sql = "SELECT DISTINCT film.* FROM film JOIN film_actor ON film.id = film_actor.film_id WHERE film.title LIKE ? OR film.description LIKE ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Film film = makeFilm(rs);
				films.add(film);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error Detected");
			e.printStackTrace();
		}
		return films;
	}

	public Film makeFilm(ResultSet rs) throws SQLException {
		int filmId = rs.getInt("id");
		String title = rs.getString("title");
		String desc = rs.getString("description");
		short releaseYear = rs.getShort("release_year");
		int langId = rs.getInt("language_id");
		int rentDur = rs.getInt("rental_duration");
		double rate = rs.getDouble("rental_rate");
		int length = rs.getInt("length");
		double repCost = rs.getDouble("replacement_cost");
		String rating = rs.getString("rating");
		String features = rs.getString("special_features");
		String category = findCategoryOfFilm(filmId);
		
		String lang = findLanguageOfFilm(langId);
		List<Actor> actors = findActorsByFilmId(filmId);
		Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating, features, actors, lang, category);
		return film;

	}
	
	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			String sql = "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id WHERE film_actor.film_id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String fn = rs.getString("first_name");
				String ln = rs.getString("last_name");
				Actor actor = new Actor(fn, ln, id);
				actors.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return actors;
	}

	
	private String findCategoryOfFilm(int filmId) {
		String category=null;
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			String sql = "SELECT category.name FROM category JOIN film_category ON category.id = "
					+ "category_id WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				category = rs.getString("name");
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return category;
	}
	

	private String findLanguageOfFilm(int langId) {
		String lang = null;
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			String sql = "SELECT name FROM language WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, langId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				lang = rs.getString("name");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lang;

	}
}
