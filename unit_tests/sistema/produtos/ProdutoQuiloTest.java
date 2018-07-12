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
public class ProdutoQuiloTest {

	/**
	 * Test method for {@link sistema.produtos.ProdutoQuilo#atualizaItem(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAtualizaItem() {
		ProdutoQuilo p1 = new ProdutoQuilo(1, "uva", "alimento industrializado", 500.00, "bem legal", 10.0);
		
		p1.atualizaItem("kg", "5");	
		assertEquals("5,00 kg uva, alimento industrializado", p1.toString(0));
	
		p1.atualizaItem("nome", "feijao");
		assertEquals("5,00 kg feijao, alimento industrializado", p1.toString(0));
		
		p1.atualizaItem("categoria", "alimento nao industrializado");
		assertEquals("5,00 kg feijao, alimento nao industrializado", p1.toString(0));
		
		p1.atualizaItem("categoria", "limpeza");
		assertEquals("5,00 kg feijao, limpeza", p1.toString(0));
		
		p1.atualizaItem("categoria", "higiene pessoal");
		assertEquals("5,00 kg feijao, higiene pessoal", p1.toString(0));
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoQuilo#toString(int)}.
	 */
	@Test
	public void testToStringInt() {
		ProdutoQuilo p1 = new ProdutoQuilo(1, "uva", "alimento industrializado", 500.00, "bem legal", 10.0);		
		assertEquals("500,00 kg uva, alimento industrializado", p1.toString(0));
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoQuilo#toStringValues()}.
	 */
	@Test
	public void testToStringValues() {
		ProdutoQuilo p1 = new ProdutoQuilo(1, "uva", "alimento industrializado", 500.00, "bem legal", 10.0);		
		assertEquals("Preco por quilo", p1.toStringValues());
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoQuilo#ProdutoQuilo(sistema.produtos.ProdutoQuilo)}.
	 */
	@Test
	public void testProdutoQuiloProdutoQuilo() {		
		ProdutoQuilo p1 = new ProdutoQuilo(1, "uva", "alimento industrializado", 500.00, "bem legal", 10.0);		
		ProdutoQuilo p2 = new ProdutoQuilo(p1);
		
		assertEquals("1. uva, alimento industrializado, Preco por quilo: <bem legal, R$ 10,00;>", p2.toString());		
		assertEquals("500,00 kg uva, alimento industrializado", p2.toString(0));
		
		
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoQuilo#ProdutoQuilo(int, java.lang.String, java.lang.String, double, java.lang.String, double)}.
	 */
	@Test
	public void testProdutoQuiloIntStringStringDoubleStringDouble() {
		ProdutoQuilo p1 = new ProdutoQuilo(1, "uva", "alimento industrializado", 500.00, "bem legal", 10.0);
		
		assertEquals("1. uva, alimento industrializado, Preco por quilo: <bem legal, R$ 10,00;>", p1.toString());		
		assertEquals("500,00 kg uva, alimento industrializado", p1.toString(0));
	}

}
