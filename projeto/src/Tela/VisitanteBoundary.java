package Tela;

import java.sql.SQLException;
import java.util.Objects;

import Controller.VisitanteController;
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

public class VisitanteBoundary extends Application {

	

	
private Stage stage;
	//butões da classse visitante

private final TextField visTxtNome = new TextField();
private final TextField visTxtCpf = new TextField();
private final TextField visTxtDestino = new TextField();
private final TextField visTxtid = new TextField();
private final TextField visTxtmotivo = new TextField();
private final TextField visTxttelefone = new TextField();
private final TextField visTxtdata = new TextField();



private final Button visBtnCadastrar = new Button("Cadastrar");
private final Button visBtneditar = new Button("editar");
private final Button visBtnremover = new Button("remover");
private final Button visBtnPesquisar = new Button("Pesquisar");
private final Button visBtnInicio = new Button("Inicio");

Label visTitle = new Label("Visitantes");

private final VisitanteController visControl = new VisitanteController();


@Override
public void start(Stage stage) throws Exception {
	

	   Bindings.bindBidirectional(visControl.nomeProperty(), visTxtNome.textProperty());
       Bindings.bindBidirectional(visControl.cpfProperty(), visTxtCpf.textProperty());
       Bindings.bindBidirectional(visControl.destinoProperty(), visTxtDestino.textProperty());
       Bindings.bindBidirectional(visControl.idProperty(), visTxtid.textProperty());
       Bindings.bindBidirectional(visControl.motivoProperty(), visTxtmotivo.textProperty());
       Bindings.bindBidirectional(visControl.telefoneProperty(), visTxttelefone.textProperty());
       Bindings.bindBidirectional(visControl.dataProperty(), visTxtdata.textProperty());

	
	  BorderPane visPanePrincipal = new BorderPane();
      VBox visPaneConteudo = new VBox();
      GridPane visPaneForm = new GridPane();
      FlowPane visPaneButton = new FlowPane();

      visPanePrincipal.getStylesheets().add(Objects.requireNonNull(tela.class.getResource("style.css")).toExternalForm());

	
  	visTitle.getStyleClass().add("tabela de Visitante");

		
		
		

        visPaneForm.add(new Label("nome"), 0, 0);
        visPaneForm.add(new Label("cpf"), 0, 1);
        visPaneForm.add(new Label("destino"), 0, 2);
        visPaneForm.add(new Label("motivo"), 0, 3);
        visPaneForm.add(new Label("id"), 0, 4);
        visPaneForm.add(new Label("telefone"), 0, 5);
        visPaneForm.add(new Label("data"), 0, 6);


        visPaneForm.add(visTxtNome, 1, 0);
        visPaneForm.add(visTxtCpf, 1, 1);
        visPaneForm.add(visTxtDestino, 1, 2);
        visPaneForm.add(visTxtmotivo, 1, 3);
        visPaneForm.add(visTxtid, 1,4);
        visPaneForm.add(visTxttelefone, 1, 5);
        visPaneForm.add(visTxtdata, 1, 6);


        
        visPaneForm.setVgap(10);
        visPaneForm.setHgap(15);
        visPaneForm.setAlignment(Pos.CENTER);

        visPaneButton.getChildren().addAll(visBtnCadastrar, visBtnPesquisar,  visBtnInicio,visBtneditar,visBtnremover);
        visPaneButton.setHgap(10);
        visPaneButton.setVgap(15);
        visPaneButton.setAlignment(Pos.CENTER);

        visPaneConteudo.getChildren().addAll(visTitle, visPaneForm, visPaneButton);
        visPaneConteudo.setSpacing(15);
        visPaneConteudo.setAlignment(Pos.CENTER);
        
        visPanePrincipal.setLeft(visPaneConteudo);
        visPanePrincipal.setCenter(visControl.getTable());
        
        
        visBtnCadastrar.setOnAction(e->{
			try {
				visControl.adicionar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		
		visBtnPesquisar.setOnAction(e->{
			try {
				visControl.pesquisarPorNome();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		visBtneditar.setOnAction(e -> {
			try {
				visControl.atualiza();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		visBtnremover.setOnAction(e -> {
			try {
				visControl.delete();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		visBtnInicio.setOnAction(e ->{
			getStage().close();
		});
				
        Scene scn = new Scene(visPanePrincipal, 1400, 800);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scn);
		stage.show();
		setStage(stage);
		
}
		


private void setStage(Stage stage2) {
	this.stage = stage2;	
}


private Stage getStage() {
	return stage;}
	
	
}
