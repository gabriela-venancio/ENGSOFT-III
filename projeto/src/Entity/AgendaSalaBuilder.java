package Entity;

public class AgendaSalaBuilder {	

	private AgendarSala agendasala;
	
	public AgendaSalaBuilder() {
		this.agendasala= new AgendarSala();
		
	}
	
	public static AgendaSalaBuilder builder() {
		return new AgendaSalaBuilder();
	
	}
	
	public AgendaSalaBuilder addDadosPessoais( String responsavel, String cpf, String setor,String data, String motivo, String tempo) {
		this.agendasala.setCpf(cpf);
		this.agendasala.setData(data);
		this.agendasala.setMotivo(motivo);
		this.agendasala.setResponsavel(responsavel);
		this.agendasala.setSetor(setor);
		this.agendasala.setTempoOcupada(tempo);

		return this;
	}
	
	

	public AgendarSala get() {
		this.agendasala = agendasala;
		return agendasala;
	}
	

	
}