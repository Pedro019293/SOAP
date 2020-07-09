<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="v" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report-de-vendas</title>
</head>
<body>

	<c:if test="${controle != null}">
		<table>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>PREÇO</th>
				<th>QUANTIDADE</th>
				<th colspan="2">EDITAR</th>

			</tr>
			<c:forEach var="v" items="${listaVendas}" varStatus="id">
				<tr>
					<td>${v.codigo}</td>
					<td>${v.nomeCliente}</td>
					<td>${v.dataVenda}</td>
					<td>${v.descricao}</td>
					<td>${v.valor}</td>
					<td>${v.situacaoPagamento}</td>				
				</tr>
			</c:forEach>

		</table>
	</c:if>
		

	

</body>
</html>