package sistema.produtos;

/**
 * Produtos com quantidade fixa (por exemplo, frasco de detergente Brilhol com
 * 500ml, ou saco de algodão Clemer com 300g, ou caixa com 18 ovos). Esses itens
 * devem manter a quantidade e a medida do produto. No exemplo do detergente a
 * quantidade é 500 e a medida é mililitro, já para o algodão a quantidade é 300
 * e a medida grama. Já no caso do ovo a quantidade é 18 e a medida é "unidade
 * do produto".
 * 
 * @author Henry Filho
 *
 */

public class ProdutoQuantidade extends Produto {

	private static final long serialVersionUID = 1017991366666361871L;
	private int qnt;
	private String unidadeDeMedida;

	/**
	 * Construtor do produto de quantidade fixa.
	 * 
	 * @param id
	 *            Identificador numérico do produto.
	 * @param nome
	 *            Nome do produto.
	 * @param categoria
	 *            Categoria do produto. (em texto)
	 * @param qnt
	 *            Quantidade fixa do produto.
	 * @param unidadeDeMedida
	 *            Unidade de medida correspondente a quantidade fixa.
	 * @param localDeCompra
	 *            Um local no qual o produto pode ser comprado.
	 * @param preco
	 *            O preço do produto no local determinado.
	 */
	public ProdutoQuantidade(int id, String nome, String categoria, int qnt, String unidadeDeMedida,
			String localDeCompra, double preco) {
		super(id, nome, categoria, localDeCompra, preco);
		if (qnt < 0)
			throw new IllegalArgumentException(
					"Erro no cadastro de item: valor de quantidade nao pode ser menor que zero.");
		if (unidadeDeMedida.trim().equals("") || unidadeDeMedida.equals(null))
			throw new NullPointerException("Erro no cadastro de item: unidade de medida nao pode ser vazia ou nula.");

		this.qnt = qnt;
		this.unidadeDeMedida = unidadeDeMedida;
	}

	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if (atributo.equals("quantidade")) {
			if (Integer.parseInt(novoValor) < 0)
				throw new IllegalArgumentException(
						"Erro na atualizacao de item: valor de quantidade nao pode ser menor que zero.");
			qnt = Integer.parseInt(novoValor);
		} else if (atributo.equals("unidade de medida"))
			unidadeDeMedida = novoValor;
		else
			super.atualizaItem(atributo, novoValor);
	}

	@Override
	public String toString(int i) {
		return String.format("%s, %d %s", super.toString(0), qnt, unidadeDeMedida);
	}

	@Override
	protected String toStringValues() {
		return String.format("%d %s, Preco", qnt, unidadeDeMedida);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + qnt;
		result = prime * result + ((unidadeDeMedida == null) ? 0 : unidadeDeMedida.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		ProdutoQuantidade other = (ProdutoQuantidade) obj;
		if (hashCode() != other.hashCode())
			return false;
		return true;
	}
}
