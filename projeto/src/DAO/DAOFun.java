package DAO;

import java.sql.SQLException;
import java.util.List;

import Entity.Funcionario;

public interface DAOFun {


	void adicionar(Funcionario f)throws SQLException;
	
	List<Funcionario> pesquisarPorNome(String string)throws SQLException;
	
	void remove(Funcionario funcionario)throws SQLException;
	
	void atualiza (Funcionario funcionario)throws SQLException;
	
}
