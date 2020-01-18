package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;


public class MovieItemDaoSqlImpl implements MovieItemDao {

	@Override
	public List<MovieItem> getMovieItemListAdmin() {
		Connection con = ConnectionHandler.getConnection();
		List<MovieItem> movieItemList = new ArrayList<>();
		try {
			String sqlAdmin = "select * from movie_item";
			PreparedStatement ps = con.prepareStatement(sqlAdmin);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MovieItem movie = new MovieItem();
				movie.setId(rs.getInt("mo_id"));
				movie.setTitle(rs.getString("mo_title"));
				movie.setBoxOffice(rs.getLong("mo_box_office"));
				movie.setActive(rs.getString("mo_active").equalsIgnoreCase("Yes"));
				movie.setDateOfLaunch(rs.getDate("mo_date_of_launch"));
				movie.setGenre(rs.getString("mo_genre"));
				movie.setHasTeaser(rs.getString("mo_has_teaser").equalsIgnoreCase("Yes"));
				movieItemList.add(movie);
			}
		} catch (SQLException sql) {
			System.out.println(sql);
		} finally {
			try {
				con.close();
			} catch (SQLException sql) {

				System.out.println(sql);
			}
		}
		return movieItemList;
	}

	@Override
	public List<MovieItem> getMovieItemListCustomer() {
		Connection con = ConnectionHandler.getConnection();
		List<MovieItem> movieItemList1 = new ArrayList<>();

		try {

			String sqlCustomer = "select"
									+ " mo_id, "
									+ "mo_title,"
									+ " mo_box_office,"
									+ "mo_active,"
									+ "mo_date_of_launch, "
									+ "mo_genre, "
									+ "mo_has_teaser "
									+ "from movie_item "
									+ "where mo_active = ? "
									+ "and mo_date_of_launch <?";
			PreparedStatement ps = con.prepareStatement(sqlCustomer);
			ps.setString(1, "Yes");
			ps.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MovieItem movie = new MovieItem();
				movie.setId(rs.getInt("mo_id"));
				movie.setTitle(rs.getString("mo_title"));
				movie.setBoxOffice(rs.getLong("mo_box_office"));
				movie.setActive(rs.getString("mo_active").equalsIgnoreCase("Yes"));
				movie.setDateOfLaunch(rs.getDate("mo_date_of_launch"));
				movie.setGenre(rs.getString("mo_genre"));
				movie.setHasTeaser(rs.getString("mo_has_teaser").equalsIgnoreCase("Yes"));
				movieItemList1.add(movie);
			}

		} catch (SQLException sql) {
			System.out.println(sql);
		} finally {

			try {
				con.close();
			} catch (SQLException sql) {

				System.out.println(sql);
			}
		}
		return movieItemList1;
	}

	@Override
	public void modifyMovieItem(MovieItem movieItem) {
		Connection con = ConnectionHandler.getConnection();
		try {
			
			String sqlModify = "update movie_item "
								+ "set mo_title=?,"
								+ "mo_box_office=?,"
								+ "mo_active=?,"
								+ "mo_date_of_launch=?,"
								+ " mo_genre=?,"
								+ "mo_has_teaser=? "
								+ "where mo_id=?";
			PreparedStatement ps = con.prepareStatement(sqlModify);
			ps.setString(1,movieItem.getTitle());
			ps.setDouble(2,movieItem.getBoxOffice());
			ps.setString(3,movieItem.isActive()?"Yes":"No");
			ps.setDate(4,new java.sql.Date(movieItem.getDateOfLaunch().getTime()));
			ps.setString(5,movieItem.getGenre());
		    ps.setString(6,movieItem.isHasTeaser()?"Yes":"No");
			ps.setLong(7,movieItem.getId());
			
		  int output= ps.executeUpdate();
		  System.out.println(output);
			
		}
		catch(SQLException sql) {
			System.out.println(sql);
		}finally {
			try {
				con.close();
			} catch (SQLException sql) {

				System.out.println(sql);
			}
		}

	}

	@Override
	public MovieItem getMovieItem(long movieListId) {
		Connection con = ConnectionHandler.getConnection();
		MovieItem movie = new MovieItem();
		String sqlItem="select mo_id, mo_tile, mo_box_office,me_active,mo_date_of_launch, mo_genre, mo_has_teaser from movie_item where mo_id=? ";
		try {
			PreparedStatement ps = con.prepareStatement(sqlItem);
			ps.setLong(1, movieListId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				movie.setId(rs.getInt("mo_id"));
				movie.setTitle(rs.getString("mo_tile"));
				movie.setBoxOffice(rs.getLong("mo_box_office"));
				movie.setActive(rs.getString("mo_active").equalsIgnoreCase("Yes"));
				movie.setDateOfLaunch(rs.getDate("mo_date_of_launch"));
				movie.setGenre(rs.getString("mo_genre"));
				movie.setHasTeaser(rs.getString("mo_has_teaser").equalsIgnoreCase("Yes"));
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException sql) {
			
				System.out.println(sql);
			}
		}
		return movie;
	}

}
