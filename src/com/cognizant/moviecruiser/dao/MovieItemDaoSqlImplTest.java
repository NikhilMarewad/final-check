package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieItemDaoSqlImplTest {

	public static void main(String[] args) {

		try {
			System.out.println("*-----Admin Detials-----*");
			testGetMovieItemListAdmin();
			System.out.println("*-----Customer Detials-----*");
			testGetMovieItemListCustomer();
			System.out.println("*-----Modified Detials-----*");
			testModifyMovieItem();
			testGetMovieItemListAdmin();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void testGetMovieItemListAdmin() {
		MovieItemDao movieItemDao = new MovieItemDaoSqlImpl();
		List<MovieItem> movieItemList = movieItemDao.getMovieItemListAdmin();
		for (MovieItem admin : movieItemList) {
			System.out.println(admin);
		}

	}

	public static void testGetMovieItemListCustomer() {
		MovieItemDao movieItemDao = new MovieItemDaoSqlImpl();
		List<MovieItem> movieItemList = movieItemDao.getMovieItemListCustomer();
		for (MovieItem customer : movieItemList) {
			System.out.println(customer);
		}

	}

	public static void testModifyMovieItem() {
		MovieItem movieItem;
		try {
			movieItem = new MovieItem(1, "Justic League", 4787965087l, true, DateUtil.convertToDate("20/03/2018"),
					"Superhero", true);
			MovieItemDao movieItemDao = new MovieItemDaoSqlImpl();
			movieItemDao.modifyMovieItem(movieItem);
		} catch (ParseException e) {
			
			System.out.println(e);
		}

	}

}
