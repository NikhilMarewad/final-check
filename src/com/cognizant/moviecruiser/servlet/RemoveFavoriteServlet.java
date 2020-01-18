package com.cognizant.moviecruiser.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoriteDao;
import com.cognizant.moviecruiser.dao.FavoriteDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.FavoriteDaoSqlImpl;
import com.cognizant.moviecruiser.dao.FavoriteEmptyException;

/**
 * Servlet implementation class RemoveFavoriteServlet
 */
@WebServlet({ "/RemoveFavoriteServlet", "/RemoveFavorite" })
public class RemoveFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveFavoriteServlet() {
		super();
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
			favoriteDao.removeFavoriteItem(1, movieItemId);
			request.setAttribute("remove", "Item removed from the Favorite successfully");
			RequestDispatcher rd = request.getRequestDispatcher("ShowFavorite");
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
