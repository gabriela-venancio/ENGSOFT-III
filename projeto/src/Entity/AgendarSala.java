package Entity;

@Table(name = "agendarvideo")
@Entity
public class AgendarSala {
	
	@Id
	@Column(name = "CPF", length = 11)
	@NotNull
	private String cpf;
	
	@Column(name = "Setor", length = 100)
	@NotNull
	private String setor;
	
	@Column(name = "data", length = 20)
	@NotNull
	private String data;
	
	@Column(name = "tempo", length = 100)
	@NotNull
	private String tempoOcupada;
	
	@Column(name = "Motivo", length = 100)
	@NotNull
	private String motivo ="";
	
	@Column(name = "Responsavel", length = 100)
	@NotNull
	private String responsavel ="";
	
	
	
	public AgendarSala() {
		
	}
	
	
	
	
	



	public String getCpf() {
		return cpf;
	}








	public void setCpf(String cpf) {
		this.cpf = cpf;
	}








	public String getSetor() {
		return setor;
	}




	public void setSetor(String setor) {
		this.setor = setor;
	}




	public String getTempoOcupada() {
		return tempoOcupada;
	}




	public void setTempoOcupada(String tempoOcupada) {
		this.tempoOcupada = tempoOcupada;
	}




	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	
	
}
