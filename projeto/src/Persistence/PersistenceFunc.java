package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import DAO.DAOFun;
import Entity.AgendarSala;
import Entity.Chaves;
import Entity.Funcionario;

public class PersistenceFunc implements DAOFun{

	private SessionFactory sf;
	
	public PersistenceFunc(SessionFactory sf) {
		this.sf = sf;
	}
	public PersistenceFunc() {
		
	}

	@Override
	public void adicionar(Funcionario  f) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(f);
		transaction.commit();
	}

	@Override
	public void atualiza(Funcionario f) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(f);
		transaction.commit();
	}

	@Override
	public void remove(Funcionario f) throws SQLException {
		String sql = "DELETE FROM Funcionario WHERE cpf = ?";
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, f.getCpf());
		query.executeUpdate();
		transaction.commit();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> pesquisarPorNome(String f1)throws SQLException {
		List<Funcionario> f = new ArrayList<Funcionario>();
		String sql = "SELECT * FROM Funcionario WHERE cpf = ?";
		EntityManager entityManager = sf.createEntityManager();
		f = entityManager.find(Funcionario.class, f1);
		Query query = entityManager.createNativeQuery(sql);
		List<Object[]> listFuncioanrio = query.getResultList();
		for (Object[] linha : listFuncioanrio) {
			Funcionario f2 = new Funcionario();
			f2.setCpf(linha[1].toString());
			f2.setCargo(linha[2].toString());
			f2.setIds(linha[3].toString());
			f2.setNome(linha[4].toString());
			f2.setRamal(linha[5].toString());
			f2.setSetor(linha[6].toString());
			f2.setTelefone(linha[7].toString());
			
		
			
			f.add(f2);
		}
		return f;
	}

}
