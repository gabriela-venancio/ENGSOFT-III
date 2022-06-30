package DAO;

import java.sql.SQLException;
import java.util.List;

import Entity.Chaves;

public interface DAOChaves {

	
	void adicionar(Chaves chaves)throws SQLException;

	void remove(Chaves chaves)throws SQLException;
	void atualiza (Chaves chaves)throws SQLException;


	List<Chaves> pesquisarPorNome(String string)throws SQLException;




	
}
