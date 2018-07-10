package sistema.comparadores;

import java.util.Comparator;
import sistema.produtos.Produto;

public class OrdemAlfabetica implements Comparator<Produto> {
	@Override
	public int compare(Produto o1, Produto o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}