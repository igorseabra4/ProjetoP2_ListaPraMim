package sistema.comparadores;

import java.util.Comparator;

import sistema.compras.Compra;

public class OrdemCategoriaCompra implements Comparator<Compra> {

	@Override
	public int compare(Compra o1, Compra o2) {
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
