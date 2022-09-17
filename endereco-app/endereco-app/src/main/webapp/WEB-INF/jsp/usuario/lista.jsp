<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AppMIT</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Cadastramento de Usuários</h2>

	<c:if test="${not empty lista}">		
		<h2>Total de Usuários: ${lista.size()}</h2>
		  
		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>ID</th>
		        <th>Nome</th>
		        <th>E-mail</th>
		        <th>Endereço</th>
		        <th>Solicitantes</th>
		        <th>Produtos</th>
		        <th>Pedidos</th>
        		<th></th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="u" items="${lista}">
			      <tr>
			        <td>${u.id}</td>
			        <td>${u.nome}</td>
			        <td>${u.email}</td>
			        <td>${u.endereco.cep}</td>
			        <td>${u.solicitantes.size()}</td>
			        <td>${u.produtos.size()}</td>
			        <td>${u.pedidos.size()}</td>
			        <td>
			        <c:if test="${user.admin}">			        
						<c:choose>
							<c:when test = "${user.id != u.id}">
								<a href="/usuario/${u.id}/excluir">excluir</a>							
							</c:when>						
						</c:choose>			      			        
			        </c:if>
			        </td>
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
    </c:if>	  	  

	<c:if test="${empty lista}">		
	  <h2>Não existem usuários cadastrados!!!</h2>
	</c:if>

	</div>
</body>
</html>