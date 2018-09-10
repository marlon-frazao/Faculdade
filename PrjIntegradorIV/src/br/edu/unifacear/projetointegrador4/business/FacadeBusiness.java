package br.edu.unifacear.projetointegrador4.business;

import java.util.List;

import br.edu.unifacear.projetointegrador4.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.entity.Cargo;
import br.edu.unifacear.projetointegrador4.entity.LinhaDeVeiculo;
import br.edu.unifacear.projetointegrador4.entity.Montadora;
import br.edu.unifacear.projetointegrador4.entity.StatusPV;
import br.edu.unifacear.projetointegrador4.entity.TipoCliente;

public class FacadeBusiness {

	// Aplica��o
	public void inserirAplicacao(Aplicacao a) throws BusinessException {
		new AplicacaoBusiness().inserir(a);
	}

	public void atualizarAplicacao(Aplicacao a) throws BusinessException {
		new AplicacaoBusiness().atualizar(a);
	}

	public List<Aplicacao> listarAplicacao() throws BusinessException {
		return new AplicacaoBusiness().listar();
	}

	public Aplicacao obterAplicacao(Long id) throws BusinessException {
		return new AplicacaoBusiness().obter(id);
	}

	public List<Aplicacao> obterAplicacao(String descricao) throws BusinessException {
		return new AplicacaoBusiness().obter(descricao);
	}

	public void excluirAplicacao(Aplicacao a) {
		new AplicacaoBusiness().excluir(a);
	}

	// Linha de Ve�culo
	public void inserirLinhaDeVeiculo(LinhaDeVeiculo ldv) throws BusinessException {
		new LinhaDeVeiculoBusiness().inserir(ldv);
	}

	public void atualizarLinhaDeVeiculo(LinhaDeVeiculo ldv) throws BusinessException {
		new LinhaDeVeiculoBusiness().atualizar(ldv);
	}

	public List<LinhaDeVeiculo> listarLinhaDeVeiculo() {
		return new LinhaDeVeiculoBusiness().listar();
	}

	public LinhaDeVeiculo obterLinhaDeVeiculo(Long id) throws BusinessException {
		return new LinhaDeVeiculoBusiness().obter(id);
	}

	public List<LinhaDeVeiculo> obterLinhaDeVeiculo(String descricao) throws BusinessException {
		return new LinhaDeVeiculoBusiness().obter(descricao);
	}

	public void excluirLinhaDeVeiculo(LinhaDeVeiculo ldv) throws BusinessException {
		new LinhaDeVeiculoBusiness().excluir(ldv);
	}

	// Montadora
	public void inserirMontadora(Montadora m) throws BusinessException {
		new MontadoraBusiness().inserir(m);
	}

	public void atualizarMontadora(Montadora m) throws BusinessException {
		new MontadoraBusiness().atualizar(m);
	}

	public List<Montadora> listarMontadora() {
		return new MontadoraBusiness().listar();
	}

	public Montadora obterMontadora(Long id) throws BusinessException {
		return new MontadoraBusiness().obter(id);
	}

	public List<Montadora> obterMontadora(String descricao) throws BusinessException {
		return new MontadoraBusiness().obter(descricao);
	}

	public void excluirMontadora(Montadora m) throws BusinessException {
		new MontadoraBusiness().excluir(m);
	}

	// Cargo
	public void inserirCargo(Cargo c) throws BusinessException {
		new CargoBusiness().inserir(c);
	}

	public void atualizarCargo(Cargo c) throws BusinessException {
		new CargoBusiness().atualizar(c);
	}

	public List<Cargo> listarCargo() {
		return new CargoBusiness().listar();
	}

	public Cargo obterCargo(Long id) throws BusinessException {
		return new CargoBusiness().obter(id);
	}

	public List<Cargo> obterCargo(String descricao) throws BusinessException {
		return new CargoBusiness().obter(descricao);
	}

	public void excluirCargo(Cargo c) throws BusinessException {
		new CargoBusiness().excluir(c);
	}

	// StatusPV
	public void inserirStatusPV(StatusPV s) throws BusinessException {
		new StatusPVBusiness().inserir(s);
	}

	public void atualizarStatusPV(StatusPV s) throws BusinessException {
		new StatusPVBusiness().atualizar(s);
	}

	public List<StatusPV> listarStatusPV() {
		return new StatusPVBusiness().listar();
	}

	public StatusPV obterStatusPV(Long id) throws BusinessException {
		return new StatusPVBusiness().obter(id);
	}

	public List<StatusPV> obterStatusPV(String descricao) throws BusinessException {
		return new StatusPVBusiness().obter(descricao);
	}

	public void excluirStatusPV(StatusPV s) throws BusinessException {
		new StatusPVBusiness().excluir(s);
	}

	// TipoCliente
	public void inserirTipoCliente(TipoCliente tc) throws BusinessException {
		new TipoClienteBusiness().inserir(tc);
	}

	public void atualizarTipoCliente(TipoCliente tc) throws BusinessException {
		new TipoClienteBusiness().atualizar(tc);
	}

	public List<TipoCliente> listarTipoCliente() {
		return new TipoClienteBusiness().listar();
	}

	public TipoCliente obterTipoCliente(Long id) throws BusinessException {
		return new TipoClienteBusiness().obter(id);
	}

	public List<TipoCliente> obterTipoCliente(String descricao) throws BusinessException {
		return new TipoClienteBusiness().obter(descricao);
	}

	public void excluirTipoCliente(TipoCliente s) throws BusinessException {
		new TipoClienteBusiness().excluir(s);
	}
}
