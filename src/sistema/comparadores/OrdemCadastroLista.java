package sistema.comparadores;

import java.util.Comparator;

import sistema.compras.ListaDeCompras;

public class OrdemCadastroLista implements Comparator<ListaDeCompras> {
	@Override
	public int compare(ListaDeCompras o1, ListaDeCompras o2) {
		return o1.getID() - o2.getID();
	}

}
