package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieItemDao;
import com.cognizant.moviecruiser.dao.MovieItemDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.MovieItemDaoSqlImpl;
import com.cognizant.moviecruiser.model.MovieItem;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Servlet implementation class EditMovieItemServlet
 */
@WebServlet({ "/EditMovieItemServlet", "/EditMovieItem" })
public class EditMovieItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public EditMovieItemServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
			long id = Long.parseLong(request.getParameter("movieItemId"));

			String title = request.getParameter("title");

			long boxOffice = Long.parseLong(request.getParameter("boxOffice"));

			boolean active = Boolean.parseBoolean(request.getParameter("active"));

			String dateOfLaunch =request.getParameter("dateOfLaunch");

			String genre = request.getParameter("genre");

			boolean hasTeaser = Boolean.parseBoolean(request.getParameter("hasTeaser"));
			
			try {
			MovieItem movieItemList = new MovieItem(id, title, boxOffice, active,DateUtil.convertToDate(dateOfLaunch), genre, hasTeaser);	
			MovieItemDao movieItemDao = new MovieItemDaoSqlImpl();
			movieItemDao.modifyMovieItem(movieItemList);
			request.setAttribute("msg", "Movie details saved successfully");
			RequestDispatcher rd = request.getRequestDispatcher("edit-movie-status.jsp");
			rd.forward(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	

}
