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
	private List<Produto> produtos;
	private String data;

	/**
	 * Constrói a lista de compras com base em um descritor dado pelo sistema, e
	 * gerando uma data automaticamente que será adicionada a lista.
	 * 
	 * @param descritor
	 *            Descritor textual da lista.
	 */
	public ListaDeCompras(String descritor) {
		this.descritor = descritor;
		produtos = new ArrayList<>();
		this.data = "10/07/2018";
	}

	/**
	 * Adiciona uma compra a lista, recebendo do sistema o produto e a quantia de
	 * tal que será adicionada ao sistema.
	 * 
	 * @param qtd
	 *            Quantia do produto em questão. (Integer)
	 * @param produto
	 *            Produto que será adicionado.
	 */
	public void adicionaCompra(int qtd, Produto produto) {
		String valor = String.valueOf(qtd);
		if (produto instanceof ProdutoQuantidade) {
			Produto novoProduto = new ProdutoQuantidade((ProdutoQuantidade) produto);
			novoProduto.atualizaItem("unidade", valor);
			produtos.add(novoProduto);
			
		} else if (produto instanceof ProdutoQuilo) {
			adicionaCompra((double) qtd, produto);

		} else if (produto instanceof ProdutoUnidade) {
			Produto novoProduto = new ProdutoUnidade((ProdutoUnidade) produto);
			novoProduto.atualizaItem("unidade", valor);
			produtos.add(novoProduto);
		}
	}

	/**
	 * Adiciona uma compra a lista, recebendo do sistema o produto e a quantia de
	 * tal que será adicionada ao sistema.
	 * 
	 * @param qtd
	 *            Quantia do produto em questão. (Double)
	 * @param produto
	 *            Produto que será adicionado.
	 */
	public void adicionaCompra(double qtd, Produto produto) {
		String valor = String.valueOf(qtd);
		Produto novoProduto = null;
		if (produto instanceof ProdutoQuilo) {
			novoProduto = new ProdutoQuilo((ProdutoQuilo) produto);
			novoProduto.atualizaItem("kg", valor);
		}
		produtos.add(novoProduto);
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
		for (Produto produto : produtos) {
			if (produto.getId() == id)
				return produto.toString();
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
		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				produtos.remove(produto);
				return;
			}
		}
	}

	/**
	 * Representação textual da lista, exibindo os produtos presentes dentro dela.
	 */
	@Override
	public String toString() {
		Collections.sort(produtos, new OrdemAlfabetica());
		Collections.sort(produtos, new OrdemCategoria());
		String temp = "";
		for (Produto produto : produtos) {
			temp += produto.toString(0) + System.lineSeparator();
		}
		temp.trim();

		return temp;
	}

}
