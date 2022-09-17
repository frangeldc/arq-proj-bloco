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
		<h2>Cadastramento de Endereços</h2>

		<c:if test="${empty endereco.cep}">
			<form action="/endereco" method="post">
				<div class="mb-3 mt-3">
					<label>Cep:</label> <input type="text" class="form-control"
						placeholder="Entre com o seu cep" name="cep"
						value="${endereco.cep}">
				</div>
				<button type="submit" class="btn btn-primary">Buscar</button>
			</form>
		</c:if>

		<c:if test="${not empty endereco.cep}">
			<form action="/endereco/incluir" method="post">
				<c:import url="/WEB-INF/jsp/endereco.jsp" />
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</form>
		</c:if>
	</div>

</body>
</html>