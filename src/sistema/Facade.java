package sistema;

import easyaccept.EasyAccept;

public class Facade {
	public static void main(String[] args) {
		args = new String[] {"sistema.Facade",
				"acception_tests/use_case1.txt",
				"acception_tests/use_case1_exception.txt",
				"acception_tests/use_case2.txt",
				"acception_tests/use_case2_exception.txt",
				"acception_tests/use_case3.txt",
				"acception_tests/use_case3_exception.txt"};
		
		EasyAccept.main(args);
	}
	
	private Sistema sistema = new Sistema();

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
		return sistema.adicionaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
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
		return sistema.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
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
		return sistema.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}
	
	/**Exibe um produto.
	 * @param id O codigo de identificacao unico do produto.
	 * @return A representacao em String do produto.
	 */
	public String exibeItem(int id) {
		return sistema.exibeItem(id);
	}
	
	/**Redefine um atributo de um produto.
	 * @param id O codigo de identificacao unico do produto.
	 * @param atributo O atributo a ser redefinido (nome, categoria, quantidade, unidade de medida, massa, quantidade de unidades)
	 * @param novoValor O novo valor a ser atribuido ao atributo.
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		sistema.atualizaItem(id, atributo, novoValor);
	}
	
	/**Adiciona um novo local de compra e seu respectivo preco a um item
	 * @param id O codigo de identificacao unico do produto.
	 * @param localDeCompra O nome do local onde o produto possui o preco.
	 * @param preco O preco do produto no local especificado.
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		sistema.adicionaPrecoItem(id, localDeCompra, preco);
	}
	
	/**Remove um item do sistema.
	 * @param id O codigo de identificacao unico do produto.
	 */
	public void deletaItem(int id) {
		sistema.deletaItem(id);
	}
	
	/**Exibe um produto pela posicao em ordem alfabetica.
	 * @param posicao A posicao do produto na lista.
	 * @return A representacao em String do produto.
	 */
	public String getItem(int posicao) {
		return sistema.getItem(posicao);
	}
	
	/**Exibe um produto pela posicao em ordem alfabetica dentro da categoria especificada.
	 * @param categoria A categoria a ser consultada.
	 * @param posicao A posicao do produto na lista da categoria.
	 * @return A representacao em String do produto.
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		return sistema.getItemPorCategoria(categoria, posicao);
	}
	
	/**Exibe um produto pela posicao na lista ordenada pelo menor preco.
	 * @param posicao A posicao do produto na lista da categoria.
	 * @return A representacao em String do produto.
	 */
	public String getItemPorMenorPreco(int posicao) {
		return sistema.getItemPorMenorPreco(posicao);
	}

	/**Exibe um produto pela posicao em ordem alfabetica dentro dos produtos cujo nome contem uma string de pesquisa.
	 * @param strPesquisada A string de pesquisa.
	 * @param posicao A posicao do produto na lista da categoria.
	 * @return A representacao em String do produto.
	 */
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		return sistema.getItemPorPesquisa(strPesquisada, posicao);
	}
	
	public String adicionaListaDeCompras(String descritorLista) {
		return sistema.adicionaListaDeCompras(descritorLista);
	}
	
	public String pesquisaListaDeCompras(String descritorLista) {
		return sistema.pesquisaListaDeCompras(descritorLista);
	}

	public void adicionaCompraALista(String descritorLista, double quantidade, int itemId) {
		sistema.adicionaCompraALista(descritorLista, quantidade, itemId);
	}
	
	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, double valorFinalDaCompra) {
		sistema.finalizarListaDeCompras(descritorLista, localDaCompra, valorFinalDaCompra);		
	}

	public String pesquisaCompraEmLista(String descritorLista, int itemId) {
		return sistema.pesquisaCompraEmLista(descritorLista, itemId);
	}

	public String getItemLista(String descritorLista, int posicaoItem) {
		return sistema.getItemLista(descritorLista, posicaoItem);
	}

	public void deletaCompraDeLista(String descritorLista, int itemId) {
		sistema.deletaCompraDeLista(descritorLista, itemId);
	}
	
}