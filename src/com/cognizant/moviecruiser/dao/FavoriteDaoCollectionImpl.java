package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.*;

public class FavoriteDaoCollectionImpl implements FavoriteDao {

	private static HashMap<Long, Favorite> userFavorite;

	public FavoriteDaoCollectionImpl() {
		if (userFavorite == null) {
			userFavorite = new HashMap<>();
			userFavorite.put(1l, new Favorite());

		}
	}

	@Override
	public void addFavoriteItem(long userId, long movieListId) throws ParseException {
		try {
			MovieItemDaoCollectionImpl movieItemDao = new MovieItemDaoCollectionImpl();
			MovieItem movie = movieItemDao.getMovieItem(movieListId);

			if (userFavorite.containsKey(userId)) {
				Favorite fav = userFavorite.get(userId);
				fav.getMovieItemList().add(movie);
			} else {
				Favorite fav = new Favorite();
				fav.getMovieItemList().add(movie);
				userFavorite.put(userId, fav);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<MovieItem> getAllFavoriteItem(long userId) throws FavoriteEmptyException {
		List<MovieItem> movieItemList = userFavorite.get(userId).getMovieItemList();
		Favorite favorite = userFavorite.get(userId);
		if (favorite == null || movieItemList.isEmpty()) {

			throw new FavoriteEmptyException();
		}
		return movieItemList;
	}

	@Override
	public void removeFavoriteItem(long userId, long movieitemId) {
		// List<MovieItem> movies = new ArrayList<>();
		List<MovieItem> movieItem = userFavorite.get(userId).getMovieItemList();
		for (MovieItem m : movieItem) {
			if (m.getId() == movieitemId) {
				movieItem.remove(m);
				break;
			}
		}

	}

}
