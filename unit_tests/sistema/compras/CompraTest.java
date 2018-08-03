/**
 * 
 */
package sistema.compras;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import sistema.produtos.ProdutoQuantidade;

/**
 * @author wesley
 *
 */
public class CompraTest {
	private ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0);
	private Compra c1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c1 = new Compra(5, p1);
	}

	/**
	 * Test method for {@link sistema.compras.Compra#Compra(sistema.compras.Compra)}.
	 */
	@Test
	public void testCompraCompra() {
		Compra c2 = new Compra(c1);
			
		assertEquals("ID diferente", c1.getId(), c2.getId());
		assertEquals("Nome diferente", c1.getNome(), c2.getNome());
		assertEquals("Categoria diferente", c1.getCategoria(), c2.getCategoria());
		assertEquals("Quantidade diferente", c1.getQuantia(), c2.getQuantia());
		assertEquals("toString diferente", c1.toString(), c2.toString());
	}

	/**
	 * Test method for {@link sistema.compras.Compra#Compra(int, sistema.produtos.Produto)}.
	 */
	@Test
	public void testCompraIntProduto() {
		assertEquals("ID diferente", 1, c1.getId());
		assertEquals("Nome diferente", "uva", c1.getNome());
		assertEquals("Categoria diferente", "alimento industrializado", c1.getCategoria());
		assertEquals("Quantidade diferente", 5, c1.getQuantia());
		assertEquals("toString diferente", "5 uva, alimento industrializado, 500 g", c1.toString());
	}

	/**
	 * Test method for {@link sistema.compras.Compra#getCategoria()}.
	 */
	@Test
	public void testGetCategoria() {
		assertEquals("alimento industrializado", c1.getCategoria());
	}

	/**
	 * Test method for {@link sistema.compras.Compra#getId()}.
	 */
	@Test
	public void testGetId() {
		assertEquals(1, c1.getId());
	}

	/**
	 * Test method for {@link sistema.compras.Compra#getNome()}.
	 */
	@Test
	public void testGetNome() {
		assertEquals("uva", c1.getNome());
	}
	
	/**
	 * Test method for {@link sistema.compras.Compra#getQuantia()}.
	 */
	@Test
	public void testGetQuantia() {
		assertEquals(5, c1.getQuantia());
	}

	/**
	 * Test method for {@link sistema.compras.Compra#addQuantia(int)}.
	 */
	@Test
	public void testAddQuantia() {
		c1.addQuantia(2);
			
		assertEquals(7, c1.getQuantia());
	}


	/**
	 * Test method for {@link sistema.compras.Compra#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals("5 uva, alimento industrializado, 500 g", c1.toString());
	}
	
	@Test
	public void testGetPreco() {
		assertEquals(10.0, c1.getPreco("bem legal"), 0.005);
	}

	@Test
	public void testGetLocais() {
		HashSet<String> local = new HashSet<String>();
		local.add("bem legal");
		assertEquals(local, p1.getLocais());
	}
}

