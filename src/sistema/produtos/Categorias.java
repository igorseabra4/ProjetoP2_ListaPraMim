package sistema.produtos;

/**
 * Categorias possíveis dos produtos, que podem ser: alimento industrializado,
 * alimento não industrializado, limpeza e higiene pessoal.
 * 
 * @author Henry Filho
 *
 */
public enum Categorias {
	ALIM_INDUSTR("alimento industrializado"),
	ALIM_NAO_INDUSTR("alimento nao industrializado"),
	LIMPEZA("limpeza"),
	HIGIENE_PESSOAL("higiene pessoal");

	private String nome;

	/**
	 * Construtor do objeto que define a categoria.
	 * 
	 * @param nome
	 *            Representação textual da categoria.
	 */
	private Categorias(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna a representação textual da categoria.
	 * 
	 * @return nome. (representação textual)
	 */
	public String getNome() {
		return nome;
	}
}
