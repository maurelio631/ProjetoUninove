package br.com.GerenciadorDeProdutos.factory;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/produto";

	public static Connection createConnectionToMySql() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection conn = createConnectionToMySql();
		if (conn != null) {
			System.out.println("Conexão obtida com sucesso");
			conn.close();
		}
	}
	
}