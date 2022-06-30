package Controller;

import java.sql.SQLException;
import java.util.List;

import DAO.DAOChaves;
import Entity.Chaves;
import Entity.ChavesBuilder;
import Persistence.PersistenceChaves;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ChavesController {
	
	
	 private DAOChaves daoChaves = new PersistenceChaves();
	  private ObservableList<Chaves> chave = FXCollections.observableArrayList();
	    private TableView<Chaves> tableChaves = new TableView<>();

	    
	  
	    private StringProperty chaves = new SimpleStringProperty();
		private StringProperty data = new SimpleStringProperty();
		private StringProperty id = new SimpleStringProperty();
	    private StringProperty responsavel = new SimpleStringProperty();
	    
	   



		@SuppressWarnings("unchecked")
		public ChavesController() {
			
			TableColumn<Chaves, String> col1 = new TableColumn<>("Chaves");
			col1.setCellValueFactory(new PropertyValueFactory<>("chave"));
			
			TableColumn<Chaves, String> col2 = new TableColumn<>("Responsavel");
			col2.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
			
			TableColumn<Chaves, String> col3 = new TableColumn<>("ID");
			col3.setCellValueFactory(new PropertyValueFactory<>("id"));
			
			TableColumn<Chaves, String> col4 = new TableColumn<>("Data");
			col4.setCellValueFactory(new PropertyValueFactory<>("data"));
			
			
			tableChaves.getColumns().addAll(col2, col1,col3,col4);
			
			col1.setPrefWidth(190);
			col2.setPrefWidth(190);
			col3.setPrefWidth(190);
			col4.setPrefWidth(190);

			

			
			
			tableChaves.setItems(chave);
			tableChaves.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			
		}

	    public void adicionar() throws SQLException{
	        Chaves c = ChavesBuilder.builder()
	        		.addDados(id.get(), chaves.get(), responsavel.get(), data.get())
	        		.get();
	       
	        chave.add(c);
	        daoChaves.adicionar(c);
	        	        

	        limpar();
	    }


	    public void pesquisarPorNome() throws SQLException{
	        List<Chaves> chaveListPesquisa = daoChaves.pesquisarPorNome(chaves.get());
	       
	        chave.clear();
	        chave.addAll(chaveListPesquisa);
	        limpar();
	    }
	    public void atualiza() throws SQLException {
	    	Chaves c = new Chaves();
			daoChaves.atualiza(c);
			limpar();
		}

		
		public void delete() throws SQLException {
			Chaves c = new Chaves();
			daoChaves.remove(c);
			limpar();
		}

    public TableView<Chaves> getTable() {
        return tableChaves;
    }
	
	public void limpar() {
		chaves.setValue("");
		responsavel.setValue("");
		id.setValue("");
		data.setValue("");
	}
	
	
	
	
	public StringProperty chavesProperty() {
		return chaves;
	}
	
	
	
	public StringProperty responsavelProperty() {
		return responsavel;
	}
	

	public StringProperty IdProperty() {
		return id;
	}
	

	public StringProperty DataProperty() {
		return data;
	}
}
