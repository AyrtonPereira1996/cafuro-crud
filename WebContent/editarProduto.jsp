<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="resources/css/estilo.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edi��o de produto</title>
</head>
<body>
	<div class="banner">
		<h1>
			Edi��o de produto do <span
				style="color: #4c0909; text-decoration: underline;">Cafuro</span>
		</h1>
		<hr>
	</div>

	<div class="header">

		<ul>
			<li><a href="index.html">Home</a></li>
			<li><a href="listaProduto">Listar produtos</a></li>
			<li><a href="frmNovoProduto.jsp">Criar novo Produto</a></li>
		</ul>
	</div>
	<div class="content-form">
		<form class="form" action="editarProduto" method="post">
			C�digo: <input class="input-box" readonly="readonly"
				value=${produtoEncontrado.id } name="id" /><br /> <br /> * Nome:
			<input class="input-box" type="text" name="nome"
				value="${produtoEncontrado.nome}" required="required" /><br /> <br />
			* Pre�o: <input class="input-box" type="number" name="preco"
				value="${produtoEncontrado.preco}"><br /> <br />* Tipo: <select
				name="tipo">
				<option value="Prato">Prato</option>
				<option value="Doce" ${produtoEncontrado.tipo=='Doce'}>Doce</option>
				<option value="Sandes" ${produtoEncontrado.tipo=='Sandes'}>Sandes</option>
				<option value="Salgados" ${produtoEncontrado.tipo=='Salgados'}>Salgados</option>
				<option value="Bebida sem alcool"
					${produtoEncontrado.tipo=='Bebida sem alcool'}>Bebida sem
					alcool</option>
				<option value="Bebida com alcool"
					${produtoEncontrado.tipo=='Bebida com alcool'}>Bebida com
					alcool</option>
			</select><br /> <br />* Activo: Sim<input type="radio" name="activo"
				value="true"> N�o<input type="radio" name="activo"
				value="false"><br/>
			<br /><input class="button" type="submit" value="Editar" />
		</form>

	</div>

</body>
</html>