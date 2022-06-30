package DAO;

import java.sql.SQLException;
import java.util.List;

import Entity.Visitante;

public interface DAOVisitante {
	
	

	void adicionar (Visitante visitante)throws SQLException;
	
	List<Visitante> pesquisarPorNome(String string)throws SQLException;
	void remove(Visitante visitante)throws SQLException;
	void atualiza(Visitante visitante)throws SQLException;

}