package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;

public interface FavoriteDao {

	public void addFavoriteItem(long userId, long movieListId) throws ParseException;

	public List<MovieItem> getAllFavoriteItem(long userId) throws FavoriteEmptyException;

	public void removeFavoriteItem(long userId, long movieitemId)throws FavoriteEmptyException;

}
