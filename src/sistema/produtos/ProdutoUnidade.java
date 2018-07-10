package sistema.produtos;

public class ProdutoUnidade extends Produto {

	private int unidade;
	public ProdutoUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		super(nome,categoria,localDeCompra,preco);
		this.unidade = unidade;
	}
}
