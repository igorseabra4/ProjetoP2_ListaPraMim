package sistema.produtos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Classe abstrata que abrange todos os produtos possiveis que serao armazenados
 * no sistema.
 * 
 * @author Henry Filho
 *
 */
public abstract class Produto implements Serializable {

	private static final long serialVersionUID = 1015580778119012302L;
	private int id;
	private String nome;
	private Categorias categoria;
	private Map<String, Double> precos;

	/**
	 * Construtor de um produto.
	 * 
	 * @param id Identificador numerico do produto.
	 * @param nome Nome do produto.
	 * @param categoria Categoria do produto. (em texto)
	 * @param localDeCompra Um local no qual o produto pode ser comprado.
	 * @param preco O preco do produto no local determinado.
	 */
	public Produto(int id, String nome, String categoria, String localDeCompra, double preco) {
		if (nome.trim().equals(""))
			throw new NullPointerException("Erro no cadastro de item: nome nao pode ser vazio ou nulo.");
		if (categoria.trim().equals(""))
			throw new NullPointerException("Erro no cadastro de item: categoria nao pode ser vazia ou nula.");
		if (localDeCompra.trim().equals(""))
			throw new NullPointerException("Erro no cadastro de item: local de compra nao pode ser vazio ou nulo.");
		if (preco < 0)
			throw new IllegalArgumentException("Erro no cadastro de item: preco de item invalido.");

		this.id = id;
		this.nome = nome;

		try {
			atualizaCategoria(categoria);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastro de item: " + e.getMessage());
		}

		precos = new HashMap<>();
		precos.put(localDeCompra, preco);
	}

	/**Atualiza um determinado atributo do produto.
	 * 
	 * @param atributo Atributo que sera modificado.
	 * @param novoValor Valor desejado que sera atribuido ao atributo.
	 */
	public void atualizaItem(String atributo, String novoValor) {
		if (atributo.trim().equals(""))
			throw new NullPointerException("Erro na atualizacao de item: atributo nao pode ser vazio ou nulo.");
		if (novoValor.trim().equals(""))
			throw new NullPointerException("Erro na atualizacao de item: novo valor de atributo nao pode ser vazio ou nulo.");

		if (atributo.equals("nome"))
			nome = novoValor;
		else if (atributo.equals("categoria")) {
			try {
				atualizaCategoria(novoValor);
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Erro na atualizacao de item: " + e.getMessage());
			}
		} else
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao existe.");
	}

	/**Atualiza a categoria do produto para uma nova.
	 * 
	 * @param novoValor Nova categoria do produto.
	 */
	private void atualizaCategoria(String novoValor) {
		if (novoValor.equals("alimento industrializado"))
			categoria = Categorias.ALIM_INDUSTR;
		else if (novoValor.equals("alimento nao industrializado"))
			categoria = Categorias.ALIM_NAO_INDUSTR;
		else if (novoValor.equals("limpeza"))
			categoria = Categorias.LIMPEZA;
		else if (novoValor.equals("higiene pessoal"))
			categoria = Categorias.HIGIENE_PESSOAL;
		else
			throw new IllegalArgumentException("categoria nao existe.");
	}

	/**Adiciona o preco do produto em um determinado local de compra.
	 * 
	 * @param localDeCompra Local atribuido ao preco.
	 * @param preco Preco do produto neste local.
	 */
	public void adicionaPrecoItem(String localDeCompra, double preco) {
		if (localDeCompra.trim().equals(""))
			throw new NullPointerException("Erro no cadastro de preco: local de compra nao pode ser vazio ou nulo.");
		if (preco < 0)
			throw new IllegalArgumentException("Erro no cadastro de preco: preco de item invalido.");

		if (precos.containsKey(localDeCompra))
			precos.replace(localDeCompra, preco);
		else
			precos.put(localDeCompra, preco);
	}

	/**Retorna o identificador numerico no produto.
	 * 
	 * @return identificador numerico.
	 */
	public int getId() {
		return id;
	}

	/**Retorna o nome do produto.
	 * 
	 * @return O nome do produto.
	 */
	public String getNome() {
		return nome;
	}

	/**Retorna a categoria do produto em String.
	 * 
	 * @return A categoria do produto.
	 */
	public String getCategoria() {
		return categoria.getNome();
	}

	/**Retorna o menor preco definido do produto.
	 * 
	 * @return O menor preco conhecido.
	 */
	public double getMenorPreco() {
		double menor = Double.MAX_VALUE;
		for (double preco : precos.values()) {
			if (preco < menor)
				menor = preco;
		}
		return menor;
	}

	/**Retorna o preco do produto no local de compra especificado.
	 * @param local O local de compra.
	 * @return O preco do produto no local.
	 */
	public double getPreco(String local) {
		if (precos.containsKey(local))
			return precos.get(local);
		else throw new IllegalArgumentException("Preco para o local indicado nao disponivel");
	}
	
	/**Retorna um array de strings com os locais de compra.
	 * 
	 * @return Um array de strings com os locais de compra.
	 */
	public HashSet<String> getLocais() {
		HashSet<String> locais = new HashSet<String>();
		locais.addAll(precos.keySet());
		return locais;
	}

	/**Retorna um valor booleano correspondendo a existencia de uma dada String
	 * no nome do produto.
	 * 
	 * @param string String pesquisada.
	 * @return True caso possua, false caso contrario.
	 */
	public boolean contemStringPesquisada(String string) {
		return nome.toLowerCase().contains(string.toLowerCase());
	}

	/**
	 * Representacao textual do produto.
	 */
	@Override
	public String toString() {
		String resultado = String.format("%d. %s, %s, %s: <", id, nome, categoria.getNome(), toStringValues());

		for (String value : precos.keySet())
			resultado += String.format("%s, R$ %.2f;", value, precos.get(value));
		resultado += ">";

		return resultado;
	}

	/**Representacao textual simples do produto.
	 * 
	 * @return Representacao textual simples do produto.
	 */
	public String toStringSemPrecos() {
		return nome + ", " + categoria.getNome();
	}

	/**Valores utilizados na representacao textual do produto, que sao uma
	 * peculiaridade de cada tipo de produto.
	 * 
	 * @return uma String com valores especificos de cada tipo.
	 */
	protected abstract String toStringValues();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
}
