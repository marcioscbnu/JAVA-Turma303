package produtojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import util.Conexao;

public class Produto {
	private String codProduto;
	private String nomeProduto;
	private double precoProduto;
	
	public Produto() {
		
	}
	
	public Produto(String codProduto, String nomeProduto, double precoProduto) {
		this.codProduto   = codProduto;
		this.nomeProduto  = nomeProduto;
		this.precoProduto = precoProduto;
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

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}

	
	
	
	
	

}
