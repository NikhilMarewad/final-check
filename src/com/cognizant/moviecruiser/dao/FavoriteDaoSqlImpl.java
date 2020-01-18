package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.MovieItem;

public class FavoriteDaoSqlImpl implements FavoriteDao {

	@Override
	public void addFavoriteItem(long userId, long movieListId) throws ParseException {
		Connection con = ConnectionHandler.getConnection();
		String sqlAdd = "insert into favorites  values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sqlAdd);
			ps.setLong(1, userId);
			ps.setLong(2, movieListId);
			int rs = ps.executeUpdate();
			

		} catch (SQLException e) {

			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				System.out.println(e);
			}
		}

	}

	@Override
	public List<MovieItem> getAllFavoriteItem(long userId) throws FavoriteEmptyException {

		Connection con = ConnectionHandler.getConnection();
		List<MovieItem> movieItem = new ArrayList<>();
		Favorite favorite = new Favorite();
		String sqlShow = "select m.mo_id,m.mo_title ," + " m.mo_box_office," + " m.mo_genre , " + "m.mo_has_Teaser"
				+ " from movie_item m " + "join favorites  f " + "on m.mo_id=f.fa_mo_id" + " where fa_us_id=102";
		try {
			PreparedStatement ps = con.prepareStatement(sqlShow);
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MovieItem movie = new MovieItem();
				movie.setId(rs.getInt("mo_id"));
				movie.setTitle(rs.getString("mo_title"));
				movie.setBoxOffice(rs.getLong("mo_box_office"));
				movie.setActive(rs.getString("mo_active").equalsIgnoreCase("Yes"));
				movie.setDateOfLaunch(rs.getDate("mo_date_of_launch"));
				movie.setGenre(rs.getString("mo_genre"));
				movie.setHasTeaser(rs.getString("mo_has_Teaser").equalsIgnoreCase("Yes"));
				favorite.getMovieItemList().add(movie);
			                   }
		    } catch (SQLException sql) {
			System.out.println(sql);
		}

		return favorite.getMovieItemList();
	}

	@Override
	public void removeFavoriteItem(long userId, long movieitemId) throws FavoriteEmptyException {
		Connection con = ConnectionHandler.getConnection();
		String sqlDelete = "Delete from favorites  where fa_us_id=? and fa_mo_id=? limit 1";
		try {
			PreparedStatement ps = con.prepareStatement(sqlDelete);
			ps.setLong(1, userId);
			ps.setLong(2, movieitemId);
			int delResult = ps.executeUpdate();
			System.out.println(delResult+"record deleted");
		} catch (SQLException sql) {
			System.out.println(sql);
		} finally {
			try {
				con.close();
			} catch (SQLException sql) {
				System.out.println(sql);

			}
		}

	}

}
