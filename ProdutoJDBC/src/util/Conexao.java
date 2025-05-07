package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String URL = "jdbc:mysql://localhost:3306/produto";
	private static final String USER = "produto";
	private static final String PASSWORD = "produto";
	
	public static Connection conectar() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException erro) {
			System.out.println("Assinatura do driver não confere " + erro);
			System.exit(0);		
		}
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException erro) {
			System.out.println("Problemas na conexão com o banco de dados " + erro);
		}
		return con;
		
	}
}
