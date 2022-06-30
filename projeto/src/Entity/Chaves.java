package Entity;

import java.util.Date;


@Table(name = "chaves")
@Entity
public class Chaves {
	
	@Id
	@Column(name = "ID")
	@NotNull
	private String id;
	

	@Column(name = "chaves", length = 2)
	@NotNull
	private String chave="";
	

	@Column(name = "Responsavel", length = 100)
	@NotNull
	private String responsavel="";
	

	@Column(name = "data", length = 20)
	@NotNull
	private String data;
	
	
	
	public Chaves() {
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String string) {
		this.id = string;
	}

	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
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
