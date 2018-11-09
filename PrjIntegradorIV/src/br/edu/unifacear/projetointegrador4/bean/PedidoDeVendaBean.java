package br.edu.unifacear.projetointegrador4.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.Cliente;
import br.edu.unifacear.projetointegrador4.model.entity.Peca;
import br.edu.unifacear.projetointegrador4.model.entity.PedidoDeVenda;

@ManagedBean(name = "pedidoVendaBean")
@RequestScoped
public class PedidoDeVendaBean {
	private static PedidoDeVenda pdv;
	private List<PedidoDeVenda> listapdv;
	private List<Peca> listaPeca;
	private Peca peca;
	private FacadeBusiness facade;
	private Cliente cliente;
	private PecaBean pBean;

	public PedidoDeVendaBean() {
		System.out.println("entrou PDV Bean");
		pdv = new PedidoDeVenda();
		listapdv = new ArrayList<PedidoDeVenda>();
		listaPeca = new ArrayList<Peca>();
		peca = new Peca();
		cliente = new Cliente();
		peca = pBean.getPeca();
		System.out.println("Loucura Loucura Loucura: "+pBean.getPeca().getDescricao());
		
	}

	public PedidoDeVendaBean(PedidoDeVenda pdv, List<PedidoDeVenda> listapdv, List<Peca> listaPeca, Peca peca) {
		super();
		this.pdv = pdv;
		this.listapdv = listapdv;
		this.listaPeca = listaPeca;
		this.peca = peca;
		listarPecas();
		
	}

	public String adicionarCarrinho() {

		try {
			if (listaPeca.size() != 0 || listaPeca != null) {
				System.out.println("Inseriu pedido de venda");
				pdv.setPeca(listaPeca);
				facade.inserirPedidoDeVenda(pdv);
				return "sucesso";
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "falha";
		}
		return "pdv";	
	}

	public String addPeca() {
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println("Entrou add Peca");
		Long aux = new CadastroClienteBean().getLogin().getId();
		if (aux != null) {
			
			System.out.println("entrou if add peca");
			listaPeca.add(peca);
			System.out.println("ADD peca: "+peca.getDescricao());
			peca = new Peca();
		} else {
			System.out.println("entrou else add peca");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Necess�rio Realizar Login", null);
			pdv = new PedidoDeVenda();
		}
		return "addPeca";
	}

	public void listarPecas() {
		Long aux = new CadastroClienteBean().getLogin().getId();
		try {
			if (aux != null) {
				System.out.println("Trouxe pedido de venda");
				pdv = facade.obterPedidoDeVenda(aux);
			} else {
				pdv = new PedidoDeVenda();
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Peca getPeca() {
		System.out.println("Get peca: "+peca.getId());
		return peca;
	}

	public void setPeca(Peca peca) {
		System.out.println("Set peca: "+peca.getId());
		this.peca = peca;
	}

	public PedidoDeVenda getPdv() {
		return pdv;
	}

	public void setPdv(PedidoDeVenda pdv) {
		this.pdv = pdv;
	}

	public List<PedidoDeVenda> getListapdv() {
		return listapdv;
	}

	public void setListapdv(List<PedidoDeVenda> listapdv) {
		this.listapdv = listapdv;
	}

	public List<Peca> getListaPeca() {
		return listaPeca;
	}

	public void setListaPeca(List<Peca> listaPeca) {
		this.listaPeca = listaPeca;
	}

}