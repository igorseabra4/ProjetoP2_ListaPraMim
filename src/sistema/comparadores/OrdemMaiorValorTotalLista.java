package sistema.comparadores;

import java.util.Comparator;

import sistema.compras.ListaDeCompras;

public class OrdemMaiorValorTotalLista implements Comparator<ListaDeCompras> {
	@Override
	public int compare(ListaDeCompras o1, ListaDeCompras o2) {
		return (int) (o1.getValorTotal() - o2.getValorTotal());
	}
}