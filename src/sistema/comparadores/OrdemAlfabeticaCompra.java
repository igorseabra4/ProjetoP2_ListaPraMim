package sistema.comparadores;

import java.util.Comparator;

import sistema.compras.Compra;

public class OrdemAlfabeticaCompra implements Comparator<Compra> {
	@Override
	public int compare(Compra o1, Compra o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}