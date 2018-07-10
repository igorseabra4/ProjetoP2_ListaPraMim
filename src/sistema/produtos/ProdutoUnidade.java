package sistema.produtos;

public class ProdutoUnidade extends Produto {

	private int unidade;
	
	public ProdutoUnidade(int id, String nome, String categoria, int unidade, String localDeCompra, double preco) {
		super(id,nome,categoria,localDeCompra,preco);
		if(unidade < 0)
			throw new IllegalArgumentException("Erro no cadastro de item: valor de unidade nao pode ser menor que zero.");
		this.unidade = unidade;
	}
	
	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if(atributo.equals("unidades")) {
			if(Integer.parseInt(novoValor) < 0)
				throw new IllegalArgumentException("Erro na atualizacao de item: valor de quantidade nao pode ser menor que zero.");
			
			unidade = Integer.parseInt(novoValor);
		}
		else super.atualizaItem(atributo, novoValor);
	}
	
	@Override
	protected String toStringValues() {
		return "Preco";
	}
}
