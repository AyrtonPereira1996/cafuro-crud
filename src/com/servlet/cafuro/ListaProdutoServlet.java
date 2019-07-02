package com.servlet.cafuro;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.Produto;
import com.servlet.servico.ProdutoService;


@WebServlet(urlPatterns="/listaProduto")
public class ListaProdutoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ProdutoService ps = new ProdutoService(); 

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Produto> listaProdutos = ps.ListarProdutos();
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaProdutos.jsp");
		request.setAttribute("listaProdutos", listaProdutos);
		requestDispatcher.forward(request, response);
		
	}


}
