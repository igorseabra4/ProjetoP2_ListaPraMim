package sistema.compras;

import java.io.Serializable;
import java.util.HashSet;

import sistema.produtos.*;

/** Compras que sao armazenadas em listas de compras. As compras armazenam
 * produtos e suas determinadas quantidades.
 * 
 * @author Henry Filho
 *
 */
public class Compra implements Serializable {

	private static final long serialVersionUID = -7573139187233147231L;
	private int quantia;
	private Produto produto;

	/**Construtor que copia uma compra existente.
	 * 
	 * @param compra Compra que sera copiada.
	 */
	public Compra(Compra compra) {
		this.quantia = compra.quantia;
		this.produto = compra.produto;
	}

	/**Construtor padrao da compra.
	 * 
	 * @param quantia Quantidade de itens a serem comprados.
	 * @param produto Produto determinado da compra.
	 */
	public Compra(int quantia, Produto produto) {
		this.quantia = quantia;
		this.produto = produto;
	}

	/**Retorna a categoria do produto da compra.
	 * 
	 * @return A categoria do produto.
	 */
	public String getCategoria() {
		return produto.getCategoria();
	}

	/**Retorna a representacao numerica do produto da compra.
	 * 
	 * @return representacao numerica do produto.
	 */
	public int getId() {
		return produto.getId();
	}

	/**Retorna o nome do produto da compra.
	 * 
	 * @return nome do produto.
	 */
	public String getNome() {
		return produto.getNome();
	}

	/**Retorna a quantia de produtos comprados.
	 * 
	 * @return quantia.
	 */
	public int getQuantia() {
		return quantia;
	}

	/**Incrementa uma quantia a compra.
	 * 
	 * @param quantia Valor a ser incrementado.
	 */
	public void addQuantia(int quantia) {
		this.quantia += quantia;
	}

	/**Retorna o preco do produto no local de compra especificado.
	 * 
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

	/**Representacao textual da compra, que corresponde a quantia seguido da representacao textual alternativa do produto.
	 */
	@Override
	public String toString() {
		return String.format("%d %s", quantia, produto.toStringSemPrecos());
	}

}
