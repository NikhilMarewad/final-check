<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./style/style.css" rel="Stylesheet" type="text/css" />
<script src="./js/script.js" type="text/javascript"></script>
</head>
<body>
	<header> <span class="texts">Movie Cruiser</span> <img
		class="imag" src="./images/logo.png" />
	<p id="txts1">
		<a id="txtcolor" href="ShowMovieListAdmin">Movies</a>
	</p>
	</header>
	<br />

	<h1 class="myhead">Edit Movie</h1>
	<form class="mytab" action="EditMovieItem?movieItemId=${movieItemList.id}"
		name="myForm" onsubmit="return validateForm()" method="Post">
		<table class="mytab wowtab">

			<tr>
				<td>Title:</td>
			</tr>

			<tr>
				<td colspan="4"><input type="text" name="title" class="txtname"
					value="${movieItemList.title}" /></td>
			</tr>

			<tr>
				<td>Gross($)</td>
				<td>Active</td>
				<td>Date of Launch</td>
				<td>Genre</td>
			</tr>

			<tr>
				<td><input type="number" name="boxOffice"
					value="${movieItemList.boxOffice}" class="txtno" /></td>
				<td><label for="active" class="radios"> <input
						type="radio" checked name="acive" id="rd1"
						value="${movieItemList.active?'Yes':'No'}"
						<c:if test="${movieItemList.active eq 'Yes'}"></c:if> />Yes <input
						type="radio" name="acive" id="rd2"
						value="${movieItemList.active?'Yes':'No'}"
						<c:if test="${movieItemList.active eq 'No'}"></c:if> />No
				</label></td>
				
				<td><input type="text" name="dateOfLaunch" value="<fmt:formatDate value='${movieItemList.dateOfLaunch}' pattern='dd/MM/yyyy'></fmt:formatDate>"/>
				</td>
				<td><select class="tabsize" name="genre">
						<option value="<c:if test="${movieItemList.genre eq 'Science Fiction'}"></c:if> ">Science Fiction</option>
						<option value="<c:if test="${movieItemList.genre eq 'Superhero'}"></c:if> ">Superhero</option>
						<option value="<c:if test="${movieItemList.genre eq 'Romance'}"></c:if> ">Romance</option>
						<option value="<c:if test="${movieItemList.genre eq 'Comedy'}"></c:if> ">Comedy</option>
						<option value="<c:if test="${movieItemList.genre eq 'Adventure'}"></c:if> ">Adventure</option>
						<option value="<c:if test="${movieItemList.genre eq 'Thriller'}"></c:if> ">Thriller</option>
				</select></td>
			</tr>

			<tr>
				<td><label for="hasTeaser"> <input type="checkbox"
						name="hasTeaser" value="${movieItemList.hasTeaser?'Yes':'No'}"
						id="chk1" checked="true"
						<c:if test="${movieItemList.hasTeaser eq true}"></c:if> />Has
						Teaser
				</label></td>
			</tr>

			<tr>
				<td><input type="submit" value="Save" class="btn" /></td>
			</tr>

		</table>
	</form>
	<br />
	<footer class="footos">
	<h5>Copyright &copy 2019</h5>
	</footer>


</body>
</html>