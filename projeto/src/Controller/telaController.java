package Controller;

import Tela.AgendarSalaBoundary;
import Tela.ChaveBoundary;
import Tela.FuncionarioBoundary;
import Tela.VisitanteBoundary;
import javafx.stage.Stage;

public class telaController {
	AgendarSalaBoundary agendaSala = new AgendarSalaBoundary();
	ChaveBoundary chave = new ChaveBoundary();
	FuncionarioBoundary funcionario = new FuncionarioBoundary();
	VisitanteBoundary visitante= new VisitanteBoundary();
	
	
	public void acessaAgendaSala() {
		try {
			agendaSala.start(new Stage());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void acessaChave() {
		try {
			chave.start(new Stage());
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	public void acessaFuncionario() {
		try {
			funcionario.start(new Stage());
		}catch(Exception e3) {
			e3.printStackTrace();
		}
	}
	
	
	
	public void acessaVisitante() {
		try {
			visitante.start(new Stage());
		}catch(Exception e5) {
			e5.printStackTrace();
		}
	}
}
