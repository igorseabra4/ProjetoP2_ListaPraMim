package sistema.compras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sistema.Tupla;
import sistema.comparadores.OrdemCompra;
import sistema.produtos.*;

/**
 * Lista de compras criada pelo usuário para agrupar produtos que ele deseja
 * adquirir, ela armazena cópias dos produtos conhecidos pelo sistema com uma
 * determinada quantia armazenada.
 * 
 * @author Henry Filho
 *
 */
public class ListaDeCompras {

	private String descritor;
	private List<Compra> compras;
	private String data;
	private int id;

	private String localDaCompra = "";
	private double valorFinalDaCompra = 0.0;
	private boolean fechada = false;

	/**
	 * Construtor que instancia uma lista de compra com os mesmos produtos de outra
	 * lista.
	 * 
	 * @param l
	 *            Lista na qual os produtos serão copiados.
	 * @param descritor
	 *            Descritor da nova lista.
	 * @param data
	 *            Data da nova lista.
	 * @param id
	 *            Identificador numérico da nova lista.
	 */
	public ListaDeCompras(ListaDeCompras l, String descritor, String data, int id) {
		this.descritor = descritor;
		this.data = data;
		this.id = id;

		compras = new ArrayList<>();
		for (Compra compra : l.compras)
			compras.add(new Compra(compra));
	}

	/**
	 * Constrói a lista de compras com base em um descritor dado pelo sistema, e
	 * gerando uma data automaticamente que será adicionada a lista.
	 * 
	 * @param descritor
	 *            Descritor textual da lista.
	 * @param data
	 *            Data na qual a lista é criada.
	 * @param id
	 *            Identificador numérico da lista.
	 */
	public ListaDeCompras(String descritor, String data, int id) {
		this.descritor = descritor;
		compras = new ArrayList<>();
		this.data = data;
		this.id = id;
	}

	/**
	 * Adiciona uma compra a lista.
	 * 
	 * @param qtd
	 *            Quantia do determinado item.
	 * @param produto
	 *            Produto que será adicionado.
	 */
	public void adicionaCompra(int qtd, Produto produto) {
		compras.add(new Compra(qtd, produto));
	}

	/**
	 * Retorna o descritor textual da lista de compra.
	 * 
	 * @return descritor.
	 */
	public String getDescritor() {
		return descritor;
	}

	/**
	 * Retorna a data da criação da lista de compra, gerada automaticamente na
	 * construção do objeto.
	 * 
	 * @return data da lista.
	 */
	public String getData() {
		return data;
	}

	/**
	 * Pesquisa um item na lista com base em sua id.
	 * 
	 * @param id
	 *            Identificador numérico do produto.
	 * @return representação textual do produto pesquisado.
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

	/**
	 * Deleta um item presente na lista com base em sua id.
	 * 
	 * @param id
	 *            Identificador numérico do produto.
	 */
	public void deletaCompra(int id) {
		for (Compra compra : compras) {
			if (compra.getId() == id) {
				compras.remove(compra);
				return;
			}
		}
	}

	/**
	 * Representação textual da lista, exibindo os produtos presentes dentro dela.
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

	/**
	 * Finaliza a lista de compra.
	 * 
	 * @param localDaCompra
	 *            Local no qual as compras foram feitas.
	 * @param valorFinalDaCompra
	 *            valor total gasto nas compras.
	 */
	public void finalizarListaDeCompras(String localDaCompra, double valorFinalDaCompra) {
		this.localDaCompra = localDaCompra;
		this.valorFinalDaCompra = valorFinalDaCompra;
		this.fechada = true;
	}

	/**
	 * Retorna a representação textual de um item da lista em uma determinada
	 * posição na lista.
	 * 
	 * @param posicaoItem
	 *            Posição do item desejado.
	 * @return representação textual do item.
	 */
	public String getItemLista(int posicaoItem) {
		Collections.sort(compras, new OrdemCompra());

		if (posicaoItem >= compras.size())
			return "";
		return compras.get(posicaoItem).toString();
	}

	/**
	 * Deleta uma compra da lista através do identificador numérico de seu item.
	 * 
	 * @param itemId
	 *            Identificador numérico do item.
	 */
	public void deletaCompraDeLista(int itemId) {
		if (!contemProduto(itemId))
			throw new IllegalArgumentException("Erro na exclusao de compra: compra nao encontrada na lista.");

		Compra c = new Compra(0, null);
		for (Compra compra : compras) {
			if (compra.getId() == itemId)
				c = compra;
		}
		compras.remove(c);
	}

	/**
	 * Atualiza uma compra da lista, incrementando ou decrementando a sua quantia.
	 * 
	 * @param itemId
	 *            Identificador numérico do item.
	 * @param operacao
	 *            Operação desejada, seja ela "diminui" ou "adiciona".
	 * @param quantidade
	 *            A quantidade que deve ser adicionada ou diminuida.
	 */
	public void atualizaCompraDeLista(int itemId, String operacao, int quantidade) {
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

	/**
	 * Retorna um valor booleano correspondente a se a lista possuim um determinado
	 * produto ou não.
	 * 
	 * @param id
	 *            Identificador numérico do produto.
	 * @return true caso contenha, false caso contrário.
	 */
	public boolean contemProduto(int id) {
		for (Compra compra : compras) {
			if (compra.getId() == id)
				return true;
		}
		return false;
	}
	
	/**
	 * Retorna um valor booleano correspondente a se a lista possuim um determinado
	 * produto ou não.
	 * 
	 * @param nome
	 *            Nome do produto desejado.
	 * @return true caso contenha, false caso contrário.
	 */
	public boolean contemProduto(String nome) {
		for (Compra compra : compras) {
			if (compra.getNome().equals(nome))
				return true;
		}
		return false;
	}

	public int getID() {
		return id;
	}

	public List<Tupla> getTuplas() {
		
		List<Tupla> temp = new ArrayList<>();
		
		for(Compra compra : compras) {
			temp.add(new Tupla(compra.getId(), compra.getQuantia()));
		}
		
		return temp;
	}

}
