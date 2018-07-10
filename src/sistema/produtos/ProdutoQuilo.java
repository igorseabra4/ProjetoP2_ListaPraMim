package sistema.produtos;

public class ProdutoQuilo extends Produto {

	private double kg;
	
	public ProdutoQuilo(int id, String nome, String categoria, double kg, String localDeCompra, double preco) {
		super(id,nome,categoria,localDeCompra,preco);
		if(kg < 0)
			throw new IllegalArgumentException("Erro no cadastro de item: valor de quilos nao pode ser menor que zero.");
		
		this.kg = kg;
	}

	@Override
	public void atualizaItem(String atributo, String novoValor) {
		if(atributo.equals("kg")) {
			if(Double.parseDouble(novoValor) < 0)
				throw new IllegalArgumentException("Erro na atualizacao de item: valor de quilos nao pode ser menor que zero.");
			
			kg = Double.parseDouble(novoValor);
		}
		else super.atualizaItem(atributo, novoValor);
	}
	
	@Override
	protected String toStringValues() {
		return "Preco por quilo";
	}
}
