package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public class FavoriteDaoCollectionImplTest {

	public static void main(String... arg) throws ParseException {
		System.out.println("===========Add Favorite Item============");
		testAddFavoriteItem();
		testGetAllFavoriteItem();

		System.out.println("===========Remove favorite Item============");
		testRemovefavoriteItem();
		testGetAllFavoriteItem();

	}

	private static void testAddFavoriteItem() throws ParseException {
		FavoriteDaoCollectionImpl favoriteDao = new FavoriteDaoCollectionImpl();

		favoriteDao.addFavoriteItem(1, 1);
		favoriteDao.addFavoriteItem(1, 2);
		favoriteDao.addFavoriteItem(1, 3);
		favoriteDao.addFavoriteItem(1, 4);
		favoriteDao.addFavoriteItem(1, 5);

	}

	private static void testGetAllFavoriteItem() {

		FavoriteDaoCollectionImpl favoriteDao = new FavoriteDaoCollectionImpl();

		try {
			List<MovieItem> movieItemList = favoriteDao.getAllFavoriteItem(1);

			for (MovieItem mm : movieItemList) {
				System.out.println(mm);
			}
			System.out.println("No of Favorite Items :" + movieItemList.size());
		} catch (FavoriteEmptyException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void testRemovefavoriteItem() {
		FavoriteDaoCollectionImpl favoriteDao = new FavoriteDaoCollectionImpl();
		favoriteDao.removeFavoriteItem(1, 1);
	}

}
