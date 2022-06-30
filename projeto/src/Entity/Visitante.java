package Entity;

import java.time.LocalDateTime;

import javafx.scene.chart.PieChart.Data;

@Table(name = "visitante")
@Entity
public class Visitante {
	
	@Id
	@Column(name = "Id")
	@NotNull
	private String id;
	
	@Column(name = "nomeCompleto", length = 100)
	@NotNull
	private String nome="";
	
	@Column(name = "CPF", length = 11)
	@NotNull
	private String cpf="";
	
	@Column(name = "Destino", length = 100)
	@NotNull
	private String destino ="";
	
	@Column(name = "data", length = 20)
	@NotNull
	private String dataAtual;
	
	@Column(name = "Motivo", length = 100)
	@NotNull
	private String motivo;
	
	@Column(name = "numero", length = 15)
	@NotNull
	private String telefone;

	public Visitante() {
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDataAtual() {
		return dataAtual;
	}
	public void setDataAtual(String string) {
		this.dataAtual = string;
	}
	public void remove(Visitante v) {
		
	}


	
	
	

}
