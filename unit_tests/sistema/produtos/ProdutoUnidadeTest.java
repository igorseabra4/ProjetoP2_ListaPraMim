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
public class ProdutoUnidadeTest {

	/**
	 * Test method for {@link sistema.produtos.ProdutoUnidade#atualizaItem(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAtualizaItem() {
		ProdutoUnidade p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		
		p1.atualizaItem("unidade", "5");		
		assertEquals("5 uva, alimento industrializado", p1.toString(0));
		
		p1.atualizaItem("nome", "feijao");
		assertEquals("5 feijao, alimento industrializado", p1.toString(0));
		
		p1.atualizaItem("categoria", "alimento nao industrializado");
		assertEquals("5 feijao, alimento nao industrializado", p1.toString(0));
		
		p1.atualizaItem("categoria", "limpeza");
		assertEquals("5 feijao, limpeza", p1.toString(0));
		
		p1.atualizaItem("categoria", "higiene pessoal");
		assertEquals("5 feijao, higiene pessoal", p1.toString(0));
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoUnidade#toString(int)}.
	 */
	@Test
	public void testToStringInt() {
		ProdutoUnidade p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		
		assertEquals("500 uva, alimento industrializado", p1.toString(0));
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoUnidade#toStringValues()}.
	 */
	@Test
	public void testToStringValues() {
		ProdutoUnidade p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		
		assertEquals("Preco", p1.toStringValues());
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoUnidade#ProdutoUnidade(sistema.produtos.ProdutoUnidade)}.
	 */
	@Test
	public void testProdutoUnidadeProdutoUnidade() {
		ProdutoUnidade p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		ProdutoUnidade p2 = new ProdutoUnidade(p1);
		
		assertEquals("1. uva, alimento industrializado, Preco: <bem legal, R$ 10,00;>", p2.toString());		
		assertEquals("500 uva, alimento industrializado", p2.toString(0));
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoUnidade#ProdutoUnidade(int, java.lang.String, java.lang.String, int, java.lang.String, double)}.
	 */
	@Test
	public void testProdutoUnidadeIntStringStringIntStringDouble() {
		ProdutoUnidade p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		
		assertEquals("1. uva, alimento industrializado, Preco: <bem legal, R$ 10,00;>", p1.toString());		
		assertEquals("500 uva, alimento industrializado", p1.toString(0));
	}

}
