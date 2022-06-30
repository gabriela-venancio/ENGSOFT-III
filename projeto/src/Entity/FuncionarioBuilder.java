package Entity;

public class FuncionarioBuilder {

	

	private Funcionario funcionario;
	
	public FuncionarioBuilder() {
		this.funcionario= new Funcionario();
		
	}
	
	public static FuncionarioBuilder builder() {
		return new FuncionarioBuilder();
	
	}
	
	public FuncionarioBuilder addDadosPessoais( String nome, String cpf, String telefone ) {
		this.funcionario.setCpf(cpf);
		this.funcionario.setNome(nome);
		this.funcionario.setTelefone(telefone);
		return this;
	}
	
	public FuncionarioBuilder addDadosTrabalho(String setor, String cargo, String ramal) {
		this.funcionario.setCargo(cargo);
		this.funcionario.setRamal(ramal);
		this.funcionario.setSetor(setor);
	return this;
	}

	public Funcionario get() {
		this.funcionario = funcionario;
		return funcionario;
	}
	

	
}
