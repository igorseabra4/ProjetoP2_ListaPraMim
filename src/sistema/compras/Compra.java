package sistema.compras;

import sistema.produtos.*;

public class Compra {
	
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

	public String getNome() {
		return produto.getNome();
	}

	public double getMenorPreco() {
		return produto.getMenorPreco();
	}
	
	public void setQuantia(double quantia) {
		this.quantia = quantia;
	}
	
	@Override
	public String toString() {
		if(produto instanceof ProdutoQuilo)
			return String.format("%.1f kg %s", quantia, produto.toString(0));
		return String.format("%.0f %s", quantia, produto.toString(0));
	}
	
}
