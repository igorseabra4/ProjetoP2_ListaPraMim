package sistema.compras;

import java.util.ArrayList;
import java.util.List;

import sistema.produtos.*;

public class ListaDeCompras {
	
	private String descritor;
	private List<Produto> produtos;
	
	public ListaDeCompras(String descritor) {
		this.descritor = descritor;
		produtos = new ArrayList<>();
	}
	
	public void adicionaCompra(int qtd, Produto produto) {
		double valor = qtd;
		adicionaCompra(valor, produto);
	}
	
	public void adicionaCompra(double qtd, Produto produto) {
		String valor = String.valueOf(qtd);
		Produto novoProduto = produto;
		if(novoProduto instanceof ProdutoQuantidade)
			novoProduto.atualizaItem("quantidade", valor);
		else if(novoProduto instanceof ProdutoQuilo)
			novoProduto.atualizaItem("kg", valor);
		else if(novoProduto instanceof ProdutoUnidade)
			novoProduto.atualizaItem("unidade", valor);
		produtos.add(novoProduto);
	}
	
	public String getDescritor() {
		return descritor;
	}

}
