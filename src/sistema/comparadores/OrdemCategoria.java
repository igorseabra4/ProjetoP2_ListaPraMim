package sistema.comparadores;

import java.util.Comparator;

import sistema.produtos.Produto;

public class OrdemCategoria implements Comparator<Produto> {

	@Override
	public int compare(Produto o1, Produto o2) {
		return categoria(o1.getCategoria()) - categoria(o2.getCategoria());
	}

	private int categoria(String categoria) {
		if (categoria.equals("higiene pessoal"))
			return 1;
		if (categoria.equals("limpeza"))
			return 2;
		if (categoria.equals("alimento industrializado"))
			return 3;
		if (categoria.equals("alimento nao industrializado"))
			return 4;
		return 0;
	}

}
