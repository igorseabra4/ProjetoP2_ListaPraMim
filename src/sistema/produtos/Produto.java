package sistema.produtos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class Produto {

	private int id;
	private String nome;
	private Categorias categoria;
	private Map<String,Double> precos;
	
	public Produto(int id, String nome, String categoria, String localDeCompra, double preco) {
		if(nome.trim().equals("") || nome.equals(null))
			throw new NullPointerException("Erro no cadastro de item: nome nao pode ser vazio ou nulo.");
		if(categoria.trim().equals("") || categoria.equals(null))
			throw new NullPointerException("Erro no cadastro de item: categoria nao pode ser vazia ou nula.");
		if(localDeCompra.trim().equals("") || localDeCompra.equals(null))
			throw new NullPointerException("Erro no cadastro de item: local de compra nao pode ser vazio ou nulo.");
		if(preco < 0)
			throw new IllegalArgumentException("Erro no cadastro de item: preco de item invalido.");
		
		this.id = id;
		this.nome = nome;
		
		try {
			atualizaCategoria(categoria);
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de item" + e.getMessage());
		}
		
		precos = new HashMap<>();
		precos.put(localDeCompra, preco);
	}

	public void atualizaItem(String atributo, String novoValor) {
		if(atributo.trim().equals("") || atributo.equals(null))
			throw new NullPointerException("Erro na atualizacao de item: atributo nao pode ser vazio ou nulo.");
		if(novoValor.trim().equals("") || novoValor.equals(null))
			throw new NullPointerException("Erro na atualizacao de item: novo valor de atributo nao pode ser vazio ou nulo.");
		
		if(atributo.equals("nome"))
			nome = novoValor;
		else if(atributo.equals("categoria")) {
			try {
				atualizaCategoria(novoValor);
			}catch(IllegalArgumentException e) {
				throw new IllegalArgumentException("Erro na atualizacao de item" + e.getMessage());
			}
		}
		else throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao existe.");
	}

	private void atualizaCategoria(String novoValor) {
		if (novoValor.equals("alimento industrializado"))
			categoria = Categorias.ALIM_INDUSTR;
		else if(novoValor.equals("alimento nao industrializado"))
			categoria = Categorias.ALIM_NAO_INDUSTR;
		else if(novoValor.equals("limpeza"))
			categoria = Categorias.LIMPEZA;
		else if(novoValor.equals("higiene pessoal"))
			categoria = Categorias.HIGIENE_PESSOAL;
		else throw new IllegalArgumentException(": categoria nao existe.");
	}
	
	public void adicionaPrecoItem(String localDeCompra, double preco) {
		if(localDeCompra.trim().equals("") || localDeCompra.equals(null))
			throw new NullPointerException("Erro no cadastro de preco: local de compra nao pode ser vazio ou nulo.");
		if(preco < 0)
			throw new IllegalArgumentException("Erro no cadastro de preco: preco de item invalido.");
		
		if(precos.containsKey(localDeCompra))
				precos.replace(localDeCompra, preco);
		else precos.put(localDeCompra, preco);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCategoria() {
		if(categoria == Categorias.ALIM_INDUSTR)
			return "alimento industrializado";
		if(categoria == Categorias.ALIM_NAO_INDUSTR)
			return "alimento nao industrializado";
		if(categoria == Categorias.LIMPEZA)
			return "limpeza";
		if(categoria == Categorias.HIGIENE_PESSOAL)
			return "higiene pessoal";
		return null;
	}
	
	public double getMenorPreco() {
		double menor = Double.MAX_VALUE;
		for(double preco : precos.values()) {
			if(preco < menor)
				menor = preco;
		}return menor;
	}
	
	public boolean contemStringPesquisada(String string) {
		return nome.toLowerCase().contains(string.toLowerCase());
	}
	
	@Override
	public String toString() {
		//Algodão Clemer, higiene pessoal, 300 gramas, Preco: <Supermercado BaratoD+, R$ 2,33;  Baratão, R$ 2,30>
		String resultado = String.format("%d. %s, %s, %s: <", id, nome, getCategoria(), toStringValues());
		
		Iterator<String> itr = precos.keySet().iterator();
		while(itr.hasNext()) {
			String value = itr.next();
			resultado += String.format("%s, R$ %.2f;", value, precos.get(value));
		}resultado += ">";
		
		return resultado;
	}
	
	protected abstract String toStringValues();
}
