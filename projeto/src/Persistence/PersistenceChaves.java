package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import DAO.DAOChaves;
import Entity.AgendarSala;
import Entity.Chaves;

public class PersistenceChaves implements DAOChaves{

	private SessionFactory sf;
	
	public PersistenceChaves(SessionFactory sf) {
		this.sf = sf;
	}
	public PersistenceChaves() {
		
	}

	@Override
	public void adicionar(Chaves c) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(c);
		transaction.commit();
	}

	@Override
	public void atualiza(Chaves c) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(c);
		transaction.commit();
	}

	@Override
	public void remove(Chaves c) throws SQLException {
		String sql = "DELETE FROM Chaves WHERE data = ?";
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, c.getData());
		query.executeUpdate();
		transaction.commit();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Chaves> pesquisarPorNome(String c1)throws SQLException {
		List<Chaves> c = new ArrayList<Chaves>();
		String sql = "SELECT * FROM Chaves WHERE data = ?";
		EntityManager entityManager = sf.createEntityManager();
		c = entityManager.find(AgendarSala.class, c1);
		Query query = entityManager.createNativeQuery(sql);
		List<Object[]> listChaves = query.getResultList();
		for (Object[] linha : listChaves) {
			Chaves c2 = new Chaves();
			c2.setChave(linha[1].toString());
			c2.setData(linha[2].toString());
			c2.setId(linha[3].toString());
			c2.setResponsavel(linha[4].toString());
			
		
			
			c.add(c2);
		}
		return c;
	}

	
}
