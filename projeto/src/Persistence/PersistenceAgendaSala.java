package Persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import DAO.DAOAgendarSala;
import Entity.AgendarSala;

public class PersistenceAgendaSala implements DAOAgendarSala{

	private SessionFactory sf;
	
	public PersistenceAgendaSala(SessionFactory sf) {
		this.sf = sf;
	}

	public PersistenceAgendaSala() {
		
	}
	
	@Override
	public void adicionar(AgendarSala as) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(as);
		transaction.commit();
	}

	@Override
	public void atualiza(AgendarSala as) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(as);
		transaction.commit();
	}

	@Override
	public void remove(AgendarSala as) throws SQLException {
		String sql = "DELETE FROM salavideo WHERE cpf = ?";
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, as.getCpf());
		query.executeUpdate();
		transaction.commit();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AgendarSala> pesquisarPorNome(String as)throws SQLException {
		List<AgendarSala> a = new ArrayList<AgendarSala>();
		String sql = "SELECT * FROM salavideo WHERE cpf = ?";
		EntityManager entityManager = sf.createEntityManager();
		as = entityManager.find(AgendarSala.class, as);
		Query query = entityManager.createNativeQuery(sql);
		List<Object[]> listAgendarSala = query.getResultList();
		for (Object[] linha : listAgendarSala) {
			AgendarSala as1 = new AgendarSala();
			as1.setCpf(linha[1].toString());
			as1.setMotivo(linha[2].toString());
			as1.setData(linha[3].toString());
			as1.setResponsavel(linha[4].toString());
			as1.setSetor(linha[5].toString());
			as1.setTempoOcupada(linha[6].toString());
		
			
			a.add(as1);
		}
		return a;
	}




	


}