package com.cognizant.moviecruiser.model;

import java.util.ArrayList;
import java.util.List;

public class Favorite {

	private List<MovieItem> movieItemList;

	private double total;

	public Favorite() {
		super();
		movieItemList = new ArrayList<>();
	}

	public List<MovieItem> getMovieItemList() {
		return movieItemList;
	}

	public void setMovieItemList(List<MovieItem> movieItemList) {
		this.movieItemList = movieItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
