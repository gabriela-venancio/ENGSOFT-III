package Controller;

import java.sql.SQLException;
import java.util.List;

import DAO.DAOAgendarSala;
import Entity.AgendaSalaBuilder;
import Entity.AgendarSala;
import Persistence.PersistenceAgendaSala;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AgendarSalaController {

	private DAOAgendarSala  daoAgendarSala = new PersistenceAgendaSala();

	private ObservableList<AgendarSala> agendarSalas = FXCollections.observableArrayList();
	private TableView<AgendarSala> tableAgendarSala = new TableView<>();

	
	private StringProperty motivo = new SimpleStringProperty();
	private StringProperty responsavel = new SimpleStringProperty();
	private StringProperty data = new SimpleStringProperty();
	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty setor = new SimpleStringProperty();
	private StringProperty tempoOcupada = new SimpleStringProperty();

	
	
	public AgendarSala getEntityAgendarSala() throws SQLException{
		AgendarSala a = new AgendarSala();
		
		a.setMotivo(motivo.get().toLowerCase());
		a.setResponsavel(responsavel.get().toLowerCase());
		a.setData(data.get().toLowerCase());
		a.setCpf(cpf.get().toLowerCase());
		a.setSetor(setor.get().toLowerCase());
		a.setTempoOcupada(tempoOcupada.get().toLowerCase());
		
		return a;
	}
	
	 public void setEntityAgendarSala(AgendarSala as)throws SQLException {
	        if (as != null) {
	            motivo.set(as.getMotivo());
	           responsavel.set(as.getResponsavel());
	           data.set(as.getData());
	           cpf.set(as.getCpf());
	           setor.set(as.getSetor()); 
	           tempoOcupada.set(as.getTempoOcupada());
	           
	           
	        }
	    }
	 
		
	public void limpar() {
		motivo.setValue("");
		responsavel.setValue("");
		data.setValue("");
		cpf.setValue("");
		setor.setValue("");
		tempoOcupada.setValue("");
		
		
	}
	
	public String getMotivo() {
		return motivo.get();
	}
	
	public StringProperty motivoProperty() {
		return motivo;
	}
	
	public String getResponsavel() {
		return responsavel.get();
	}
	public StringProperty responsavelProperty() {
		return responsavel;
	}
	
	public String getData() {
		return data.get();
		
	}
	
	public StringProperty dataProperty() {
		return data;
	}
	public String getCPF() {
		return cpf.get();
		
	}
	
	public StringProperty CPFProperty() {
		return cpf;
	}
	public String getSetor() {
		return setor.get();
		
	}
	
	public StringProperty SetorProperty() {
		return setor;
	}

	public String gettempoO() {
		return tempoOcupada.get();
		
	}
	
	public StringProperty tempoOProperty() {
		return tempoOcupada;
	}

	        
	 @SuppressWarnings("unchecked")
	public AgendarSalaController() {
	     
		 TableColumn<AgendarSala, String> col1 = new TableColumn<>("Motivo");
		 col1.setCellValueFactory(new PropertyValueFactory<>("motivo"));
		 
		 TableColumn<AgendarSala, String> col2 = new TableColumn<>("Responsavel");
	        col2.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
	        
			 TableColumn<AgendarSala, String> col3 = new TableColumn<>("Data");
	        col3.setCellValueFactory(new PropertyValueFactory<>("data"));
	        
	        
	        TableColumn<AgendarSala, String> col4 = new TableColumn<>("setor");
	        col4.setCellValueFactory(new PropertyValueFactory<>("setor"));

	        
	        
	        TableColumn<AgendarSala, String> col5 = new TableColumn<>("tempoOcupada");
	        col5.setCellValueFactory(new PropertyValueFactory<>("tempoOcupada"));

	        
	        
	        TableColumn<AgendarSala, String> col6 = new TableColumn<>("cpf");
	        col6.setCellValueFactory(new PropertyValueFactory<>("cpf"));

	        

	        
	        
	        
	        tableAgendarSala.getColumns().addAll( col1, col2, col3,col4,col5,col6);
	        
	        col1.setPrefWidth(190);
			col2.setPrefWidth(190);
			col3.setPrefWidth(190);
			col4.setPrefWidth(190);
			col5.setPrefWidth(190);
			col6.setPrefWidth(190);

				
	        
	        tableAgendarSala.setItems(agendarSalas);

	        tableAgendarSala.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	    }
	
	
	

	public void adicionar() throws SQLException {
		AgendarSala as = AgendaSalaBuilder.builder()
		.addDadosPessoais(responsavel.get(), data.get(), setor.get(), motivo.get(), getMotivo(), responsavel.get())
		.get();
		
		agendarSalas.add(as);
        daoAgendarSala.adicionar(as);
        limpar();
		
	}
	public void atualiza() throws SQLException {
		AgendarSala as = new AgendarSala();
		daoAgendarSala.atualiza(as);
		limpar();
	}

	
	public void remover() throws SQLException {
		AgendarSala as = new AgendarSala();
		daoAgendarSala.remove(as);
		limpar();
	}
	
	public void pesquisarPorNome() throws SQLException {
		 List<AgendarSala> asListPesquisa = daoAgendarSala.pesquisarPorNome(responsavel.get());
	       
	        agendarSalas.clear();
	        agendarSalas.addAll(asListPesquisa);
	       limpar();
	    }
	public TableView<AgendarSala> getTable() {
        return tableAgendarSala;
    }
	
	
}
