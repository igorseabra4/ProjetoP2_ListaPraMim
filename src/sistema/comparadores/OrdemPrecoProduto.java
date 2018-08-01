package sistema.comparadores;

import java.util.Comparator;

import sistema.produtos.Produto;

public class OrdemPrecoProduto implements Comparator<Produto> {
	@Override
	public int compare(Produto o1, Produto o2) {
		return (int) (o1.getMenorPreco() * 100 - o2.getMenorPreco() * 100);
	}
}