package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoriteDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.FavoriteEmptyException;
import com.cognizant.moviecruiser.model.MovieItem;

/**
 * Servlet implementation class ShowFavoriteServlet
 */
@WebServlet({ "/ShowFavoriteServlet", "/ShowFavorite" })
public class ShowFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ShowFavoriteServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			FavoriteDaoCollectionImpl favoriteItemDao = new FavoriteDaoCollectionImpl();
			List<MovieItem> movieItemList = favoriteItemDao.getAllFavoriteItem(1);
			long favTotal=0;
			for(MovieItem m:movieItemList)
			{
				favTotal=movieItemList.size();
			}
			request.setAttribute("movieItemList", movieItemList);
			request.setAttribute("favTotal", favTotal);
			RequestDispatcher rd = request.getRequestDispatcher("favorites.jsp");
			rd.forward(request, response);
		} catch (FavoriteEmptyException e) {
			RequestDispatcher rd = request.getRequestDispatcher("favorites-empty.jsp");
			rd.forward(request, response);
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
