package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoriteDao;
import com.cognizant.moviecruiser.dao.FavoriteDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.FavoriteDaoSqlImpl;
import com.cognizant.moviecruiser.dao.MovieItemDao;

/**
 * Servlet implementation class AddToFavoriteServlet
 */
@WebServlet({ "/AddToFavoriteServlet", "/AddToFavorite" })
public class AddToFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AddToFavoriteServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();
		long movieItemId = Long.parseLong(request.getParameter("movieItemId"));
		try {
			favoriteDao.addFavoriteItem(1, movieItemId);
			request.setAttribute("add", "Item added from the Favorite successfully");
			RequestDispatcher rd = request.getRequestDispatcher("ShowMovieListCustomer");
			rd.forward(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
