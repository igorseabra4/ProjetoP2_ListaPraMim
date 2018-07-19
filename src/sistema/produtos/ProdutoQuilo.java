package sistema.produtos;

/**
 * Produtos não industrializados por quilo. Em geral são os produtos de açougue
 * e hortifruti.
 * 
 * @author Henry Filho
 *
 */
public class ProdutoQuilo extends Produto {

	private double kg;

	/**
	 * Construtor de produtos medidos por quilo.
	 * 
	 * @param id
	 *            Identificador numérico do produto.
	 * @param nome
	 *            Nome do produto.
	 * @param categoria
	 *            Categoria do produto. (em texto)
	 * @param kg
	 *            Peso (em quilos) do produto.
	 * @param localDeCompra
	 *            Um local no qual o produto pode ser comprado.
	 * @param preco
	 *            O preço do produto no local determinado.
	 */
	public ProdutoQuilo(int id, String nome, String categoria, double kg, String localDeCompra, double preco) {
		super(id, nome, categoria, localDeCompra, preco);
		if (kg < 0)
			throw new IllegalArgumentException(
					"Erro no cadastro de item: valor de quilos nao pode ser menor que zero.");

		this.kg = kg;
	}

	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if (atributo.equals("kg")) {
			if (Double.parseDouble(novoValor) < 0)
				throw new IllegalArgumentException(
						"Erro na atualizacao de item: valor de quilos nao pode ser menor que zero.");

			kg = Double.parseDouble(novoValor);
		} else
			super.atualizaItem(atributo, novoValor);
	}

	@Override
	protected String toStringValues() {
		return "Preco por quilo";
	}
}
