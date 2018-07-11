/**
 * 
 */
package sistema.produtos;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author wesley
 *
 */
public class ProdutoQuantidadeTest {

	/**
	 * Test method for {@link sistema.produtos.ProdutoQuantidade#atualizaItem(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAtualizaItem() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento nao industrializado", 500, "g", "bem legal", 10);
		
		assertEquals("uva", p1.getNome());
		
		p1.atualizaItem("nome", "pasta de dente");

		assertEquals("pasta de dente", p1.getNome());
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoQuantidade#toStringValues()}.
	 */
	@Test
	public void testToStringValues() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento nao industrializado", 500, "g", "bem legal", 10);
		
		assertEquals("500 g, Preco", p1.toStringValues());
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoQuantidade#ProdutoQuantidade(int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, double)}.
	 */
	@Test
	public void testProdutoQuantidade() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento nao industrializado", 500, "g", "bem legal", 10);
		
		assertEquals("1. uva, alimento nao industrializado, 500 g, Preco: <bem legal, R$ 10,00;>", p1.toString());
	}

}
