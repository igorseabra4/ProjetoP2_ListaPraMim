package sistema.comparadores;

import java.util.Comparator;

import sistema.compras.Produtos;

public class OrdemAlfabetica implements Comparator<Produtos> {
	@Override
	public int compare(Produtos o1, Produtos o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}