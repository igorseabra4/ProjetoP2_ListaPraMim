/**
 * 
 */
package sistema.produtos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author wesley
 *
 */
public class ProdutoConstruidoTest {
	ProdutoConstruido p1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		p1 = new ProdutoConstruido(1, "uva", "alimento industrializado", "bem legal", 10.0);
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoConstruido#ProdutoCronstruido(int, java.lang.String, java.lang.String, java.lang.String, double)}.
	 */
	@Test
	public void testProdutoCronstruido() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#Produto(int, java.lang.String, java.lang.String, java.lang.String, double)}.
	 */
	@Test
	public void testProduto() {
		ProdutoConstruido p2 = new ProdutoConstruido(1, "uva", "alimento nao industrializado", "bem legal", 10.0);
		
		assertEquals("1. uva, alimento nao industrializado, Preco: <bem legal, R$ 10,00;>", p2.toString());
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#atualizaItem(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAtualizaItem() {
		p1.atualizaItem("nome", "feijao");
		assertEquals("feijao, alimento industrializado", p1.toString(0));
		
		p1.atualizaItem("categoria", "alimento nao industrializado");
		assertEquals("feijao, alimento nao industrializado", p1.toString(0));
		
		p1.atualizaItem("categoria", "limpeza");
		assertEquals("feijao, limpeza", p1.toString(0));
		
		p1.atualizaItem("categoria", "higiene pessoal");
		assertEquals("feijao, higiene pessoal", p1.toString(0));
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#adicionaPrecoItem(java.lang.String, double)}.
	 */
	@Test
	public void testAdicionaPrecoItem() {
		p1.adicionaPrecoItem("pouco legal", 8.99);
		
		assertEquals("1. uva, alimento industrializado, Preco: <pouco legal, R$ 8,99;bem legal, R$ 10,00;>", p1.toString());		
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#getId()}.
	 */
	@Test
	public void testGetId() {
		assertEquals(1, p1.getId());
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#getNome()}.
	 */
	@Test
	public void testGetNome() {
		assertEquals("uva", p1.getNome());
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#getCategoria()}.
	 */
	@Test
	public void testGetCategoria() {
		assertEquals("alimento industrializado", p1.getCategoria());
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#getMenorPreco()}.
	 */
	@Test
	public void testGetMenorPreco() {
		p1.adicionaPrecoItem("pouco legal", 8.99);

		
		assertEquals(8.99, p1.getMenorPreco(), 0.005);
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#getPreco(java.lang.String)}.
	 */
	@Test
	public void testGetPreco() {
		assertEquals(10.0, p1.getMenorPreco(), 0.005);
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#getLocais()}.
	 */
	@Test
	public void testGetLocais() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#contemStringPesquisada(java.lang.String)}.
	 */
	@Test
	public void testContemStringPesquisada() {
		assertTrue(p1.contemStringPesquisada("uva"));
		assertFalse(p1.contemStringPesquisada("banana"));
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#toString(int)}.
	 */
	@Test
	public void testToStringInt() {
		assertEquals("uva, alimento industrializado", p1.toString(0));
	}
	
	/**
	 * Test method for {@link sistema.produtos.Produto#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals("1. uva, alimento industrializado, Preco: <bem legal, R$ 10,00;>", p1.toString());
	}

}
