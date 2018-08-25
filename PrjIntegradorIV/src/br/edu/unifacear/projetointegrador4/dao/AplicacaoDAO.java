package br.edu.unifacear.projetointegrador4.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.entity.Aplicacao;

public class AplicacaoDAO implements DAO<Aplicacao> {
	
	@Override
	public void inserir (Aplicacao aplicacao) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			
			if(aplicacao.getId()==null) {
				em.persist(aplicacao);
			}else {
				em.merge(aplicacao);
			}
			
			em.getTransaction().commit();
			
		}catch(Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}
	
	@Override
	public Aplicacao obter(Long id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Aplicacao aplicacao = null;
		
		try {
			
			aplicacao = em.find(Aplicacao.class, id);
			
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return aplicacao;
	}
	
	
	public List<Aplicacao> obter(String descricao){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Aplicacao> lista = null;		
		try {
			lista = em.createQuery("from Aplicacao WHERE descricao like '"+descricao+"'").getResultList();
			
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}
	
	@Override
	public List<Aplicacao> listar(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Aplicacao> lista = null;
		
		try {
			lista = em.createQuery("from Aplicacao").getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}

	@Override
	public void atualizar(Aplicacao a) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();

			em.merge(a);

			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);

			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public void excluir(Aplicacao a) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		a.setStatus(false);
		
		try {
			em.getTransaction().begin();

			em.merge(a);

			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);

			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}

}