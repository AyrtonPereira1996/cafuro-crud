<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Produto</title>
<link rel="stylesheet" type=text/css href="resources/css/estilo.css">
</head>
<body>
	<div class="banner">
		<h1 style="color: #5e5e5e;">
			Cadastro de Produto no <span
				style="color: #4c0909; text-decoration: underline;">Cafuro</span>
		</h1>
	</div>
	<hr />

	<div class="header">

		<ul>
			<li><a href="index.html">Home</a></li>
			<li><a href="listaProduto">Listar produtos</a></li>
		</ul>
	</div>

	<div  class="content-form">
		<form class="form" action="/Cafuro/novoProduto" method="post">
			* Nome:&nbsp; <input placeholder="Nome do produto" required="required" class="input-box" type="text" name="nome" value="" /><br /> <br />
			* Preço:&nbsp;&nbsp; <input placeholder="Preço do produto" required="required" class="input-box" type="number" name="preco" value="" /><br /> <br />
			* Tipo: &nbsp;&nbsp;&nbsp;&nbsp;
			<select name="tipo" required="required"> 
			<option value="Prato">Prato</option>
			<option value="Doce">Doce</option>
			<option value="Sandes">Sandes</option>
			<option value="Salgados">Salgados</option>
			<option value="Bebida sem alcool">Bebida sem alcool</option>
			<option value="Bebida com alcool">Bebida com alcool</option>
			</select><br /> <br />
			* Activo:&nbsp; Sim<input type="radio" name="activo" value="true" checked="checked"> Não<input class="input-box" type="radio" name="activo" value="false" /><br /> <br /> 
			<input class="button" name="guardar" type="submit" value="Salvar" />
			
			<!-- <input type="reset" value="Limpar Campos" name="limpar" class="button"> -->
		</form>
	</div>
</body>
</html>