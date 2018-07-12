package sistema.produtos;

public enum Categorias {
	ALIM_INDUSTR("alimento industrializado"),
	ALIM_NAO_INDUSTR("alimento nao industrializado"),
	LIMPEZA("limpeza"),
	HIGIENE_PESSOAL("higiene pessoal");
	
	private String nome;
	
	private Categorias(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
