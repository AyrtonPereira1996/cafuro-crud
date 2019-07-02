package com.servlet.cafuro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.Produto;
import com.servlet.servico.ProdutoService;

@WebServlet(urlPatterns = "/inicio")
public class HomeServelet extends HttpServlet {
	ProdutoService produtoService = new ProdutoService();
	String nome = "";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		if (req.getParameter("valor") != null) {
			nome = req.getParameter("valor");
		}

		List<Produto> listaProdutos = produtoService.ListarProdutos();

		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println(
				"<style>input.submit:hover{background-color:rgba(240, 230, 140, 0.719); margin:10px solid rgba(220, 20, 60, 0.719);}input.submit{border-radius:3px; border:1px solid crimson; background-color:khaki; } input.caixa{border-radius:3px;box-shadow:none;border:1px solid crimson;} a.botao{border-radius:2px; background:cadetblue;padding:2px; text-decoration:none} </style>");
		out.println("</head>");
		out.println("<body>");
		out.println(
				"<h1 style='color:crimson; text-align:center; text-shadow:0.5px 0.5px 2px rgba(48, 48, 48, 0.507);'>Bem Vindo ao Restaurante Cafuro</h1><hr> <h3 style='font-size:1em; font-weight:normal;'>Acessou: "
						+ new Date() + "</h3>");

		out.println("<div style='padding-left:8%;'><form  action='inicio' method='get'>"
				+ "<p style='font-size:1em;'>Existem " + listaProdutos.size()
				+ " produtos</p> <input class='caixa' type='text' name='valor'/> <input class='submit' type='submit' value='Pesquisar'/> </form>");
		out.println(
				"<table style='float:center;'><tr style='background-color:coral;'><th style='padding:5px;'>Nome</th><th style='padding:5px;'>Preço</th><th style='padding:5px;'>Tipo</th><th style='padding:5px;'>Ações</th></tr>");
		for (Produto p : listaProdutos) {
			if (p.getPreco() > 300) {
				out.println("<tr style='background-color: khaki;'><td>" + p.getNome()
						+ "</td><td style='background-color:crimson;'>" + p.getPreco() + "</td><td>" + p.getTipo()
						+ "</td><td><a class='botao' href='editarProduto/" + p.getId() + "'>Editar</a></td></tr>");
			} else {
				out.println("<tr  style='background-color: khaki;'><td>" + p.getNome() + "</td><td>" + p.getPreco()
						+ "</td><td>" + p.getTipo() + "</td><td><a class='botao' href='editarProduto/" + p.getId()
						+ "'>Editar</a></td></tr>");
			}

		}
		out.println("</table></div>");
		out.println("</body>");
		out.println("</html>");
	}

}
