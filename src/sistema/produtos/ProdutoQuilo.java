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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(kg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		ProdutoQuilo other = (ProdutoQuilo) obj;
		if (hashCode() != other.hashCode())
			return false;
		return true;
	}
}
