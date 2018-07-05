import easyaccept.EasyAccept;

public class Facade {
	public static void main(String[] args) {
		args = new String[] {"Facade",
				"acception_tests/use_case1.txt"};
		
		EasyAccept.main(args);
	}
	
	private Sistema sistema = new Sistema();
	
	public int adicionaItemPorQtd (String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra, double preco) {
		return sistema.adicionaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
	}
	
	public int adicionaItemPorQuilo (String nome, String categoria, double kg, String localDeCompra, double preco) {
		return sistema.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}
	
	public int adicionaItemPorUnidade (String nome, String categoria, int unidade, String localDeCompra, double preco) {
		return sistema.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}
	
	public String exibeItem (int id) {
		return sistema.exibeItem(id);
	}
	
	public void atualizaItem (int id, String atributo, String novoValor) {
		sistema.atualizaItem(id, atributo, novoValor);
	}
	
	public void adicionaPrecoItem (int id, String localDeCompra, double preco) {
		sistema.adicionaPrecoItem(id, localDeCompra, preco);
	}
	
	public void deletaItem (int id) {
		sistema.deletaItem(id);
	}
}