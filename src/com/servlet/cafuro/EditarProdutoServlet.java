package com.servlet.cafuro;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.Produto;
import com.servlet.servico.ProdutoService;

/**
 * Servlet implementation class EditarProdutoServlet
 */
@WebServlet("/editarProduto")
public class EditarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProdutoService ps = new ProdutoService();
	Produto p = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Produto p = ps.buscarPorCodigo(id);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editarProduto.jsp");
		request.setAttribute("produtoEncontrado", p);
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		double preco= Double.parseDouble(request.getParameter("preco"));
		String tipo = request.getParameter("tipo");
		boolean activo = Boolean.parseBoolean(request.getParameter("activo"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		ps.editarProduto(id, nome, preco, tipo, activo);
		System.out.println("Chegou aqui");
		response.sendRedirect("listaProduto");
	
	}

}
