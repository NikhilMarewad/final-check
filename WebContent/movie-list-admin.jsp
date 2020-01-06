<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./style/style.css" rel="Stylesheet" type="text/css" />
</head>
<body>



	<header> <span class="texts">Movie Cruiser</span> <img
		class="imag" src="./images/logo.png" />
	<p id="txts1">
		<a id="txtcolor" href="ShowMovieListAdmin">Movies</a>
	</p>
	</header>
	<br />

	<h1 class="mytab">Movies</h1>
	<table class="mytab">

		<tr>
			<th class="tgaps tleft ">Title</th>
			<th class="tgaps tright ">Box Office</th>
			<th class="tgaps tcenter">Active</th>
			<th class="tcenter">Date of Launch</th>
			<th class="tgaps tcenter ">Genre</th>
			<th class="tgaps tcenter ">Has Teaser</th>
			<th class="tgaps tcenter">Action</th>
		</tr>

		<c:forEach items="${movieItemList}" var="movie">
			<tr>
				<td class="tleft">${movie.title}</td>
				<td class="tleft">$. ${movie.boxOffice}</td>
				<td class="tcenter">${movie.active?'Yes':'No'}</td>
				<td class="tcenter">${movie.dateOfLaunch}</td>
				<td class="tcenter">${movie.genre}</td>
				<td class="tcenter">${movie.hasTeaser?'Yes':'No'}</td>
				<td class="tcenter"><a
					href="ShowEditMovieItem?movieItemId=${movie.id}">Edit</a></td>
			</tr>
		</c:forEach>

	</table>

	<br />
	<footer>
	<h5>Copyright &copy 2019</h5>
	</footer>
</body>
</html>






























</body>
</html>