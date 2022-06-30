package Controller;

import java.sql.SQLException;
import java.util.List;

import DAO.DAOFun;
import Entity.Funcionario;
import Entity.FuncionarioBuilder;
import Persistence.PersistenceFunc;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FuncionarioController {
//nome cpf cargo
	

  private ObservableList<Funcionario> funcionarios = FXCollections.observableArrayList();
	private TableView<Funcionario> tableFuncionario = new TableView<>();

	  
	private StringProperty nome =  new SimpleStringProperty();
	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty cargo = new SimpleStringProperty();
	private StringProperty setor = new SimpleStringProperty();
	private StringProperty telefone = new SimpleStringProperty();
	private StringProperty ramal = new SimpleStringProperty();

	
	private DAOFun daofun = new PersistenceFunc();

	
	
	
	public TableView<Funcionario> getTable() {
        return tableFuncionario;
    }
	
	
    public void setEntity(Funcionario f) {
        if (f != null) {
            nome.set(f.getNome());
           cpf.set(f.getCpf());
           cargo.set(f.getCargo());
           setor.set(f.getSetor());
           telefone.set(f.getTelefone());
           ramal.set(f.getRamal());
           
           
        }
    }
    
    
	public Funcionario getEntityFun() {
		Funcionario c = new Funcionario();
		c.setNome(nome.get().toLowerCase());
		c.setCpf(cpf.get().toLowerCase());
		c.setCargo(cargo.get().toLowerCase());
		c.setSetor(setor.get().toLowerCase());
		c.setTelefone(telefone.get().toLowerCase());
		c.setRamal(ramal.get().toLowerCase());
		
		
		return c;
	}
		@SuppressWarnings("unchecked")
	   public FuncionarioController() {
	        TableColumn<Funcionario, String> col1 = new TableColumn<>("Nome");
	       col1.setCellValueFactory(new PropertyValueFactory<>("nome"));

	        
	        TableColumn<Funcionario, String> col2 = new TableColumn<>("CPF");
	       col2.setCellValueFactory(new PropertyValueFactory<>("cpf"));

	        
	        TableColumn<Funcionario, String> col3 = new TableColumn<>("Cargo");
	        col3.setCellValueFactory(new PropertyValueFactory<>("cargo"));

	        TableColumn<Funcionario, String> col4 = new TableColumn<>("Setor");
	        col4.setCellValueFactory(new PropertyValueFactory<>("setor"));
	        
	        TableColumn<Funcionario, String> col5 = new TableColumn<>("Telefone");
	        col5.setCellValueFactory(new PropertyValueFactory<>("telefone"));
	        
	        TableColumn<Funcionario, String> col6 = new TableColumn<>("Ramal");
	        col6.setCellValueFactory(new PropertyValueFactory<>("ramal"));
	    

	        tableFuncionario.getColumns().addAll( col1, col2, col3,col4,col5,col6);
	           

			col1.setPrefWidth(190);
			col2.setPrefWidth(190);
			col3.setPrefWidth(190);
			col4.setPrefWidth(190);
			col5.setPrefWidth(190);
			col6.setPrefWidth(190);

			

			
			
			tableFuncionario.setItems(funcionarios);
			tableFuncionario.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			
		}
	        
	        
	        

	public void limpar() {
		nome.setValue("");
		cpf.setValue("");
		cargo.setValue("");
		setor.setValue("");
		telefone.setValue("");
		ramal.setValue("");
		
	}
	
	public String getNome() {
		return nome.get();
	}
	
	public StringProperty NomeProperty() {
		return nome;
	}
	
	public String getCpf() {
		return cpf.get();
	}
	
	public StringProperty cpfProperty() {
		return cpf;
	}
	
	public String getCargo() {
		return cargo.get();
	}
	
	public StringProperty cargoProperty() {
		return cargo;
	}
	public String getSetor() {
		return setor.get();
	}
	
	public StringProperty SetorProperty() {
		return setor;
	}
	public String getTelefone() {
		return telefone.get();
	}
	
	public StringProperty TelefoneProperty() {
		return telefone;
	}
	public String getRamal() {
		return ramal.get();
	}
	
	public StringProperty RamalProperty() {
		return ramal;
	}

	public void pesquisarPorNome() throws SQLException {
		 List<Funcionario> funListPesquisa = daofun.pesquisarPorNome(nome.get());
	      
	        funcionarios.clear();
	        funcionarios.addAll(funListPesquisa);
	        limpar();
	    }

	


	public void adicionar() throws SQLException {
		Funcionario f = FuncionarioBuilder.builder()
		.addDadosPessoais(nome.get(), cpf.get(), cargo.get())
		.addDadosTrabalho(cargo.get(), setor.get(), ramal.get())
		.get();
		
	
		funcionarios.add(f);
		
		
        daofun.adicionar(f);
		
	}
	public void atualiza() throws SQLException {
		Funcionario f = new Funcionario();
		daofun.atualiza(f);
		limpar();
	}

	
	public void delete() throws SQLException {
		Funcionario f = new Funcionario();
		daofun.remove(f);
		limpar();
	}
	
}
	
	
	

