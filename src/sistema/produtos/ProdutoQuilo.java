package sistema.produtos;

public class ProdutoQuilo extends Produto {

	private double kg;
	
	public ProdutoQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		super(nome,categoria,localDeCompra,preco);
		this.kg = kg;
	}
}
