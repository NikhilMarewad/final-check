package com.cognizant.moviecruiser.model;

import java.text.ParseException;
import com.cognizant.moviecruiser.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cognizant.moviecruiser.util.DateUtil;

public class MovieItem {

	private String title;

	private long boxOffice;

	private boolean active;

	private Date dateOfLaunch;

	private String genre;

	private boolean hasTeaser;

	private long id;

	public MovieItem(long id, String title, long boxOffice, boolean active, Date dateOfLaunch, String genre,
			boolean hasTeaser) {
		super();
		this.title = title;
		this.boxOffice = boxOffice;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(long boxOffice) {
		this.boxOffice = boxOffice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		active = active;
	}

	public Date getDateOflaunch() {
		return dateOfLaunch;
	}

	public void setDateOflaunch(Date dateOfLaunch) {
		dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		genre = genre;
	}

	public boolean isHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieItem other = (MovieItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String detials = String.format("%-20s $ %7s %-5s %-10s %-15s %-8s Edit", title, boxOffice,
				active ? "Yes" : "No", sdf.format(dateOfLaunch), genre, hasTeaser ? "Yes" : "No");
		return detials;
	}

}
