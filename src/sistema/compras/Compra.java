package sistema.compras;

import sistema.produtos.Produto;

public class Compra implements Produtos {
	
	private double quantia;
	private Produto produto;
	
	public Compra(double quantia, Produto produto) {
		this.quantia = quantia;
		this.produto = produto;
	}

	public String getCategoria() {
		return produto.getCategoria();
	}

	public int getId() {
		return produto.getId();
	}

	@Override
	public String getNome() {
		return produto.getNome();
	}

	@Override
	public double getMenorPreco() {
		return produto.getMenorPreco();
	}
	
	@Override
	public String toString() {
		return produto.toString();
	}
	
	public String toString(int i) {
		return produto.toString(0);
	}
	
}
