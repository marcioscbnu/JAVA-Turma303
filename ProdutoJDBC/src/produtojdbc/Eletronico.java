package produtojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import util.Conexao;

public class Eletronico extends Produto {
	private String marcaEletronico;
	private int    garantiaMeses;
	
	public Eletronico() {
		
	}
	
	public Eletronico(String codProduto, String nomeProduto, double precoProduto, 
			          String marcaEletronico,int garantiaMeses) {
		super(codProduto, nomeProduto, precoProduto);
		this.marcaEletronico = marcaEletronico;
		this.garantiaMeses = garantiaMeses;
	}
	
	public boolean incluirProduto() {
		Connection con = Conexao.conectar();
/*
		// Incluindo Produto - inicio
		String sql = "INSERT INTO produto values (?,?,?); ";		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, this.codProduto);
			stm.setString(2, this.nomeProduto);
			stm.setDouble(3, this.precoProduto);
			stm.execute();
		} catch (Exception e){
			if (e instanceof SQLIntegrityConstraintViolationException) {
				System.out.println("Produto"
						+ ""
						+ ""
						+ ""
						+ ""
						+ " Duplicado ! Verifique");	
				return false;
			} else if (e instanceof SQLException) {
				System.out.println("Problemas ao inserir Produto ");
				return false;
			}
			
		}

		// Incluindo Produto - termino
					*/	
		return true;	

	}
	
	
	public List<Produto> listarProdutos(){
		List<Produto> lstProd = new ArrayList<>();
		Connection con = Conexao.conectar();
		lstProd = null;
		// Listar os Produtos - inicio
		String sql = "SELECT a.CODPRODUTO, a.NOMEPRODUTO, a.PRECOPRODUTO FROM produto a;";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Produto p = new Produto();
				p.setCodProduto(rs.getString("CODPRODUTO"));
				p.setNomeProduto(rs.getString("NOMEPRODUTO"));
				p.setPrecoProduto(rs.getDouble("PRECOPRODUTO"));
				lstProd.add(p);
			}
		} catch (Exception e){
				System.out.println("Problemas ao listar os Produtos");
		}
		return lstProd;
	}

	public Produto consultaProduto(){
		Connection con = Conexao.conectar();
		Produto p = new Produto();
		p = null;
		// Listar os Produtos - inicio
		String sql  = "SELECT a.CODPRODUTO, a.NOMEPRODUTO, a.PRECOPRODUTO ";
		       sql += "from produto a ";
		       sql += "where codproduto = ? ";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, super.getCodProduto());
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				p = new Produto();
				p.setCodProduto(rs.getString("CODPRODUTO"));
				p.setNomeProduto(rs.getString("NOMEPRODUTO"));
				p.setPrecoProduto(rs.getDouble("PRECOPRODUTO"));
			}
		} catch (Exception e){
				System.out.println("Problemas ao consultar o produto");
		}
		return p;
	}


	public String getMarcaEletronico() {
		return marcaEletronico;
	}

	public int getGarantiaMeses() {
		return garantiaMeses;
	}
	
	
	
	
}
