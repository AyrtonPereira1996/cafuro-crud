package com.servlet.servico;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.servlet.dao.ComumDAO;
import com.servlet.dto.Produto;

import net.sf.jasperreports.engine.JasperFillManager;

public class ProdutoService {

	public void adicionarProduto(String nome, double preco, String tipo, boolean activo) {
		try {
			Connection con = ComumDAO.getConnection();
			Statement stmt = con.createStatement();
			stmt.execute("insert into produto(nome, preco, tipo, activo) values('" + nome + "', "
					+ preco + ", '" + tipo + "', " + activo + ")");
			System.out.println("Produto registado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao tentar registar o producto");
			e.printStackTrace();
		}
	}
	
	public void editarProduto(int id,String nome, double preco, String tipo, boolean activo) {
		try {
			Connection con = ComumDAO.getConnection();
			Statement stmt = con.createStatement();
			stmt.execute("update produto set nome='" + nome + "', preco=" +preco+ ", tipo='"+tipo+"', activo ="+activo+" where id="+id);
			System.out.println("Produto actualizado com sucesso");
			stmt.close();
		} catch (Exception e) {
			System.out.println("Erro ao tentar editar o produto");
			e.printStackTrace();
		}
	}

	public List<Produto> ListarProdutos() {
		List<Produto> l = new ArrayList<Produto>();
		try {
			Connection con = ComumDAO.getConnection();
			Statement stmt = con.createStatement();
			stmt.execute("select * from produto");
			ResultSet resultSet = stmt.getResultSet();

			while (resultSet.next()) {
				Produto p = new Produto(resultSet.getInt("id"), resultSet.getString("nome"),
						resultSet.getDouble("preco"), resultSet.getString("tipo"), resultSet.getBoolean("activo"));
				l.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return l;

	}

	public void ExcluirProduto(int id) {
		try {

			Connection con = ComumDAO.getConnection();
			Statement stmt = con.createStatement();
			stmt.execute("delete from produto where id= " + id);
			System.out.println("Produto excluido com sucesso!");
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Erro ao tentar excluir o produto");
			e.printStackTrace();
		}

	}

	public Produto buscarPorCodigo(int id) {
		Connection con = ComumDAO.getConnection();
		Produto p = null;
		
		try {
			Statement stmt = con.createStatement();
			stmt.execute("select * from produto where id = " + id);
			ResultSet resultado = stmt.getResultSet();
			resultado.next();
			p = new Produto(resultado.getInt("id"), resultado.getString("nome"), resultado.getDouble("preco"), resultado.getString("tipo"), resultado.getBoolean("activo"));
			resultado.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println("Erro ao tentar excluir produto");
			e.printStackTrace();
		}
		return p;
	}
	


}
