package sistema.comparadores;

import java.util.Comparator;

import sistema.compras.Produtos;

public class OrdemPreco implements Comparator<Produtos> {

	@Override
	public int compare(Produtos o1, Produtos o2) {
		return (int) (o1.getMenorPreco() * 100 - o2.getMenorPreco() * 100);
	}
}