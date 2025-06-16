package produtojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexao;

public class Eletronico extends Produto {
	private String marca;
	private int garantia_meses;

	public Eletronico() {

	}

	public Eletronico(String codigo, String nome, double preco, String marca, int garantia_meses) {
		super(codigo, nome, preco);
		this.marca = marca;
		this.garantia_meses = garantia_meses;
	}

	public boolean incluirEletronico() throws ClassNotFoundException {
		// Inclusao na tabela Produto
		String sql1 = "INSERT INTO produto VALUES (?,?,?)";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql1);
			stm.setString(1, super.getCodigo());
			stm.setString(2, super.getNome());
			stm.setDouble(3, super.getPreco());
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro na inclusao do produto " + e);
			return false;
		}

		String sql2 = "INSERT INTO eletronico VALUES (?,?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(sql2);
			stm.setString(1, super.getCodigo());
			stm.setString(2, this.marca);
			stm.setInt(3, this.garantia_meses);
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro na inclusao do eletronico " + e);
			return false;
		}
		return true;
	}

	public boolean alterarEletronico() throws ClassNotFoundException {
		// Inclusao na tabela Produto
		String sql1 = "UPDATE produto ";
			   sql1+= "SET nomeproduto     = ? ,";
			   sql1+= "    precoproduto    = ?  ";
			   sql1+= "WHERE codigoproduto = ? ;";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql1);
			stm.setString(1, super.getNome());
			stm.setDouble(2, super.getPreco());
			stm.setString(3, super.getCodigo());			
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro na alteracao do produto " + e);
			return false;
		}

		String sql2 = "UPDATE eletronico ";
			   sql2+= "SET marcaeletronico = ? ,";
			   sql2+= "    garantiameses   = ?  ";
			   sql2+= "WHERE codigoproduto = ? ;";
		try {
			PreparedStatement stm = con.prepareStatement(sql2);
			stm.setString(1, this.marca);
			stm.setInt(2, this.garantia_meses);
			stm.setString(3, super.getCodigo());			
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro na alteracao do eletronico " + e);
			return false;
		}
		return true;
	}
	
	public boolean excluirEletronico() throws ClassNotFoundException {
		// Inclusao na tabela Produto
		String sql1 = "DELETE FROM eletronico ";
			   sql1+= "WHERE codigoproduto = ? ;";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql1);
			stm.setString(1, super.getCodigo());			
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro na exclusao do eletronico " + e);
			return false;
		}

		String sql2 = "DELETE FROM produto ";
			   sql2+= "WHERE codigoproduto = ? ;";
		try {
			PreparedStatement stm = con.prepareStatement(sql2);
			stm.setString(1, super.getCodigo());			
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro na exclusao do produto " + e);
			return false;
		}
		return true;
	}
	
	public Produto consultarProduto(String pCodigo) throws ClassNotFoundException {
		Produto p1 = new Produto();
		String  sql = "select codigoproduto,nomeproduto,precoproduto ";
				sql+= "from produto ";
				sql+= "where codigoproduto = ?";
		// conectando o banco de dados
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, pCodigo);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				p1 = new Produto();
				p1.setCodigo(rs.getString("codigoproduto"));
				p1.setNome(rs.getString("nomeproduto"));
				p1.setPreco(rs.getDouble("precoproduto"));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao consultar dados do Produto " + erro);
			return null;
		}

		return p1;
	}

	public List<Produto> listarProdutos() throws ClassNotFoundException {
		// criando a minha list que vai conter os dados do BD
		List<Produto> lstProd = new ArrayList<>();
		// comando de extração do banco de dados
		String sql = "select codigoproduto,nomeproduto,precoproduto ";
		sql += "from produto ";
		sql += "order by codigoproduto";
		// conectando o banco de dados
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Produto p1 = new Produto();
				p1.setCodigo(rs.getString("codigoproduto"));
				p1.setNome(rs.getString("nomeproduto"));
				p1.setPreco(rs.getDouble("precoproduto"));
				lstProd.add(p1);
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao listar dados do Produto " + erro);
			return null;
		}

		return lstProd;
	}

	public void exibir_informacoes() {
		super.exibir_informacoes();
		System.out.println("Marca.........: " + this.marca);
		System.out.println("Garantia......: " + this.garantia_meses);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getGarantia_meses() {
		return garantia_meses;
	}

	public void setGarantia_meses(int garantia_meses) {
		this.garantia_meses = garantia_meses;
	}

}
