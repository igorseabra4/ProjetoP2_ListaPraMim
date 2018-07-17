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

	private int qnt;
	private String unidadeDeMedida;

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
}
