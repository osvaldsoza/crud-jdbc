package br.com.osfdeveloper.crud.jdbc.connection;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionPool {
		
	private static final String URL = "jdbc:mysql://localhost:3306/cad_produto";
	private static final String USER = "root";
	private static final String PASSWORD = "osf77";
	
	private MysqlDataSource dataSource;
	
	public ConnectionPool(){
		this.dataSource = new MysqlDataSource();
		this.dataSource.setURL(URL);
		this.dataSource.setUser(USER);
		this.dataSource.setPassword(PASSWORD);
	}
	
	public Connection getConnection() throws SQLException{		
		Connection connection = this.dataSource.getConnection();
		//Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
		return connection;
	}	
}
