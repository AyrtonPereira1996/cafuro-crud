package com.servlet.cafuro;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.servico.ProdutoService;


@WebServlet("/novoProduto")
public class NovoProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProdutoService ps = new ProdutoService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher;

		requestDispatcher = request.getRequestDispatcher("/frmNovoProduto.jsp");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		double preco= Double.parseDouble(request.getParameter("preco"));
		String tipo = request.getParameter("tipo");
		boolean activo = Boolean.parseBoolean(request.getParameter("activo"));
		
		ps.adicionarProduto(nome, preco, tipo, activo);
		
		response.sendRedirect("listaProduto");
	}

}
