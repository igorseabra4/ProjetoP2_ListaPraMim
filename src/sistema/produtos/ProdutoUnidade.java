package sistema.produtos;

/**
 * Produto por unidade, como pacote de biscoito recheado Vox, ou copo de
 * requeijao cremoso Fofonlí, ou ainda abacaxi. A maioria dos produtos de
 * higiene pessoal e alimentos industrializados recai nessa classe de itens.
 * 
 * @author Henry Filho
 *
 */
public class ProdutoUnidade extends Produto {

	private static final long serialVersionUID = -3022482674422854817L;
	private int unidade;

	/**
	 * Construtor dos produtos comprados por unidade.
	 * 
	 * @param id Identificador numerico do produto.
	 * @param nome Nome do produto.
	 * @param categoria Categoria do produto. (em texto)
	 * @param unidade Unidade do produto.
	 * @param localDeCompra Um local no qual o produto pode ser comprado.
	 * @param preco O preco do produto no local determinado.
	 */
	public ProdutoUnidade(int id, String nome, String categoria, int unidade, String localDeCompra, double preco) {
		super(id, nome, categoria, localDeCompra, preco);
		if (unidade < 0)
			throw new IllegalArgumentException("Erro no cadastro de item: valor de unidade nao pode ser menor que zero.");
		this.unidade = unidade;
	}

	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if (atributo.equals("unidade")) {
			if (Integer.parseInt(novoValor) < 0)
				throw new IllegalArgumentException("Erro na atualizacao de item: valor de unidade nao pode ser menor que zero.");

			unidade = Integer.parseInt(novoValor);
		} else
			super.atualizaItem(atributo, novoValor);
	}

	@Override
	protected String toStringValues() {
		return "Preco";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + unidade;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		ProdutoUnidade other = (ProdutoUnidade) obj;
		if (hashCode() != other.hashCode())
			return false;
		return true;
	}
}
