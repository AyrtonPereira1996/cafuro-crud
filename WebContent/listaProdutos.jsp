<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type=text/css href="resources/css/estilo.css">

<script type="text/javascript">
	function confirma(id) {
		if (window.confirm("Pretende excuir o produto?"))
			location.href = "excluirProduto?id=" + id;
	}
</script>
<style>
form.form-report input.li-botao {
	border: none;
	color: #8c8c8c;
	background-color: #fff;
}

form.form-report input.li-botao:hover {
	background-color: #ffd3c9;
	color: #fff;
}


</style>




<title>Lista de Produtos</title>
</head>
<body>
	<%
		List listaProdutos = (List) request.getAttribute("listaProdutos");
		System.out.println(listaProdutos);
	%>
	<div class="banner">
		<h1 style="color: #5e5e5e;">
			Lista de produtos do <span
				style="color: #4c0909; text-decoration: underline;">Cafuro</span>
		</h1>
		<hr />
	</div>
	<div class="header">

		<ul>
			<li><a href="index.html">Home</a></li>
			<li><a href="frmNovoProduto.jsp">Criar novo Produto</a></li>
			<li>
				<form class="form-report" action="reportServlet" method="post" target="_blank">
					<input style="font-size: 12pt;" class="li-botao" type="submit" value="Obter relatório" />
				</form>
			</li>
		</ul>
	</div>
	
	<div class="data-content">
		<table class="table-products">
			<tr>
				<th style="text-align: left;">Nome do produto</th>
				<th style="text-align: left;">Preço</th>
				<th>Ações</th>
			</tr>
			<c:forEach items="${listaProdutos}" var="produto">

				<tr>
					<td style="height: 25%;">${produto.nome}</td>

					<td style="height: 25%;">${produto.preco}Mt</td>

					<td><a href="editarProduto?id=${produto.id}">Editar</a> <a
						href="javascript:confirma(${produto.id})")>Excluir</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>




</body>
</html>