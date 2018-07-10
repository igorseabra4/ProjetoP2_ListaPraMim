package sistema.comparadores;
package comparadores;

import java.util.Comparator;

import sistema_de_apostas.Cenario;

public class CenarioCompareQtdApostas implements Comparator<Cenario> {
}


import java.util.Comparator;

import sistema.produtos.Produto;

public class OrdemPreco implements Comparator<Produto> {
	@Override
	public int compare(Produto o1, Produto o2) {
		if (o1.getMenorPreco() < o2.getMenorPreco()) return 1;
		else if (o1.getMenorPreco() > o2.getMenorPreco()) return -1;
		else return 0;
	}
}