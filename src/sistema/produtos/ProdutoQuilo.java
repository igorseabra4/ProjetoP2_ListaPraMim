package sistema.produtos;

public class ProdutoQuilo extends Produto {

	private double kg;
	
	public ProdutoQuilo(int id, String nome, String categoria, double kg, String localDeCompra, double preco) {
		super(id,nome,categoria,localDeCompra,preco);
		this.kg = kg;
	}

	@Override
	protected String toStringValues() {
		return "Preco por quilo";
	}
}
