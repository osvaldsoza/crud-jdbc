package br.com.osfdeveloper.crud.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.osfdeveloper.crud.jdbc.modelo.Produto;

public class ProdutosDAO {

	private Connection connection;

	public ProdutosDAO(Connection connection) {
		this.connection = connection;
	}

	public void salva(Produto produto) throws SQLException {

		String sql = "insert into Produto (nome, descricao) values (?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.execute();
		}
	}

	public List<Produto> lista() throws SQLException {
		List<Produto> produtos = new ArrayList<>();

		String sql = "select * from Produto";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {		
			pstm.executeQuery();
			try (ResultSet rs = pstm.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					String descricao = rs.getString("descricao");

					Produto produto = new Produto(nome, descricao);
					produto.setId(id);
					
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}
}
