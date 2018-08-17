package br.edu.unifacear.projetointegrador4.entity;

public class Telefone {
	private String cpf;
	private Long telefone;
	
	public Telefone() {}

	public Telefone(String cpf, Long telefone) {
		super();
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	
}
