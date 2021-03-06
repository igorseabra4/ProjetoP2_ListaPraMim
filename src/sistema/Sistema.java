package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

import sistema.produtos.*;
import sistema.comparadores.*;
import sistema.compras.ListaDeCompras;

/**Sistema principal para o gerenciamento do ListaPraMim.
 * 
 * @author Henry Filho
 * @author Igor Seabra
 */
public class Sistema implements Serializable {
	
	private static final long serialVersionUID = 1984916669599846312L;
	private Map<Integer, Produto> produtos;
	private Map<String, ListaDeCompras> listasDeCompras;
	private int currentId;
	private int currentIdLista;

	/**Construtor padrao, inicia um sistema vazio.
	 */
	public Sistema() {
		produtos = new HashMap<Integer, Produto>();
		listasDeCompras = new HashMap<String, ListaDeCompras>();
		currentId = 0;
		currentIdLista = 0;
	}

	/**Adiciona um novo produto com quantidade fixa ao sistema.
	 * 
	 * @param nome O nome do produto.
	 * @param categoria A categoria do produto.
	 * @param qnt A quantidade do produto
	 * @param unidadeDeMedida A unidade de medida da quantidade do produto.
	 * @param localDeCompra O nome do local onde o produto possui o preco.
	 * @param preco O preco do produto no local especificado.
	 * @return O codigo de identificacao unico do produto.
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,	double preco) {
		adicionaItem(new ProdutoQuantidade(currentId + 1, nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco));
		currentId++;
		return currentId;
	}

	/**Adiciona um novo produto não industrializado por quilo ao sistema.
	 * 
	 * @param nome O nome do produto.
	 * @param categoria A categoria do produto.
	 * @param kg A massa do produto em kg.
	 * @param localDeCompra O nome do local onde o produto possui o preco.
	 * @param preco O preco do produto no local especificado.
	 * @return O codigo de identificacao unico do produto.
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		adicionaItem(new ProdutoQuilo(currentId + 1, nome, categoria, kg, localDeCompra, preco));
		currentId++;
		return currentId;
	}

	/**Adiciona um novo produto por unidade ao sistema.
	 * 
	 * @param nome O nome do produto.
	 * @param categoria A categoria do produto.
	 * @param unidade O numero de unidades do produto.
	 * @param localDeCompra O nome do local onde o produto possui o preco.
	 * @param preco O preco do produto no local especificado.
	 * @return O codigo de identificacao unico do produto.
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		adicionaItem(new ProdutoUnidade(currentId + 1, nome, categoria, unidade, localDeCompra, preco));
		currentId++;
		return currentId;
	}
	
	/** Adiciona o produto ao sistema.
	 * 
	 * @param produto Objeto Produto a ser adicionado.
	 */
	private void adicionaItem(Produto produto) {
		if (produtos.containsValue(produto)) {
			throw new IllegalArgumentException("Erro no cadastro de item: item ja cadastrado no sistema.");
		}
		produtos.put(currentId + 1, produto);
	}

	/**Exibe um produto.
	 * 
	 * @param id O codigo de identificacao unico do produto.
	 * @return A representacao em String do produto.
	 */
	public String exibeItem(int id) {
		if (id < 1)
			throw new IllegalArgumentException("Erro na listagem de item: id invalido.");
		if (!produtos.containsKey(id))
			throw new IndexOutOfBoundsException("Erro na listagem de item: item nao existe.");

		return produtos.get(id).toString();
	}

	/**Redefine um atributo de um produto.
	 * 
	 * @param id O codigo de identificacao unico do produto.
	 * @param atributo O atributo a ser redefinido (nome, categoria, quantidade, unidade de medida, massa, quantidade de unidades)
	 * @param novoValor O novo valor a ser atribuido ao atributo.
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		if (!produtos.containsKey(id))
			throw new IllegalArgumentException("Erro na atualizacao de item: item nao existe.");
		if (atributo.trim().isEmpty())
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao pode ser vazio ou nulo.");
		
		produtos.get(id).atualizaItem(atributo, novoValor);
	}

	/**Adiciona um novo local de compra e seu respectivo preco a um item
	 * 
	 * @param id O codigo de identificacao unico do produto.
	 * @param localDeCompra O nome do local onde o produto possui o preco.
	 * @param preco O preco do produto no local especificado.
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		if (id < 1)
			throw new IllegalArgumentException("Erro no cadastro de preco: id de item invalido.");
		if (!produtos.containsKey(id))
			throw new IndexOutOfBoundsException("Erro no cadastro de preco: item nao existe.");

		produtos.get(id).adicionaPrecoItem(localDeCompra, preco);
	}

	/**Remove um item do sistema.
	 * 
	 * @param id O codigo de identificacao unico do produto.
	 */
	public void deletaItem(int id) {
		if (!produtos.containsKey(id))
			throw new IllegalArgumentException("Erro na remocao de item: item nao existe.");

		produtos.remove(id);
	}

	/**Exibe um produto pela posicao em ordem alfabetica.
	 * 
	 * @param posicao A posicao do produto na lista.
	 * @return A representacao em String do produto.
	 */
	public String getItem(int posicao) {
		ArrayList<Produto> novaOrdenacao = new ArrayList<Produto>();
		novaOrdenacao.addAll(produtos.values());

		if (posicao < 0 | posicao >= novaOrdenacao.size())
			return "";

		novaOrdenacao.sort(new OrdemAlfabeticaProduto());
		return novaOrdenacao.get(posicao).toString();
	}

	/**Exibe um produto pela posicao em ordem alfabetica dentro da categoria especificada.
	 * 
	 * @param categoria A categoria a ser consultada.
	 * @param posicao A posicao do produto na lista da categoria.
	 * @return A representacao em String do produto.
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		if (!categoria.equals("alimento industrializado") && !categoria.equals("alimento nao industrializado")
				&& !categoria.equals("limpeza") && !categoria.equals("higiene pessoal"))
			throw new IllegalArgumentException("Erro na listagem de item: categoria nao existe.");

		ArrayList<Produto> novaOrdenacao = new ArrayList<Produto>();
		for (Produto p : produtos.values()) {
			if (p.getCategoria().equals(categoria))
				novaOrdenacao.add(p);
		}

		if (posicao < 0 | posicao >= novaOrdenacao.size())
			return "";

		novaOrdenacao.sort(new OrdemAlfabeticaProduto());
		return novaOrdenacao.get(posicao).toString();
	}

	/**Exibe um produto pela posicao na lista ordenada pelo menor preco.
	 * 
	 * @param posicao A posicao do produto na lista da categoria.
	 * @return A representacao em String do produto.
	 */
	public String getItemPorMenorPreco(int posicao) {
		ArrayList<Produto> novaOrdenacao = new ArrayList<Produto>();
		novaOrdenacao.addAll(produtos.values());

		if (posicao < 0 | posicao >= novaOrdenacao.size())
			return "";

		novaOrdenacao.sort(new OrdemPrecoProduto());
		return novaOrdenacao.get(posicao).toString();
	}

	/**Exibe um produto pela posicao em ordem alfabetica dentro dos produtos cujo nome contem uma string de pesquisa.
	 * 
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

		if (posicao < 0 | posicao >= novaOrdenacao.size())
			return "";

		novaOrdenacao.sort(new OrdemAlfabeticaProduto());
		return novaOrdenacao.get(posicao).toString();
	}

	/**Adiciona uma nova lista de compras vazia ao sistema com o descritor especificado.
	 * 
	 * @param descritorLista O descritor (nome) da lista.
	 * @return O descritor (nome) da lista.
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		if (descritorLista.trim().isEmpty())
			throw new IllegalArgumentException("Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		if (listasDeCompras.containsKey(descritorLista))
			throw new IllegalArgumentException("Lista de compras ja existe");
		
		currentIdLista++;
		listasDeCompras.put(descritorLista, new ListaDeCompras(descritorLista, dataAtual(), currentIdLista));
		
		return descritorLista;
	}

	/**Pesquisa a lista de compras pelo seu descritor.
	 * 
	 * @param descritorLista O descritor (nome) da lista existente.
	 * @return O descritor (nome) da lista caso ela exista no sistema.
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		if (descritorLista.trim().isEmpty())
			throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		if (!listasDeCompras.containsKey(descritorLista))
			throw new IllegalArgumentException("Erro na pesquisa de compra: lista de compras nao existe.");
		
		return descritorLista;
	}

	/**Adiciona um novo produto a lista de compras.
	 * 
	 * @param descritorLista O descritor (nome) da lista.
	 * @param quantidade A quantidade do produto.
	 * @param itemId O codigo de identificacao unico do produto.
	 */
	public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
		if (descritorLista.trim().isEmpty())
			throw new IllegalArgumentException("Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		if (!listasDeCompras.containsKey(descritorLista))
			throw new IllegalArgumentException("Lista de compras nao existe");
		if (itemId < 1)
			throw new IllegalArgumentException("Erro no cadastro de preco: id de item invalido.");
		if (!produtos.containsKey(itemId))
			throw new IndexOutOfBoundsException("Erro na compra de item: item nao existe no sistema.");
		
		listasDeCompras.get(descritorLista).adicionaCompra(quantidade, produtos.get(itemId));
	}
	
	/**Finaliza uma lista de compras.
	 * 
	 * @param descritorLista O descritor (nome) da lista.
	 * @param localDaCompra O local onde foi feita a compra.
	 * @param valorFinalDaCompra O valor final da compra.
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, double valorFinalDaCompra) {
		if (descritorLista.trim().isEmpty())
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		if (localDaCompra.trim().isEmpty())
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
		if (valorFinalDaCompra <= 0)
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: valor final da lista invalido.");
		if (!listasDeCompras.containsKey(descritorLista))
			throw new IllegalArgumentException("Lista de compras nao existe");

		listasDeCompras.get(descritorLista).finalizarListaDeCompras(localDaCompra, valorFinalDaCompra);
	}

	/**Pesquisa um produto comprado em uma lista.
	 * 
	 * @param descritorLista O descritor (nome) da lista.
	 * @param itemId O codigo de identificacao unico do produto.
	 * @return A Representacao em String do produto.
	 */
	public String pesquisaCompraEmLista(String descritorLista, int itemId) {
		if (descritorLista.trim().isEmpty())
			throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		if (itemId < 1)
			throw new IndexOutOfBoundsException("Erro na pesquisa de compra: item id invalido.");
		if (!listasDeCompras.containsKey(descritorLista))
			throw new IllegalArgumentException("lista de compras nao existe");
		
		return listasDeCompras.get(descritorLista).pesquisaCompraEmLista(itemId);
	}

	/**Pesquisa um produto comprado em uma lista pela sua posicao nela.
	 * 
	 * @param descritorLista O descritor (nome) da lista.
	 * @param posicaoItem A posicao do item na lista.
	 * @return A Representacao em String do produto.
	 */
	public String getItemLista(String descritorLista, int posicaoItem) {
		if (!listasDeCompras.containsKey(descritorLista))
			throw new IllegalArgumentException("lista de compras nao existe");

		return listasDeCompras.get(descritorLista).getItemLista(posicaoItem);
	}

	/**Remove uma compra de uma lista.
	 * 
	 * @param descritorLista O descritor (nome) da lista.
	 * @param itemId O codigo de identificacao unico do produto.
	 */
	public void deletaCompraDeLista(String descritorLista, int itemId) {
		if (descritorLista.trim().isEmpty())
			throw new IllegalArgumentException("Erro na exclusao de compra: descritor nao pode ser vazio ou nulo.");
		if (!listasDeCompras.containsKey(descritorLista))
			throw new IllegalArgumentException("Erro na exclusao de compra: lista de compras nao existe");
		if (itemId < 1)
			throw new IndexOutOfBoundsException("Erro na exclusao de compra: item id invalido.");
		if (!produtos.containsKey(itemId))
			throw new IndexOutOfBoundsException("Erro na exclusao de compra: item nao existe no sistema.");
		
		listasDeCompras.get(descritorLista).deletaCompra(itemId);
	}

	/**Atualiza a quantidade de um item de uma lista.
	 * 
	 * @param descritorLista O descritor (nome) da lista.
	 * @param itemId O codigo de identificacao unico do produto.
	 * @param quantidade A nova quantidade do produto.
	 */
	public void atualizaCompraDeLista(String descritorLista, int itemId, String operacao, int quantidade) {
		if (!listasDeCompras.containsKey(descritorLista))
			throw new IllegalArgumentException("lista de compras nao existe");

		listasDeCompras.get(descritorLista).atualizaCompraDeLista(itemId, operacao, quantidade);
	}

	/**Retorna uma lista de compras pela data e indice na lista de listas de compras daquela data.
	 * 
	 * @param data A data da lista de compras.
	 * @param posicaoLista A posicao da lista de compras na lista daquela data.
	 * @return O descritor (nome) da lista.
	 */
	public String getItemListaPorData(String data, int posicaoLista) {
		if (data.trim().isEmpty())
			throw new IllegalArgumentException("Erro na pesquisa de compra: data nao pode ser vazia ou nula.");
		
		ArrayList<ListaDeCompras> listas = new ArrayList<ListaDeCompras>();
		
		for (ListaDeCompras lista : listasDeCompras.values()) {
			if (lista.getData().equals(data))
				listas.add(lista);
		}
		
		listas.sort(new OrdemAlfabeticaLista());
		
		return listas.get(posicaoLista).getDescritor();
	}

	/**Retorna uma lista de compras pela presenca de um item naquela lista e indice na lista de listas.
	 * 
	 * @param id O codigo de identificacao unico do produto.
	 * @param posicaoLista A posicao da lista de compras na lista das que contem aquele produto.
	 * @return O descritor (nome) da lista.
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		if (id < 1)
			throw new IndexOutOfBoundsException("Erro na pesquisa de compra: item id invalido.");
		if (!produtos.containsKey(id))
			throw new IndexOutOfBoundsException("Erro na pesquisa de compra: item nao existe no sistema.");
		
		ArrayList<ListaDeCompras> listas = new ArrayList<ListaDeCompras>();
		
		for (ListaDeCompras lista : listasDeCompras.values()) {
			if (lista.contemProduto(id))
				listas.add(lista);
		}

		listas.sort(new OrdemAlfabeticaLista());
		listas.sort(new OrdemDataLista());
		
		return  listas.get(posicaoLista).getData() + " - " + listas.get(posicaoLista).getDescritor();
	}

	/**Retorna a data atual em String.
	 * 
	 * @return A data atual.
	 */
	public String dataAtual() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now());
	}

	/**Retorna as listas de compras feitas na data especificada.
	 * 
	 * @param data A data das listas.
	 * @return Representacao em String das listas de compras feitas na data especificada.
	 */
	public String pesquisaListasDeComprasPorData(String data) {
		if (data.trim().isEmpty())
			throw new IllegalArgumentException("Erro na pesquisa de compra: data nao pode ser vazia ou nula.");
		
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dtf.parse(data);
		}catch (Exception e) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: data em formato invalido, tente dd/MM/yyyy");			
		}
		
		String retorno = "";		
		for (ListaDeCompras l : listasDeCompras.values()) {
			if (l.getData().equals(data))
				retorno += l.toString() + "\n";
		}
		
		return retorno;
	}

	/**Retorna as listas de compras que contem o produto especificado.
	 * 
	 * @param id O codigo de identificacao unico do produto.
	 * @return Representacao em String das listas de compras feitas na data especificada.
	 */
	public String pesquisaListasDeComprasPorItem(int id) {
		String retorno = "";
		
		for (ListaDeCompras l : listasDeCompras.values()) {
			if (l.contemProduto(id))
				retorno += l.toString() + "\n";
		}
		if (retorno != "")
			return retorno;
		
		throw new RuntimeException("Erro na pesquisa de compra: compra nao encontrada na lista.");
	}

	/**Gera uma nova lista de compras copiando a ultima lista criada.
	 * 
	 * @return O descritor (nome) da lista.
	 */
	public String geraAutomaticaUltimaLista() {
		String novoDescritor = "Lista automatica 1 " + dataAtual();
		String temp = null;
		
		for(ListaDeCompras l : listasDeCompras.values())
			if(l.getID() == currentIdLista)
				temp = l.getDescritor();
		
		currentIdLista++;
		listasDeCompras.put(novoDescritor, new ListaDeCompras(listasDeCompras.get(temp), novoDescritor, dataAtual(), currentIdLista));
		
		return novoDescritor;
	}

	/**Gera uma nova lista de compras copiando a ultima lista criada que contem um item especificado.
	 * 
	 * @param nome O nome do item desejado.
	 * @return O descritor (nome) da lista.
	 */
	public String geraAutomaticaItem(String nome) {
		ArrayList<ListaDeCompras> listasOrdem = new ArrayList<ListaDeCompras>();
		listasOrdem.addAll(listasDeCompras.values());
		listasOrdem.sort(new OrdemCadastroLista());
		
		for (int i = listasOrdem.size() - 1; i >= 0; i--) {
			if (listasOrdem.get(i).contemProduto(nome)) {
				String novoDescritor = "Lista automatica 2 " + dataAtual();
				currentIdLista++;
				listasDeCompras.put(novoDescritor, new ListaDeCompras(listasOrdem.get(i), novoDescritor, dataAtual(), currentIdLista));
				
				return novoDescritor;
			}
		}
		
		throw new IllegalArgumentException("Erro na geracao de lista automatica por item: nao ha compras cadastradas com o item desejado.");
	}

	/**Gera uma nova lista de compras com as compras presentes em maior quantidade nas listas existentes.
	 * 
	 * @return O descritor (nome) da lista.
	 */
	public String geraAutomaticaItensMaisPresentes() {
		// Nesse hashmap que sera criado, a chave eh a ID do produto, o valor eh uma tupla com dois inteiros: o X eh a quantidade
		// de listas na qual aquele item aparece; o Y eh a quantidade total do item somando-o em todas as listas.
		HashMap<Integer, Tupla> quantidadeParaCadaProduto = new HashMap<Integer, Tupla>();
		
		for (int i : produtos.keySet())
			quantidadeParaCadaProduto.put(i, new Tupla(0, 0));
						
		for (ListaDeCompras lista : listasDeCompras.values()) {
			for (Tupla t : lista.getTuplas()) {
				// Nas tuplas retornadas pela ListaDeCompras, o X eh a id do produto e o Y eh a quantidade daquele produto na lista.
				
				quantidadeParaCadaProduto.get(t.getX()).addX(1);
				quantidadeParaCadaProduto.get(t.getX()).addY(t.getY());
			}
		}
		
		String novoDescritor = "Lista automatica 3 " + dataAtual();
		currentIdLista++;
		ListaDeCompras novaLista = new ListaDeCompras(novoDescritor, dataAtual(), currentIdLista);
		
		double qtdNecessaria = listasDeCompras.values().size() / 2.0d;
		for (int i : quantidadeParaCadaProduto.keySet()) {
			if (quantidadeParaCadaProduto.get(i).getX() >= qtdNecessaria) {
				int qtdNovaDoProduto = (int)Math.floor((double)quantidadeParaCadaProduto.get(i).getY() / quantidadeParaCadaProduto.get(i).getX());
				
				novaLista.adicionaCompra(qtdNovaDoProduto, produtos.get(i));
			}
		}
				
		listasDeCompras.put(novoDescritor, novaLista);
		
		return novoDescritor;
	}

	/**Sugere o melhor estabelecimento para realizacao de uma lista de compras.
	 * 
	 * @param descritorLista O descritor (nome) da lista para a qual se deseja obter o estabelecimento
	 * @param posicaoEstabelecimento O indice do estabelecimento na ordem obtida (por preco).
	 * @param posicaoLista A posicao do item na lista do estabelecimento.
	 * @return Representacao em String do estabelecimento ou produto pesquisado.
	 */
	public String sugereMelhorEstabelecimento(String descritorLista, int posicaoEstabelecimento, int posicaoLista) {
		try {
			List<ListaDeCompras> locaisDeCompra = listasDeCompras.get(descritorLista).subListasComLocal();

			locaisDeCompra.sort(new OrdemMaiorValorTotalLista());
			
			if (posicaoLista == 0)
				return locaisDeCompra.get(posicaoEstabelecimento).getDescritor()
					+ ": R$ " + new DecimalFormat("#.0#").format(locaisDeCompra.get(posicaoEstabelecimento).getValorTotal());

			String r = locaisDeCompra.get(posicaoEstabelecimento).getItemLista(posicaoLista - 1);
						
			return r == "" ? "" :  "- " + r;
		}catch (Exception e){
			throw new RuntimeException("Faltam dados para informar sobre precos em locais de compras.");
		}
	}
}
