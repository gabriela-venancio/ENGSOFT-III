  package Tela;

import java.sql.SQLException;
import java.util.Objects;

import Controller.FuncionarioController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FuncionarioBoundary extends Application {

	public  Stage stgStage;
	
	
	
	
	 private final TextField funTxtNome = new TextField();
	     TextField funTxtCpf = new TextField();
	     TextField funTxtnome = new TextField();
	     TextField funTxtCargo = new TextField();
	     TextField funTxtSetor = new TextField();
	     TextField funTxtTelefone = new TextField();
	     TextField funTxtRamal = new TextField();

	    Button funBtnCadastrar = new Button("Cadastrar");
	     Button funBtnPesquisar = new Button("Pesquisar");
	     Button funBtneditar = new Button("editar");
	     Button funBtnremover = new Button("remover");
	     Button funBtnInicio = new Button("Inicio");

	     Label funLblFuncionarionome = new Label("nome");
	     Label funLblFuncionariocpf = new Label("cpf");
	     Label funLblFuncionariocargo = new Label("cargo");
	     Label funLblFuncionariosetor = new Label("setor: ");
	     Label funLblFuncionariotelefone = new Label("telefone: ");
	     Label funLblFuncionarioramal = new Label("ramal: ");

	    Label funTitle = new Label("Funcioanrios");
	    

	    private final FuncionarioController funControl = new FuncionarioController();
	    
	   
	   

		@Override
		public void start(Stage stage) throws Exception {
	
			Bindings.bindBidirectional(funTxtNome.textProperty(), funControl.NomeProperty());
	        Bindings.bindBidirectional(funTxtCpf.textProperty(), funControl.cpfProperty());
	        Bindings.bindBidirectional(funTxtCargo.textProperty(), funControl.cargoProperty());
	        Bindings.bindBidirectional(funTxtSetor.textProperty(), funControl.SetorProperty());
	        Bindings.bindBidirectional(funTxtTelefone.textProperty(), funControl.TelefoneProperty());
	        Bindings.bindBidirectional(funTxtRamal.textProperty(), funControl.RamalProperty());

			
	        BorderPane funPanePrincipal = new BorderPane();
	        VBox funPaneConteudo = new VBox();
	        GridPane funPaneForm = new GridPane();
	        FlowPane funPaneButton = new FlowPane();
	        funPanePrincipal.getStylesheets().add(Objects.requireNonNull(tela.class.getResource("style.css")).toExternalForm());

	        funTitle.getStyleClass().add("tabela de Funcionarios");
	        
	        
	        
	        funPaneForm.add(new Label("Nome:"), 0, 0);
	        funPaneForm.add(new Label("Cpf:"), 0, 1);
	        funPaneForm.add(new Label("cargo:"), 0, 2);
	        funPaneForm.add(new Label("setor:"), 0, 3);
	        funPaneForm.add(new Label("telefone:"), 0, 4);
	        funPaneForm.add(new Label("ramal:"), 0, 5);

	        funPaneForm.add(funTxtNome, 1, 0);
	        funPaneForm.add(funTxtCpf, 1, 1);
	        funPaneForm.add(funTxtCargo, 1, 2);
	        funPaneForm.add(funTxtSetor, 1, 3);
	        funPaneForm.add(funTxtTelefone, 1, 4);	        
	        funPaneForm.add(funTxtRamal, 1, 5);
	        
	        
	        
	        funPaneForm.setVgap(10);
	        funPaneForm.setHgap(5);
	        funPaneForm.setAlignment(Pos.CENTER);

	        
	        funPaneButton.getChildren().addAll(funBtnCadastrar, funBtnPesquisar, funBtnInicio,funBtneditar,funBtnremover);

	        funPaneButton.setHgap(50);
	        funPaneButton.setVgap(25);
	        funPaneButton.setAlignment(Pos.CENTER);

	        funPaneConteudo.getChildren().addAll(funTitle, funPaneForm,funPaneButton);
	        funPaneConteudo.setSpacing(15);
	        funPaneConteudo.setAlignment(Pos.CENTER);
	    	
	        funPanePrincipal.setLeft(funPaneConteudo);
	        funPanePrincipal.setCenter(funControl.getTable());
	        
	    	funBtnCadastrar.setOnAction(e ->{
				try {
					funControl.adicionar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			
			funBtnPesquisar.setOnAction(e->{
				try {
					funControl.pesquisarPorNome();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			funBtneditar.setOnAction(e -> {
				try {
					funControl.atualiza();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			funBtnremover.setOnAction(e -> {
				try {
					funControl.delete();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});

			
			funBtnInicio.setOnAction(e ->{
				getStage().close();
			});
			
			

			
			Scene scn = new Scene(funPanePrincipal, 1400,800);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(scn);
			stage.show();
			setStage(stage);
		
	        
}




		private Stage getStage() {
			return stgStage;
		}




		private void setStage(Stage stage) {
			this.stgStage = stage;			
		}	
		
}