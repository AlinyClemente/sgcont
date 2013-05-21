package com.sgcont.repositorio;

import org.hibernate.Session;

import com.sgcont.dados.operacional.TipoDespesa;
import com.sgcont.dados.operacional.TipoReceita;
import com.sgcont.util.HibernateUtil;

/**
 * Reposit�rio respons�vel pelas consultas do m�dulo operacional
 * */
public class RepositorioOperacional implements IRepositorioOperacional {

	private static IRepositorioOperacional instance;

	public static IRepositorioOperacional getInstancia() {
		if (instance == null) {
			instance = new RepositorioOperacional();
		}
		return instance;
	}

	/**
	 * [UC013] Inserir Despesa
	 * 
	 * M�todo respons�vel pesquisar um tipo de despesa a partir da descri��o
	 * 
	 * @author Vivianne Sousa
	 * @since 13/05/2013
	 * 
	 * @param descri��o
	 * @return TipoDespesa
	 * */
	public TipoDespesa pesquisarTipoDespesa(String descricao) {
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT tpDe "
				+ " FROM TipoDespesa tpDe "
				+ " WHERE tpDe.descricao = :descricao ";
		
		TipoDespesa tipoDespesa = 
				(TipoDespesa) session
					.createQuery(consulta)
	                .setParameter("descricao", descricao)
	                .uniqueResult();

		HibernateUtil.closeSession(session);
		
		return tipoDespesa;
				
	}
	
	/**
	 * [UC011] Inserir Receita
	 * 
	 * M�todo respons�vel pesquisar um tipo de receita a partir do nome
	 * 
	 * @author R�mulo Aur�lio
	 * @since 13/05/2013
	 * 
	 * @param nome
	 * @return TipoReceita
	 * */
	public TipoReceita pesquisarTipoReceita(String descricao) {
		
		Session session = HibernateUtil.getSession();
		
		String consulta = "SELECT tipoReceita "
				+ " FROM TipoReceita tipoReceita "
				+ " WHERE tipoReceita.descricao = :descricao ";
		
		TipoReceita tipoReceita = 
				(TipoReceita) session
					.createQuery(consulta)
	                .setParameter("descricao", descricao)
	                .uniqueResult();

		HibernateUtil.closeSession(session);
		
		return tipoReceita;
				
	}
}
