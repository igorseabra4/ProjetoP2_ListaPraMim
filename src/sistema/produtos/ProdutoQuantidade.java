package sistema.produtos;

public class ProdutoQuantidade extends Produto {

	private int qnt;
	private String unidadeDeMedida;
	
	public ProdutoQuantidade(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		super(nome,categoria,localDeCompra,preco);
		this.qnt = qnt;
		this.unidadeDeMedida = unidadeDeMedida;
	}
	
	@Override
	public void atualizaItem(String atributo, String novoValor) {
		super.atualizaItem(atributo, novoValor);
	}
}
