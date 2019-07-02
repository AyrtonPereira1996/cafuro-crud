package com.servlet.dto;

import java.util.Date;

public class Produto {
	private int id;
	private String nome;
	private double preco;
	private String tipo;
	private boolean activo;
	private Date criadoEm;
	
	


	public Produto(int id, String nome, double preco, String tipo, boolean activo) {
		super();
		this.id = id;
		this.nome=nome;
		this.preco = preco;
		this.tipo = tipo;
		this.activo=activo;
	}
	
	public Produto() {
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Date getCriadoEm() {
		return criadoEm;
	}
	
	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
