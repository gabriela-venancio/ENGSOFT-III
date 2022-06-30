package Tela;

import java.sql.SQLException;
import java.util.Objects;

import Controller.ChavesController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChaveBoundary extends Application{

	
 
	public  Stage stage;


    
    //Botões da classe chaves
    private final TextField chaTxtChaves = new TextField();
    private final TextField chaTxtResponsaval = new TextField();
    private final TextField chaTxtid = new TextField();
    private final TextField chaTxtdata = new TextField();

    
    private final Button chaBtnCadastrar = new Button("Cadastrar");
    private final Button chaBtnPesquisar = new Button("Pesquisar");
    private final Button chaBtneditar = new Button("editar");
    private final Button chaBtnremover = new Button("remover");
    private final Button chaBtnInicio = new Button("Inicio");

    private final Label chaLblChaves = new Label("");
    private final Label chaLblResponsavel = new Label("");

    Label chaTitle = new Label("Chaves");

    private  ChavesController chaControl = new ChavesController();
    
    

	@Override
	public void start(Stage stage) throws Exception {
		
		

			
			GridPane formularioChaves = new GridPane();
			GridPane formularioResponsavel = new GridPane();
			GridPane formulariopainel = new GridPane();
	        BorderPane chaPanePrincipal = new BorderPane();
	      

		 Bindings.bindBidirectional(chaControl.chavesProperty(), chaTxtChaves.textProperty());
	        Bindings.bindBidirectional(chaControl.responsavelProperty(), chaTxtResponsaval.textProperty());
	        
	        formularioChaves.add(chaTxtChaves, 0, 1);
	      
	        
	        formularioResponsavel.add(chaTxtResponsaval, 2, 0);
	        formularioResponsavel.add(chaTxtid, 4, 0);

	        formularioResponsavel.add(chaTxtdata, 5, 0);



	        formulariopainel.add(new Label("Chave:"), 1,0);
	        formulariopainel.add(new Label("Responsavel:"), 3, 0);
	        formulariopainel.add(new Label("id:"), 3, 1);
	        formulariopainel.add(new Label("data:"), 3, 2);

	        formulariopainel.add(formularioChaves,1,2);
	        formulariopainel.add(formularioResponsavel,3,2);
	        formulariopainel.add(chaBtnCadastrar, 4, 2);
	        formulariopainel.add(chaBtnInicio, 6, 2);
	        formulariopainel.add(chaBtnPesquisar, 8, 2);
	        formulariopainel.add(chaBtneditar, 10, 2);
	        formulariopainel.add(chaBtnremover, 12, 2);

	        
	        chaPanePrincipal.getStylesheets().add(Objects.requireNonNull(tela.class.getResource("style.css")).toExternalForm());

	        
			chaTitle.getStyleClass().add("tabela de chaves");

			chaPanePrincipal.setTop(formulariopainel);
			chaPanePrincipal.setCenter(chaControl.getTable());
			
			

			
			chaBtnCadastrar.setOnAction(e ->{
				try {
					chaControl.adicionar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			
			chaBtnPesquisar.setOnAction(e->{
				try {
					chaControl.pesquisarPorNome();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			chaBtneditar.setOnAction(e -> {
				try {
					chaControl.atualiza();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			chaBtnremover.setOnAction(e -> {
				try {
					chaControl.delete();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});

			
			chaBtnInicio.setOnAction(e ->{
				getStage().close();
			});

			Scene scn = new Scene(chaPanePrincipal, 1400,800);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(scn);
			stage.show();
			setStage(stage);
		}

		
			
	private void setStage(Stage stage2) {
		this.stage = stage2;
		
	}



	private Stage getStage() {
		return stage;
	}
    
    
}
