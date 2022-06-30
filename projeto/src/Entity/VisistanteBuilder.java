package Entity;

public class VisistanteBuilder {

	
	private Visitante visitante;
	
	public VisistanteBuilder() {
		this.visitante= new Visitante();
		
	}
	
	public static VisistanteBuilder builder() {
		return new VisistanteBuilder();
	
	}
	
	public VisistanteBuilder addDados( String nome, String cpf, String telefone ) {
		this.visitante.setCpf(cpf);
		this.visitante.setNome(nome);
		this.visitante.setTelefone(telefone);
		return this;
	}
	
	public VisistanteBuilder addVisita(String destino, String motivo, String dataAtual) {
		this.visitante.setDataAtual(dataAtual);
		this.visitante.setDestino(destino);
		this.visitante.setMotivo(motivo);
	return this;
	}

	public Visitante get() {
		this.visitante = visitante;
		return visitante;
	}
	

	
}
