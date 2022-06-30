package DAO;

import java.sql.SQLException;
import java.util.List;

import Entity.AgendarSala;

public interface DAOAgendarSala {


	List<AgendarSala> pesquisarPorNome(String string)throws SQLException;

	void adicionar(AgendarSala as)throws SQLException;
	
	void remove(AgendarSala as)throws SQLException;
		
	void atualiza (AgendarSala as)throws SQLException;
}
