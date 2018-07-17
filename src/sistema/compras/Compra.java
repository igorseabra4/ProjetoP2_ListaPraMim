package sistema.compras;

import sistema.produtos.*;

public class Compra {
	
	private int quantia;
	private Produto produto;
	
	public Compra(int quantia, Produto produto) {
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
	
	public int getQuantia() {
		return quantia;
	}
	
	public void addQuantia(int quantia) {
		this.quantia += quantia;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s", quantia, produto.toString(0));
	}
	
}
