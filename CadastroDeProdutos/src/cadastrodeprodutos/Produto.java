package cadastrodeprodutos;

import java.sql.Connection;

import util.Conexao;

public class Produto {
	private String codProduto;
	private String nomeProduto;
	private double precoProduto;
	
	public Produto(String codProduto, String nomeProduto, double precoProduto) {
		this.codProduto   = codProduto;
		this.nomeProduto  = nomeProduto;
		this.precoProduto = precoProduto;
	}

	
	public void incluirProduto() {
		String sql = "INSERT INTO produto VALUES (?,?,?); ";
		Connection con = Conexao.conectar();
	}
	
	
	
	public void exibir_Informacoes() {
		System.out.println("Codigo..........: " + this.codProduto);
		System.out.println("Nome............: " + this.nomeProduto);
		System.out.println("Preco...........: " + this.precoProduto);
	}

	public String getCodProduto() {
		return codProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	
	
	
	

}
