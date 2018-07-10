package sistema;

import java.util.HashMap;
import java.util.Map;

import sistema.produtos.*;

public class Sistema {
	private Map<Integer, Produto> produtos;
	private int currentId;
	
	public Sistema() {
		produtos = new HashMap<Integer, Produto>();
		currentId = 0;
	}

	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra, double preco) {
		currentId++;
		produtos.put(currentId, new ProdutoQuantidade(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco));
		return currentId;
	}

	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		currentId++;
		produtos.put(currentId, new ProdutoQuilo(nome, categoria, kg, localDeCompra, preco));
		return currentId;
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		currentId++;
		produtos.put(currentId, new ProdutoUnidade(nome, categoria, unidade, localDeCompra, preco));
		return currentId;
	}

	public String exibeItem(int id) {
		if (!produtos.containsKey(id)) throw new IllegalArgumentException("Erro na listagem de item: item nao existe.");

		return produtos.get(id).toString();
	}

	public void atualizaItem(int id, String atributo, String novoValor) {
		if (!produtos.containsKey(id)) throw new IllegalArgumentException("Erro na atualizacao de item: item nao existe.");
		
		produtos.get(id).atualizaItem(atributo, novoValor);
	}

	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		if (!produtos.containsKey(id)) throw new IllegalArgumentException();
		
		produtos.get(id).adicionaPrecoItem(localDeCompra, preco);
	}

	public void deletaItem(int id) {
		if (!produtos.containsKey(id)) throw new IllegalArgumentException();
		
		produtos.remove(id);
	}
}
