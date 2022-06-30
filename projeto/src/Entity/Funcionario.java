package Entity;


public class Funcionario {
	
	@Column(name = "nome", length = 100)
	@NotNull
	private String nome = "";
	
	@Id
	@Column(name = "CPF", length = 11)
	@NotNull
	private String cpf="";
	
	@Column(name = "Cargo", length = 100)
	@NotNull
	private String cargo ="";
	
	@Column(name = "Setor", length = 100)
	@NotNull
	private String setor;
	
	@Column(name = "numero", length = 15)
	@NotNull
	private String telefone;
	
	@Column(name = "ramal", length = 4)
	@NotNull
	private String ramal;

	
	
	
	public Funcionario() {
		
	}
	
	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

}
