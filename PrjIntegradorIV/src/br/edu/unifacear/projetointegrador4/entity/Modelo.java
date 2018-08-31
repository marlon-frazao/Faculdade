package br.edu.unifacear.projetointegrador4.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.edu.unifacear.projetointegrador4.dao.DAO;

@Entity
public class Modelo implements DAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	@ManyToOne
	private Montadora montadora;
	@ManyToOne
	private LinhaDeVeiculo linha;
	private Integer ano;
	private Boolean status;
	
	@ManyToMany(mappedBy = "modelo")
	private List<Peca> pecas;
	
	public Modelo() {}

	
	public Modelo(Long id, String descricao, Montadora montadora, LinhaDeVeiculo linha, Integer ano, Boolean status
			, List<Peca> pecas) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.montadora = montadora;
		this.linha = linha;
		this.ano = ano;
		this.status = status;
		this.pecas = pecas;
	}


	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Montadora getMontadora() {
		return montadora;
	}

	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

	public LinhaDeVeiculo getLinha() {
		return linha;
	}

	public void setLinha(LinhaDeVeiculo linha) {
		this.linha = linha;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Boolean getStatus() {
		return status;
	}
	@Override
	public void setStatus(Boolean status) {
		this.status = status;
	}


	public List<Peca> getPecas() {
		return pecas;
	}


	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}
	
	
}
