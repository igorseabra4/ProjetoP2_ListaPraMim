package sistema.produtos;

public class ProdutoConstruido extends Produto {

	public ProdutoConstruido(int id, String nome, String categoria, String localDeCompra, double preco) {
		super(id, nome, categoria, localDeCompra, preco);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String toStringValues() {
		// TODO Auto-generated method stub
		return "Preco";
	}

}
