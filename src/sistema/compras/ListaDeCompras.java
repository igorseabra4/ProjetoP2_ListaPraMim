package sistema.compras;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sistema.Tupla;
import sistema.comparadores.OrdemAlfabeticaCompra;
import sistema.comparadores.OrdemCompra;
import sistema.produtos.*;

/**
 * Lista de compras criada pelo usuario para agrupar produtos que ele deseja
 * adquirir, ela armazena os produtos conhecidos pelo sistema juntamente a uma
 * determinada quantia.
 * 
 * @author Henry Filho
 */
public class ListaDeCompras implements Serializable {

	private static final long serialVersionUID = -5012379888319238485L;
	private String descritor;
	private List<Compra> compras;
	private String data;
	private int id;

	private String localDaCompra = ""; // Atributo solicitado pela especificacao do projeto
	private double valorFinalDaCompra = 0.0;
	private boolean fechada = false;

	/**Constroi a lista de compras com base em um descritor, data e identificador dados pelo sistema.
	 * 
	 * @param descritor Descritor textual da lista.
	 * @param data Data na qual a lista eh criada.
	 * @param id Identificador numerico da lista.
	 */
	public ListaDeCompras(String descritor, String data, int id) {
		this.descritor = descritor;
		compras = new ArrayList<>();
		this.data = data;
		this.id = id;
	}

	/**Construtor que instancia uma lista de compra com os mesmos produtos de outra lista.
	 * 
	 * @param lista Lista da qual os produtos serao copiados.
	 * @param descritor Descritor da nova lista.
	 * @param data Data da nova lista.
	 * @param id Identificador numerico da nova lista.
	 */
	public ListaDeCompras(ListaDeCompras lista, String descritor, String data, int id) {
		this.descritor = descritor;
		this.data = data;
		this.id = id;

		compras = new ArrayList<>();
		for (Compra compra : lista.compras)
			compras.add(new Compra(compra));
	}

	
	/**Adiciona uma compra a lista.
	 * 
	 * @param qtd Quantia do determinado item.
	 * @param produto Produto que sera adicionado.
	 */
	public void adicionaCompra(int qtd, Produto produto) {
		if(fechada)
			throw new IllegalArgumentException("Lista de compras fechada");
		adicionaCompra(new Compra(qtd, produto));
	}

	/**Adiciona uma compra a lista.
	 * 
	 * @param compra A compra a ser adicionada.
	 */
	private void adicionaCompra(Compra compra) {
		compras.add(compra);
	}

	/**Retorna o descritor textual da lista de compra.
	 * 
	 * @return descritor.
	 */
	public String getDescritor() {
		return descritor;
	}

	/**Retorna a data da criacao da lista de compra.
	 * 
	 * @return A data da lista.
	 */
	public String getData() {
		return data;
	}

	/**Pesquisa um item na lista com base em sua id.
	 * 
	 * @param id Identificador numerico do produto.
	 * @return representacao textual do produto pesquisado.
	 */
	public String pesquisaCompraEmLista(int id) {
		if (!contemProduto(id))
			throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");

		for (Compra compra : compras) {
			if (compra.getId() == id)
				return compra.toString();
		}
		return null;
	}

	/**Deleta um item presente na lista com base em sua id.
	 * 
	 * @param id Identificador numerico do produto.
	 */
	public void deletaCompra(int id) {
		if(fechada)
			throw new IllegalArgumentException("Lista de compras fechada");
		
		for (Compra compra : compras) {
			if (compra.getId() == id) {
				compras.remove(compra);
				return;
			}
		}
		
		throw new IllegalArgumentException("Erro na exclusao de compra: compra nao encontrada na lista.");
	}

	/**Representacao textual da lista, exibindo os produtos presentes dentro dela.
	 */
	@Override
	public String toString() {
		Collections.sort(compras, new OrdemCompra());
		String temp = "";
		for (Compra compra : compras) {
			temp += compra.toString() + System.lineSeparator();
		}
		temp.trim();

		return temp;
	}

	/**Finaliza a lista de compra.
	 * 
	 * @param localDaCompra Local no qual as compras foram feitas.
	 * @param valorFinalDaCompra Valor total gasto nas compras.
	 */
	public void finalizarListaDeCompras(String localDaCompra, double valorFinalDaCompra) {
		if(fechada)
			throw new IllegalArgumentException("Lista de compras fechada");
		this.localDaCompra = localDaCompra;
		this.valorFinalDaCompra = valorFinalDaCompra;
		this.fechada = true;
	}

	/**Retorna a representacao textual de um item da lista em uma determinada
	 * posicao na lista.
	 * 
	 * @param posicaoItem Posicao do item desejado.
	 * @return representacao textual do item.
	 */
	public String getItemLista(int posicaoItem) {
		Collections.sort(compras, new OrdemCompra());

		if (posicaoItem >= compras.size())
			return "";
		return compras.get(posicaoItem).toString();
	}

	/**Atualiza uma compra da lista, incrementando ou decrementando a sua quantia.
	 * 
	 * @param itemId Identificador numerico do item.
	 * @param operacao Operacao desejada, seja ela "diminui" ou "adiciona".
	 * @param quantidade A quantidade que deve ser adicionada ou diminuida.
	 */
	public void atualizaCompraDeLista(int itemId, String operacao, int quantidade) {
		if(fechada)
			throw new IllegalArgumentException("Lista de compras fechada");
		if (operacao.equals("diminui"))
			quantidade *= -1;
		else if (!operacao.equals("adiciona"))
			throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");

		if (!contemProduto(itemId))
			throw new IllegalArgumentException("Erro na atualizacao de compra: compra nao encontrada na lista.");

		Compra c = new Compra(0, null);
		for (Compra compra : compras) {
			if (compra.getId() == itemId) {
				compra.addQuantia(quantidade);
				c = compra;
			}
		}

		if (c.getQuantia() <= 0)
			compras.remove(c);
	}

	/**Retorna um valor booleano correspondente a se a lista possuim um determinado
	 * produto ou nao.
	 * 
	 * @param id Identificador numerico do produto.
	 * @return True caso contenha, false caso contrario.
	 */
	public boolean contemProduto(int id) {
		for (Compra compra : compras) {
			if (compra.getId() == id)
				return true;
		}
		return false;
	}
	
	/**Retorna um valor booleano correspondente a se a lista possuim um determinado
	 * produto ou nao.
	 * 
	 * @param nome Nome do produto desejado.
	 * @return True caso contenha, false caso contrario.
	 */
	public boolean contemProduto(String nome) {
		for (Compra compra : compras) {
			if (compra.getNome().equals(nome))
				return true;
		}
		return false;
	}

	/**Retorna o numero de identificacao da lista.
	 * @return O numero de identificacao da lista.
	 */
	public int getID() {
		return id;
	}

	/**Retorna o valor final da compra, definido no fechamento.
	 * @return O valor final da compra.
	 */
	public double getValorTotal() {
		return valorFinalDaCompra;
	}

	/**Retorna uma lista de Tuplas, cujo primeiro elemento eh o id de cada compra e o segundo eh a sua quantidade.
	 * @return A lista especificada.
	 */
	public List<Tupla> getTuplas() {
		
		List<Tupla> temp = new ArrayList<>();
		
		for(Compra compra : compras) {
			temp.add(new Tupla(compra.getId(), compra.getQuantia()));
		}
		
		return temp;
	}

	/**Essa funcao cria varias listas de compras temporarias, cada uma correspondente a um local de compra. As compras de cada sublista
	 * sao as compras da lista mestre que estiverem disponiveis em cada um dos locais disponiveis nos produtos.
	 * @return Uma lista com as listas temporarias.
	 */
	public List<ListaDeCompras> subListasComLocal() {
		// Primeiro, vamos pegar todos os locais de compra disponiveis
		List<String> locais = new ArrayList<String>();
		for (Compra c : compras)
			for (String s : c.getLocais())
				if (!locais.contains(s))
					locais.add(s);

		// Agora vamos criar uma nova lista de compras temporaria para cada local de compra
		List<ListaDeCompras> listas = new ArrayList<ListaDeCompras>();
		
		// Agora, para cada lista, vamos tentar adicionar todas as compras disponiveis e o valor delas no respectivo local a lista.
		// Obviamente nao ira encontrar todas as compras em todos os locais; nesse caso ele captura a excecao e pula para a proxima.
		for(int i = 0; i < locais.size(); i++) {
			ListaDeCompras temp = new ListaDeCompras(locais.get(i), null, -1);
			double valueToAdd = 0;
			for(Compra c : compras) {
				try {
					valueToAdd += c.getPreco(locais.get(i)) * c.getQuantia();
				}catch(IllegalArgumentException e) {
					continue;
				}
				temp.adicionaCompra(c);
			}
			temp.sortComprasTipoENome();
			temp.finalizarListaDeCompras(locais.get(i), valueToAdd);
			listas.add(temp);
		}
		
		return listas;
	}

	/**Ordena as compras da lista por categoria, e dentro de cada categoria por ordem alfabetica.
	 */
	private void sortComprasTipoENome() {
		compras.sort(new OrdemAlfabeticaCompra());
		compras.sort(new OrdemCompra());
	}
}
