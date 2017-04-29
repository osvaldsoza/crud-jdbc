package br.com.osfdeveloper.crud.jdbc.connection;

import java.sql.SQLException;

public class TestaConnection {

	public static void main(String[] args) {
		try {
			new ConnectionPool().getConnection();
			System.out.println("ok");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
