package br.com.osfdeveloper.crud.jdbc.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.osfdeveloper.crud.jdbc.connection.ConnectionPool;
import br.com.osfdeveloper.crud.jdbc.dao.ProdutosDAO;
import br.com.osfdeveloper.crud.jdbc.modelo.Produto;

public class ProdutoMain {

	public static void main(String[] args){
		//insert();
		lista();
	}
	
	public static void insert(){
		
		Produto mesa = new Produto("Bicicleta Caloi", "Bicicleta Caloi 12 marchas");
		
		try (Connection connection = new ConnectionPool().getConnection()) {
			ProdutosDAO produtosDAO = new ProdutosDAO(connection);
			produtosDAO.salva(mesa);
			System.out.println("Novo produto inserido com sucesso.");
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}
	
	public static void lista(){
		try(Connection conn = new ConnectionPool().getConnection()){
			
			ProdutosDAO produtosDAO = new ProdutosDAO(conn);
			
			List<Produto> produtos = produtosDAO.lista();
			
			for (Produto produto : produtos) {
				System.out.println(produto);
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}

}
