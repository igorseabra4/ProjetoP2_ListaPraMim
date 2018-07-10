package sistema.produtos;

public class ProdutoUnidade extends Produto {

	private int unidade;
	public ProdutoUnidade(int id, String nome, String categoria, int unidade, String localDeCompra, double preco) {
		super(id,nome,categoria,localDeCompra,preco);
		this.unidade = unidade;
	}
	@Override
	protected String toStringValues() {
		return "Preco";
	}
}
