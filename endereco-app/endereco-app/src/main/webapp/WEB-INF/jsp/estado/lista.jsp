<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AppEndereco</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container mt-3">
		<h2>Estados</h2>

		<hr>
		<c:if test="${not empty lista}">
			<h2>Total de Estados: ${lista.size()}</h2>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Sigla</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="e" items="${lista}">
						<tr>
							<td>${e.nome}</td>
							<td>${e.sigla}</td>
							<td><a href="/municipio/${e.id}">Municipios</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty lista}">
			<h2>Não existem Estados cadastrados.</h2>
		</c:if>

	</div>
</body>
</html>