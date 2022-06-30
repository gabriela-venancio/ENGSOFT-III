package Entity;

public class ChavesBuilder {

	
	

	private Chaves chaves;
	
	public ChavesBuilder() {
		this.chaves= new Chaves();
		
	}
	
	public static ChavesBuilder builder() {
		return new ChavesBuilder();
	
	}
	
	public ChavesBuilder addDados( String id, String chave, String responsavel, String data ) {
		this.chaves.setChave(chave);
		this.chaves.setData(data);
		this.chaves.setId(id);
		this.chaves.setResponsavel(responsavel);

		return this;
	}
	


	public Chaves get() {
		this.chaves = chaves;
		return chaves;
	}
	

	
}
	

