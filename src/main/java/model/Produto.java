package model;

public class Produto {

	private int id_produto;
	private String descricao;
	private int quantidade;
	private double preco;
	private boolean online;
	
	public Produto() {
		
	}
		
	public Produto(String descricao, int quantidade, double preco, boolean online) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.online = online;
	}

	public Produto(int id_produto, String descricao, int quantidade, double preco, boolean online) {
		this.id_produto = id_produto;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.online = online;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}
	
	
}
