package sistema.compras;

import java.util.HashSet;

import sistema.produtos.*;

/**
 * Compras que são armazenadas em listas de compras. As compras armazenam
 * produtos e suas determinadas quantidades.
 * 
 * @author Henry Filho
 *
 */
public class Compra {

	private int quantia;
	private Produto produto;

	/**
	 * Construtor que copia uma determinada compra.
	 * 
	 * @param c
	 *            Compra que será copiada.
	 */
	public Compra(Compra c) {
		this.quantia = c.quantia;
		this.produto = c.produto;
	}

	/**
	 * Construtor padrão da compra.
	 * 
	 * @param quantia
	 *            Quantidade de itens a serem comprados.
	 * @param produto
	 *            Produto determinado da compra.
	 */
	public Compra(int quantia, Produto produto) {
		this.quantia = quantia;
		this.produto = produto;
	}

	/**
	 * Retorna a categoria do produto da compra.
	 * 
	 * @return categoria do produto.
	 */
	public String getCategoria() {
		return produto.getCategoria();
	}

	/**
	 * Retorna a representação numérica do produto da compra.
	 * 
	 * @return representação numérica do produto.
	 */
	public int getId() {
		return produto.getId();
	}

	/**
	 * Retorna o nome do produto da compra.
	 * 
	 * @return nome do produto.
	 */
	public String getNome() {
		return produto.getNome();
	}

	/**
	 * Retorna a quantia de produtos comprados.
	 * 
	 * @return quantia.
	 */
	public int getQuantia() {
		return quantia;
	}

	/**
	 * Incrementa uma quantia a compra.
	 * 
	 * @param quantia
	 *            Valor a ser incrementado.
	 */
	public void addQuantia(int quantia) {
		this.quantia += quantia;
	}

	/**Retorna o preco do produto no local de compra especificado.
	 * @param local O local de compra.
	 * @return O preco do produto no local.
	 */
	public double getPreco(String local) {
		return produto.getPreco(local);
	}
	
	/**Retorna um array de strings com os locais de compra.
	 * 
	 * @return Um array de strings com os locais de compra.
	 */
	public HashSet<String> getLocais() {
		return produto.getLocais();
	}

	/**
	 * Representação textual da compra, que corresponde a quantia seguido da
	 * representação textual alternativa do produto.
	 */
	@Override
	public String toString() {
		return String.format("%d %s", quantia, produto.toString(0));
	}

}
