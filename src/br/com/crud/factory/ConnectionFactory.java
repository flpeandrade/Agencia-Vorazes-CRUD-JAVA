package br.com.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
		
	private static String url = "jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=PacotesJava;";
		
		public static Connection createConnectionSQLServer() throws Exception {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			
			Connection connection = DriverManager.getConnection(url);
			
			return connection;
		} 
		
		public static void main(String[] args) throws Exception{
			
			Connection con = createConnectionSQLServer();
			
			if (con != null) {
				System.out.println("Conexão obtida com sucesso! " + con);
				con.close();
			}
		}
}
