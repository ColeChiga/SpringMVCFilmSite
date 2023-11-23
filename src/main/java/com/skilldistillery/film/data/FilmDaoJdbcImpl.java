package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		System.out.println("SearchByID accessed successfully: " + filmId);
		try {
			System.out.println("try catch accessed successfully: ");
			conn = DriverManager.getConnection(URL, USER, PWD);

			String sql = "SELECT * FROM film WHERE id = ?";
			System.out.println("conn accessed successfully: " + sql);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				film = makeFilm(rs);
				System.out.println("film set successfully: ");
			}

			conn.close();
		} catch (SQLException e) {
			System.out.println("error detected");
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public List<Film> searchByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();
		System.out.println("SearchByKeyword accessed successfully: " + keyword);

		try {
			System.out.println("enter try catch");
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			System.out.println("passed conn");
			String sql = "SELECT DISTINCT film.* FROM film JOIN film_actor ON film.id = film_actor.film_id WHERE film.title LIKE ? OR film.description LIKE ?";

			System.out.println("sql accessed successfully: " + sql);

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Film film = makeFilm(rs);
				films.add(film);
				System.out.println("film is" + film);
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

		String lang = findLanguageOfFilm(langId);
//		List<Actor> actors = findActorsByFilmId(filmId);
		Film film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating, features,
				lang);

		return film;

	}

	public String findLanguageOfFilm(int langId) {
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
