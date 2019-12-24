package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieItemDaoCollectionTest {

	public static void main(String... arg) {
		try {
			System.out.println("--------Movie Item List Admin------");
			testGetMovieItemListAdmin();
			System.out.println("--------Movie Item List Customer-------");
			testGetMovieItemListCustomer();
			testModifyMovieItem();
			System.out.println("--------Movie Item List Admin------");
			testGetMovieItemListAdmin();
		} catch (ParseException e) {

			e.printStackTrace();
		}

	}

	private static void testGetMovieItemListAdmin() throws ParseException {
		MovieItemDaoCollectionImpl movieItemDao = new MovieItemDaoCollectionImpl();
		List<MovieItem> movieList = movieItemDao.getMovieItemListAdmin();

		for (MovieItem x : movieList) {
			System.out.println(x);
		}

	}

	private static void testGetMovieItemListCustomer() throws ParseException {
		MovieItemDaoCollectionImpl movieItemDao = new MovieItemDaoCollectionImpl();
		List<MovieItem> movieList = movieItemDao.getMovieItemListCustomer();

		for (MovieItem x : movieList) {
			System.out.println(x);
		}

	}

	private static void testModifyMovieItem() throws ParseException {
		MovieItem movieItem = new MovieItem(1, "Lord Of Rings", 2787965087l, true, DateUtil.convertToDate("20/03/2012"),
				"War", true);
		MovieItemDaoCollectionImpl movieItemDao = new MovieItemDaoCollectionImpl();
		movieItemDao.modifyMovieItem(movieItem);

	}

}
