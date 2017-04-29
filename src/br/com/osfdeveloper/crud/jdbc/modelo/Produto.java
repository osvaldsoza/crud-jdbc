package br.com.osfdeveloper.crud.jdbc.modelo;

public class Produto {
	
	private Integer id;
	private String nome;
	private String descricao;
	
	public Produto(String nome, String descricao){
		
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		
		return String.format("[produto:] %d - %s - %s", id,nome, descricao);
	}
	
	
}
