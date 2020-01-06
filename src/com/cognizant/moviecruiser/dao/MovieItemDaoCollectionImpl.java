package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieItemDaoCollectionImpl implements MovieItemDao {

	private static List<MovieItem> movieItemList;

	public MovieItemDaoCollectionImpl() throws ParseException {
		if (movieItemList == null) {

			movieItemList = new ArrayList<>();
			movieItemList.add(new MovieItem(1, "Avatar", 2787965087l, true, DateUtil.convertToDate("15/03/2017"),
					"Science Fiction", true));
			movieItemList.add(new MovieItem(2, "The Avengers", 1518812988l, true, DateUtil.convertToDate("23/12/2017"),
					"Superhero", false));
			movieItemList.add(new MovieItem(3, "Titanic", 2187463944l, true, DateUtil.convertToDate("21/08/2017"),
					"Science Romance", false));
			movieItemList.add(new MovieItem(4, "Jurassic World", 1671731208l, false,
					DateUtil.convertToDate("02/07/2017"), "Science Fiction", true));
			movieItemList.add(new MovieItem(5, "Avengers:End Game", 2750760348l, true,
					DateUtil.convertToDate("02/11/2022"), "Superhero", true));

		}

	}

	@Override
	public List<MovieItem> getMovieItemListAdmin() {
		return movieItemList;
	}

	@Override
	public List<MovieItem> getMovieItemListCustomer() {
		List<MovieItem> movieItemCustomer=new ArrayList<>();
		
		Date d = new Date();
		for (MovieItem m : movieItemList) {
			if (m.isActive() && m.getDateOfLaunch().before(d)) {
				movieItemCustomer.add(m);
			}
		}
		return movieItemCustomer;
	}

	@Override
	public void modifyMovieItem(MovieItem movieItem) {
		MovieItem x = getMovieItem(movieItem.getId());

		x.setTitle(movieItem.getTitle());
		x.setBoxOffice(movieItem.getBoxOffice());
		x.setActive(movieItem.isActive());
		x.setDateOfLaunch(movieItem.getDateOfLaunch());
		x.setGenre(movieItem.getGenre());
		x.setHasTeaser(movieItem.isHasTeaser());

	}

	@Override
	public MovieItem getMovieItem(long movieListId) {
		MovieItem movieItem = null;
		for (MovieItem n : movieItemList) {
			if (n.getId() == movieListId) {
				movieItem = n;
			}
		}
		return movieItem;
	}

}
