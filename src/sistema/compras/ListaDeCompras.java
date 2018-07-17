package sistema.compras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sistema.comparadores.OrdemAlfabetica;
import sistema.comparadores.OrdemCategoria;
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
	
	private String localDaCompra = "";
	private double valorFinalDaCompra = 0.0;
	private boolean fechada = false;

	/**
	 * Constrói a lista de compras com base em um descritor dado pelo sistema, e
	 * gerando uma data automaticamente que será adicionada a lista.
	 * 
	 * @param descritor
	 *            Descritor textual da lista.
	 */
	public ListaDeCompras(String descritor) {
		this.descritor = descritor;
		compras = new ArrayList<>();
		this.data = "10/07/2018";
	}

	
	public void adicionaCompra(double qtd, Produto produto) {
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
	public String pesquisaCompra(int id) {
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
		Collections.sort(compras, new OrdemAlfabetica());
		Collections.sort(compras, new OrdemCategoria());
		String temp = "";
		for (Compra compra : compras) {
			temp += compra.toString() + System.lineSeparator();
		}
		temp.trim();

		return temp;
	}


	public void finalizarListaDeCompras(String localDaCompra, double valorFinalDaCompra) {
		this.localDaCompra = localDaCompra;
		this.valorFinalDaCompra = valorFinalDaCompra;
		this.fechada = true;
	}


	public String pesquisaCompraEmLista(int itemId) {
		for(Compra compra : compras) {
			if(compra.getId() == itemId)
				return compra.toString();
		}return null;
	}


	public String getItemLista(int posicaoItem) {
		return compras.get(posicaoItem).toString();
	}


	public void deletaCompraDeLista(int itemId) {
		for(Compra compra : compras) {
			if(compra.getId() == itemId)
				compras.remove(compra);
		}
	}

}
