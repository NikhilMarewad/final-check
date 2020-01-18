package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;


public class FavoriteDaoSqlImplTest {

	public static void main(String[] args) {
		testgetAllFavoriteItems();
		testAddFavoriteItem();
		testgetAllFavoriteItems();
		testRemoveFavoriteItem();
		testgetAllFavoriteItems();
	}
	
	public static void testAddFavoriteItem() {
		FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();

		try {
			favoriteDao.addFavoriteItem(101, 1);
			favoriteDao.addFavoriteItem(102, 2);
			favoriteDao.addFavoriteItem(103, 3);
			favoriteDao.addFavoriteItem(102, 1);
			favoriteDao.addFavoriteItem(103, 2);
			favoriteDao.addFavoriteItem(104, 3);
			favoriteDao.addFavoriteItem(104, 5);
			
		} catch (ParseException e) {
			System.out.println(e);
		}
	
	}
	public static void testgetAllFavoriteItems() {
		FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();
		try {
			List<MovieItem> movieItemList = favoriteDao.getAllFavoriteItem(1);
			System.out.println("-----AllCartItems-----");
			for (MovieItem movieList : movieItemList)
				System.out.println(movieList);
		} catch (Exception e) {

			System.out.println(e);
		}
	}
	
	public static void testRemoveFavoriteItem() {
		FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();
		try {
			favoriteDao.removeFavoriteItem(104, 5);
		} catch (FavoriteEmptyException e) {
			
			System.out.println(e);		}
		
	}

}
