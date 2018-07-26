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
				"acception_tests/use_case3_exception.txt",
				"acception_tests/use_case4.txt",
				"acception_tests/use_case4_exception.txt",
				"acception_tests/use_case5.txt",
				"acception_tests/use_case6.txt",
				"acception_tests/use_case6_exception.txt",
				"acception_tests/use_case7.txt"};
		
		EasyAccept.main(args);
	}
	
	private Sistema sistema;

	public void iniciaSistema() {
		sistema = new Sistema();
	}
	
	public void fechaSistema() {
		sistema.finalizar();
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
	
	/**Adiciona uma nova lista de compras vazia ao sistema com o descritor especificado.
	 * @param descritorLista O descritor (nome) da lista.
	 * @return O descritor (nome) da lista.
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		return sistema.adicionaListaDeCompras(descritorLista);
	}
	
	/**Pesquisa a lista de compras pelo seu descritor.
	 * @param descritorLista O descritor (nome) da lista existente.
	 * @return O descritor (nome) da lista caso ela exista no sistema.
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		return sistema.pesquisaListaDeCompras(descritorLista);
	}

	/**Adiciona um novo produto a lista de compras.
	 * @param descritorLista O descritor (nome) da lista.
	 * @param quantidade A quantidade do produto.
	 * @param itemId O codigo de identificacao unico do produto.
	 */
	public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
		sistema.adicionaCompraALista(descritorLista, quantidade, itemId);
	}
	
	/**Finaliza uma lista de compras.
	 * @param descritorLista O descritor (nome) da lista.
	 * @param localDaCompra O local onde foi feita a compra.
	 * @param valorFinalDaCompra O valor final da compra.
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, double valorFinalDaCompra) {
		sistema.finalizarListaDeCompras(descritorLista, localDaCompra, valorFinalDaCompra);		
	}

	/**Pesquisa um produto comprado em uma lista.
	 * @param descritorLista O descritor (nome) da lista.
	 * @param itemId O codigo de identificacao unico do produto.
	 * @return A representação em String do produto.
	 */
	public String pesquisaCompraEmLista(String descritorLista, int itemId) {
		return sistema.pesquisaCompraEmLista(descritorLista, itemId);
	}

	/**Pesquisa um produto comprado em uma lista pela sua posiçao nela.
	 * @param descritorLista O descritor (nome) da lista.
	 * @param posicaoItem A posicao do item na lista.
	 * @return A representação em String do produto.
	 */
	public String getItemLista(String descritorLista, int posicaoItem) {
		return sistema.getItemLista(descritorLista, posicaoItem);
	}

	/**Remove uma compra de uma lista.
	 * @param descritorLista O descritor (nome) da lista.
	 * @param itemId O codigo de identificacao unico do produto.
	 */
	public void deletaCompraDeLista(String descritorLista, int itemId) {
		sistema.deletaCompraDeLista(descritorLista, itemId);
	}
	
	/**Atualiza a quantidade de um item de uma lista.
	 * @param descritorLista O descritor (nome) da lista.
	 * @param itemId O codigo de identificacao unico do produto.
	 * @param quantidade A nova quantidade do produto.
	 */
	public void atualizaCompraDeLista(String descritorLista, int itemId, String operacao, int quantidade) {
		sistema.atualizaCompraDeLista(descritorLista, itemId, operacao, quantidade);		
	}

	/**Retorna uma lista de compras pela data e indice na lista de listas de compras daquela data.
	 * @param data A data da lista de compras.
	 * @param posicaoLista A posicao da lista de compras na lista daquela data.
	 * @return O descritor (nome) da lista.
	 */
	public String getItemListaPorData(String data, int posicaoLista) {
		return sistema.getItemListaPorData(data, posicaoLista);
	}

	/**Retorna uma lista de compras pela presenca de um item naquela lista e indice na lista de listas.
	 * @param id O codigo de identificacao unico do produto.
	 * @param posicaoLista A posicao da lista de compras na lista das que contem aquele produto.
	 * @return O descritor (nome) da lista.
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		return sistema.getItemListaPorItem(id, posicaoLista);
	}
	
	/**A data atual
	 * @return A data atual.
	 */
	public String dataAtual() {
		return sistema.dataAtual();
	}

	/**Retorna as listas de compras feitas na data especificada.
	 * @param data A data das listas.
	 * @return Representação em String das listas de compras feitas na data especificada.
	 */
	public String pesquisaListasDeComprasPorData(String data) {
		return sistema.pesquisaListasDeComprasPorData(data);
	}

	/**Retorna as listas de compras que contém o produto especificado.
	 * @param id O codigo de identificacao unico do produto.
	 * @return Representação em String das listas de compras feitas na data especificada.
	 */
	public String pesquisaListasDeComprasPorItem(int id) {
		return sistema.pesquisaListasDeComprasPorItem(id);
	}

	public String geraAutomaticaUltimaLista() {
		return sistema.geraAutomaticaUltimaLista();		
	}
	
	public String geraAutomaticaItem(String nome) {
		return sistema.geraAutomaticaItem(nome);		
	}
	
	public String geraAutomaticaItensMaisPresentes() {
		return sistema.geraAutomaticaItensMaisPresentes();		
	}
	
	public String sugereMelhorEstabelecimento(String descritorLista, int posicaoEstabelecimento, int posicaoLista) {
		return sistema.sugereMelhorEstabelecimento(descritorLista, posicaoEstabelecimento, posicaoLista);		
	}
}