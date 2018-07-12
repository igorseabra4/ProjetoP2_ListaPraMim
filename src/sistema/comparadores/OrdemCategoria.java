package sistema.comparadores;

import java.util.Comparator;

import sistema.compras.Produtos;

public class OrdemCategoria implements Comparator<Produtos> {

	@Override
	public int compare(Produtos o1, Produtos o2) {
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
