package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import sistema.produtos.*;
import sistema.comparadores.*;

public class Sistema {
	private Map<Integer, Produto> produtos;
	private int currentId;
	
	public Sistema() {
		produtos = new HashMap<Integer, Produto>();
		currentId = 0;
	}
	
	/**Adiciona um novo produto com quantidade fixa ao sistema.
	 * @param nome O nome do produto.
	 * @param categoria A categoria do produto.
	 * @param qnt A quantidade do produto
	 * @param unidadeDeMedida A unidade de medida da quantidade do produto.
	 * @param localDeCompra O nome do local onde o produto possui o preco.
	 * @param preco O preco do produto no local especificado.
	 * @return O codigo de identificacao unico do produto.
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra, double preco) {
		currentId++;
		produtos.put(currentId, new ProdutoQuantidade(currentId, nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco));
		return currentId;
	}

	/**Adiciona um novo produto não industrializado por quilo ao sistema.
	 * @param nome O nome do produto.
	 * @param categoria A categoria do produto.
	 * @param kg A massa do produto em kg.
	 * @param localDeCompra O nome do local onde o produto possui o preco.
	 * @param preco O preco do produto no local especificado.
	 * @return O codigo de identificacao unico do produto.
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		currentId++;
		produtos.put(currentId, new ProdutoQuilo(currentId, nome, categoria, kg, localDeCompra, preco));
		return currentId;
	}

	/**Adiciona um novo produto por unidade ao sistema.
	 * @param nome O nome do produto.
	 * @param categoria A categoria do produto.
	 * @param unidade O numero de unidades do produto.
	 * @param localDeCompra O nome do local onde o produto possui o preco.
	 * @param preco O preco do produto no local especificado.
	 * @return O codigo de identificacao unico do produto.
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		currentId++;
		produtos.put(currentId, new ProdutoUnidade(currentId, nome, categoria, unidade, localDeCompra, preco));
		return currentId;
	}

	/**Exibe um produto.
	 * @param id O codigo de identificacao unico do produto.
	 * @return A representacao em String do produto.
	 */
	public String exibeItem(int id) {
		if (id < 1) throw new IllegalArgumentException("Erro na listagem de item: id invalido.");
		if (!produtos.containsKey(id)) throw new IndexOutOfBoundsException("Erro na listagem de item: item nao existe.");

		return produtos.get(id).toString();
	}

	/**Redefine um atributo de um produto.
	 * @param id O codigo de identificacao unico do produto.
	 * @param atributo O atributo a ser redefinido (nome, categoria, quantidade, unidade de medida, massa, quantidade de unidades)
	 * @param novoValor O novo valor a ser atribuido ao atributo.
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		if (!produtos.containsKey(id)) throw new IllegalArgumentException("Erro na atualizacao de item: item nao existe.");
		
		produtos.get(id).atualizaItem(atributo, novoValor);
	}

	/**Adiciona um novo local de compra e seu respectivo preco a um item
	 * @param id O codigo de identificacao unico do produto.
	 * @param localDeCompra O nome do local onde o produto possui o preco.
	 * @param preco O preco do produto no local especificado.
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		if (id < 1) throw new IllegalArgumentException("Erro no cadastro de preco: id de item invalido.");
		if (!produtos.containsKey(id)) throw new IndexOutOfBoundsException("Erro no cadastro de preco: item nao existe.");
		
		produtos.get(id).adicionaPrecoItem(localDeCompra, preco);
	}

	/**Remove um item do sistema.
	 * @param id O codigo de identificacao unico do produto.
	 */
	public void deletaItem(int id) {
		if (!produtos.containsKey(id)) throw new IllegalArgumentException();
		
		produtos.remove(id);
	}

	/** Exibe um produto pela posicao em ordem alfabetica.
	 * @param posicao A posicao do produto na lista.
	 * @return A representacao em String do produto.
	 */
	public String getItem(int posicao) {
		ArrayList<Produto> novaOrdenacao = new ArrayList<Produto>();
		novaOrdenacao.addAll(produtos.values());
		
		if (posicao < 0 | posicao >= novaOrdenacao.size()) return "";
		
		novaOrdenacao.sort(new OrdemAlfabetica());
		return novaOrdenacao.get(posicao).toString();
	}

	/**Exibe um produto pela posicao em ordem alfabetica dentro da categoria especificada.
	 * @param categoria A categoria a ser consultada.
	 * @param posicao A posicao do produto na lista da categoria.
	 * @return A representacao em String do produto.
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		ArrayList<Produto> novaOrdenacao = new ArrayList<Produto>();
		for (Produto p : produtos.values()) {
			if (p.getCategoria().equals(categoria))
				novaOrdenacao.add(p);
		}
		
		if (posicao < 0 | posicao >= novaOrdenacao.size()) return "";
		
		novaOrdenacao.sort(new OrdemAlfabetica());
		return novaOrdenacao.get(posicao).toString();
	}

	/**Exibe um produto pela posicao na lista ordenada pelo menor preco.
	 * @param posicao A posicao do produto na lista da categoria.
	 * @return A representacao em String do produto.
	 */
	public String getItemPorMenorPreco(int posicao) {
		ArrayList<Produto> novaOrdenacao = new ArrayList<Produto>();
		novaOrdenacao.addAll(produtos.values());

		if (posicao < 0 | posicao >= novaOrdenacao.size()) return "";
		
		novaOrdenacao.sort(new OrdemPreco());
		return novaOrdenacao.get(posicao).toString();
	}

	/**Exibe um produto pela posicao em ordem alfabetica dentro dos produtos cujo nome contem uma string de pesquisa.
	 * @param strPesquisada A string de pesquisa.
	 * @param posicao A posicao do produto na lista da categoria.
	 * @return A representacao em String do produto.
	 */
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		ArrayList<Produto> novaOrdenacao = new ArrayList<Produto>();
		for (Produto p : produtos.values()) {
			if (p.contemStringPesquisada(strPesquisada))
				novaOrdenacao.add(p);
		}
		
		if (posicao < 0 | posicao >= novaOrdenacao.size()) return "";
		
		novaOrdenacao.sort(new OrdemAlfabetica());
		return novaOrdenacao.get(posicao).toString();
	}
}