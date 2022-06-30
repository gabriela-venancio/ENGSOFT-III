package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import DAO.DAOVisitante;
import Entity.AgendarSala;
import Entity.Visitante;

public class PersistenceVisita implements DAOVisitante{
private SessionFactory sf;
	
	public PersistenceVisita(SessionFactory sf) {
		this.sf = sf;
	}
	public PersistenceVisita() {
		
	}

	@Override
	public void adicionar(Visitante v) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(v);
		transaction.commit();
	}

	@Override
	public void atualiza(Visitante v ) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(v);
		transaction.commit();
	}

	@Override
	public void remove(Visitante v ) throws SQLException {
		String sql = "DELETE FROM visita WHERE cpf = ?";
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, v.getCpf());
		query.executeUpdate();
		transaction.commit();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Visitante> pesquisarPorNome(String vs)throws SQLException {
		List<Visitante> v = new ArrayList<Visitante>();
		String sql = "SELECT * FROM visita WHERE cpf = ?";
		EntityManager entityManager = sf.createEntityManager();
		vs = entityManager.find(AgendarSala.class, vs);
		Query query = entityManager.createNativeQuery(sql);
		List<Object[]> listVisitante = query.getResultList();
		for (Object[] linha : listVisitante) {
			Visitante v1 = new Visitante();
			v1.setCpf(linha[1].toString());
			v1.setMotivo(linha[2].toString());
			v1.setDataAtual(linha[3].toString());
			v1.setDestino(linha[4].toString());
			v1.setNome(linha[5].toString());
			v1.setTelefone(linha[6].toString());
			v1.setId(linha[7].toString());

		
			
			v.add(v1);
		}
		return v;
	}




	


}