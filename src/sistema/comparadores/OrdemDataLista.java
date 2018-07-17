package sistema.comparadores;

import java.util.Comparator;

import sistema.compras.ListaDeCompras;

public class OrdemDataLista implements Comparator<ListaDeCompras> {
	@Override
	public int compare(ListaDeCompras o1, ListaDeCompras o2) {
		return o1.getData().compareTo(o2.getData());
	}
}