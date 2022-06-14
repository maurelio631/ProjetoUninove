package br.com.GerenciadorDeProdutos.model;

import java.util.Date;

public class Produto {

	public Produto() {
		
	}

	public Produto(String descricao, Date validade, String lote, double preco) {
		this.descricao = descricao;
		this.validade = validade;
		this.lote = lote;
		this.preco = preco;
	}
	
	private Integer codigo;
	private String descricao;
	private Date validade;
	private String lote;
	private double preco;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
