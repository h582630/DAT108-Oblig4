<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<c:forEach var="participant" items="${participants}" varStatus="loop">
			<c:if test="${participant.phoneNumber == phoneNumber}">
				<tr bgcolor="#aaffaa">
			</c:if>
			<c:if test="${participant.phoneNumber != phoneNumber}">
				<tr bgcolor="#ffffff">
			</c:if>
			<c:if test="${participant.sex == 'mann'}">
				<td align="center">&#9794;</td>
			</c:if>
			<c:if test="${participant.sex == 'kvinne'}">
				<td align="center">&#9792;</td>
			</c:if>


			<td>${participant.firstName} ${participant.lastName}</td>
			<td>${participant.phoneNumber}</td>

		</c:forEach>
	</table>
	<p>
		<a href="LoggOut">Ferdig</a>
		<%--Her må det skrives inn ref til loggout servlet.  --%>
	</p>
</body>
</html>