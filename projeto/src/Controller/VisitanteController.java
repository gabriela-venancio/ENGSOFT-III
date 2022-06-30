package Controller;

import java.sql.SQLException;
import java.util.List;

import DAO.DAOVisitante;
import Entity.VisistanteBuilder;
import Entity.Visitante;
import Persistence.PersistenceVisita;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VisitanteController {

	//nome/cpf/destino
	
	private DAOVisitante daovis= new PersistenceVisita();
	private ObservableList<Visitante> v = FXCollections.observableArrayList();
	    private TableView<Visitante> tabelav = new TableView<>();
	
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty destino = new SimpleStringProperty();
	private StringProperty id = new SimpleStringProperty();
	private StringProperty dataAtual = new SimpleStringProperty();
	private StringProperty motivo = new SimpleStringProperty();
	private StringProperty telefone = new SimpleStringProperty();

	
	

	
	
  
 @SuppressWarnings("unchecked")
 public VisitanteController() {
	 
	    TableColumn<Visitante, String> col1 = new TableColumn<>("Nome");
	    col1.setCellValueFactory(new PropertyValueFactory<>("nome"));
	 
	    
	    TableColumn<Visitante, String> col2 = new TableColumn<>("Cpf");
	    col2.setCellValueFactory(new PropertyValueFactory<>("cpf"));
	    
	    TableColumn<Visitante, String> col3 = new TableColumn<>("Destino");
	    col3.setCellValueFactory(new PropertyValueFactory<>("destino"));

	    TableColumn<Visitante, String> col4 = new TableColumn<>("Id");
	    col4.setCellValueFactory(new PropertyValueFactory<>("id"));
	    
	    TableColumn<Visitante, String> col5 = new TableColumn<>("Data");
	    col5.setCellValueFactory(new PropertyValueFactory<>("dataAtual"));
	    
	    TableColumn<Visitante, String> col6 = new TableColumn<>("Motivo");
	    col6.setCellValueFactory(new PropertyValueFactory<>("motivo"));
	    
	    TableColumn<Visitante, String> col7 = new TableColumn<>("Telefone");
	    col7.setCellValueFactory(new PropertyValueFactory<>("telefone"));
	 
	    
	    tabelav.getColumns().addAll(col1, col2, col3,col4,col5,col6,col7);
	    
	    col1.setPrefWidth(19);
		col2.setPrefWidth(19);
		col3.setPrefWidth(19);
		col4.setPrefWidth(19);
		col5.setPrefWidth(19);
		col6.setPrefWidth(19);
		col7.setPrefWidth(19);

			  
        
        
             
        tabelav.setItems(v);
        
    

        tabelav.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
	
	

   

    public void adicionar() throws SQLException{
        Visitante vs =  VisistanteBuilder.builder()
        .addDados(nome.get(),cpf.get(),telefone.get())
        .addVisita(motivo.get(), dataAtual.get(),destino.get())
        .get();
        v.add(vs);
        daovis.adicionar(vs);
        
        limpar();
       
          
    }

    
    public void pesquisarPorNome() throws SQLException{
        List<Visitante> visListPesquisa = daovis.pesquisarPorNome(cpf.get());
        
        v.clear();
        v.addAll(visListPesquisa);
        limpar();
    }
    public void atualiza() throws SQLException {
    	Visitante v = new Visitante();
		daovis.atualiza(v);
		limpar();
	}

	
	public void delete() throws SQLException {
		Visitante v = new Visitante();
		daovis.remove(v);
		limpar();
	}
	
    public TableView<Visitante> getTable() {
    	
        return  tabelav;
        
    }
	
	 
	public void limpar() {
		nome.setValue("");
		cpf.setValue("");
		destino.setValue("");
	}
	
	
	public StringProperty nomeProperty() {
		return nome;
	}
	

	
	public StringProperty cpfProperty() {
		return cpf;
	}

	public StringProperty destinoProperty() {
		return destino;
	}
	public StringProperty idProperty() {
		return id;
	}public StringProperty dataProperty() {
		return dataAtual;
	}public StringProperty telefoneProperty() {
		return telefone;
	}
	public StringProperty motivoProperty() {
		return motivo;
	}
}
