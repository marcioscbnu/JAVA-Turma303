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
	private int garantiaMeses;

	public Eletronico() {

	}

	public Eletronico(String codProduto, String nomeProduto, double precoProduto, String marcaEletronico,
			int garantiaMeses) {
		super(codProduto, nomeProduto, precoProduto);
		this.marcaEletronico = marcaEletronico;
		this.garantiaMeses = garantiaMeses;
	}

	public boolean incluirProduto() {
		Connection con = Conexao.conectar();

		// Incluindo Produto - inicio
		String sql = "INSERT INTO produto values (?,?,?); ";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, super.getCodProduto());
			stm.setString(2, super.getNomeProduto());
			stm.setDouble(3, super.getPrecoProduto());
			stm.execute();
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				System.out.println("Produto Duplicado ! Verifique");
				return false;
			} else if (e instanceof SQLException) {
				System.out.println("Problemas ao inserir Produto ");
				return false;
			}
		}
		// Incluindo Produto - inicio
		String sql1 = "INSERT INTO eletronico values (?,?,?); ";
		try {
			PreparedStatement stm = con.prepareStatement(sql1);
			stm.setString(1, super.getCodProduto());
			stm.setString(2, this.marcaEletronico);
			stm.setDouble(3, this.garantiaMeses);
			stm.execute();
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				System.out.println("Eletronico Duplicado ! Verifique");
				return false;
			} else if (e instanceof SQLException) {
				System.out.println("Problemas ao inserir Eletronico ");
				return false;
			}
		}

		return true;

	}

	public boolean alterarProduto() {
		Connection con = Conexao.conectar();
		String  sql = "UPDATE produto p ";
				sql += "SET p.NOMEPRODUTO  = ?, ";
				sql += "    p.PRECOPRODUTO = ? ";
				sql += "WHERE p.CODPRODUTO = ? ;";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, super.getNomeProduto());
			stm.setDouble(2, super.getPrecoProduto());
			stm.setString(3, super.getCodProduto());
			stm.execute();
		} catch (SQLException e) {
			 System.out.println("Problemas ao alterar o Produto " + e);
			  return false;
		}
		
		return true;
	}

	public List<Eletronico> listarProdutos() {
		List<Eletronico> lstProd = new ArrayList<>();
		Connection con = Conexao.conectar();

		// Listar os Produtos - inicio
		String sql = "SELECT p.CODPRODUTO, p.NOMEPRODUTO, p.PRECOPRODUTO, e.MARCA, e.GARANTIAMESES ";
		sql += "FROM produto p ";
		sql += "INNER join eletronico e ";
		sql += "ON p.CODPRODUTO = e.CODPRODUTO ";
		sql += "ORDER BY p.CODPRODUTO;";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Eletronico e = new Eletronico();
				e.setCodProduto(rs.getString("CODPRODUTO"));
				e.setNomeProduto(rs.getString("NOMEPRODUTO"));
				e.setPrecoProduto(rs.getDouble("PRECOPRODUTO"));
				e.setMarca(rs.getString("MARCA"));
				e.setGarantiaMeses(rs.getInt("GARANTIAMESES"));
				lstProd.add(e);
			}
		} catch (Exception e) {
			System.out.println("Problemas ao listar os Produtos " + e);
		}
		return lstProd;
	}

	public Produto consultaProduto(String pProd) {
		Connection con = Conexao.conectar();
		Produto p = new Produto();
		p = null;
		// Listar os Produtos - inicio
		String sql = "SELECT a.CODPRODUTO, a.NOMEPRODUTO, a.PRECOPRODUTO ";
		sql += "from produto a ";
		sql += "where codproduto = ? ";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, pProd);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				p = new Produto();
				p.setCodProduto(rs.getString("CODPRODUTO"));
				p.setNomeProduto(rs.getString("NOMEPRODUTO"));
				p.setPrecoProduto(rs.getDouble("PRECOPRODUTO"));
			}
		} catch (Exception e) {
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

	public void setMarca(String marcaEletronico) {
		this.marcaEletronico = marcaEletronico;
	}

	public void setGarantiaMeses(int garantiaMeses) {
		this.garantiaMeses = garantiaMeses;
	}

}
