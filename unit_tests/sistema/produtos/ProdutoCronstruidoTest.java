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
public class ProdutoCronstruidoTest {
	ProdutoCronstruido p1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		p1 = new ProdutoCronstruido(1, "uva", "alimento industrializado", "bem legal", 10.0);
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoCronstruido#ProdutoCronstruido(int, java.lang.String, java.lang.String, java.lang.String, double)}.
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#atualizaItem(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAtualizaItem() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#adicionaPrecoItem(java.lang.String, double)}.
	 */
	@Test
	public void testAdicionaPrecoItem() {
		fail("Not yet implemented");
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
		assertEquals("alimento nao industrializado", p1.getCategoria());
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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

}
