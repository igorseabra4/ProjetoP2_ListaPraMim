/**
 * 
 */
package sistema.compras;

import static org.junit.Assert.*;

import org.junit.Test;

import sistema.produtos.*;

/**
 * @author wesley
 *
 */
public class CompraTest {

	/**
	 * Test method for {@link sistema.compras.Compra#Compra(sistema.compras.Compra)}.
	 */
	@Test
	public void testCompraCompra() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0);
		Compra c1 = new Compra(5, p1);
		Compra c2 = new Compra(c1);
			
		assertEquals("5 uva, alimento industrializado, 500 g", c2.toString());
	}

	/**
	 * Test method for {@link sistema.compras.Compra#Compra(int, sistema.produtos.Produto)}.
	 */
	@Test
	public void testCompraIntProduto() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0);
		Compra c1 = new Compra(5, p1);
			
		assertEquals("5 uva, alimento industrializado, 500 g", c1.toString());
	}

	/**
	 * Test method for {@link sistema.compras.Compra#getCategoria()}.
	 */
	@Test
	public void testGetCategoria() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0);
		Compra c1 = new Compra(5, p1);
			
		assertEquals("alimento industrializado", c1.getCategoria());
	}

	/**
	 * Test method for {@link sistema.compras.Compra#getId()}.
	 */
	@Test
	public void testGetId() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0);
		Compra c1 = new Compra(5, p1);
			
		assertEquals(1, c1.getId());
	}

	/**
	 * Test method for {@link sistema.compras.Compra#getNome()}.
	 */
	@Test
	public void testGetNome() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0);
		Compra c1 = new Compra(5, p1);
			
		assertEquals("uva", c1.getNome());
	}
	
	/**
	 * Test method for {@link sistema.compras.Compra#getQuantia()}.
	 */
	@Test
	public void testGetQuantia() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0);
		Compra c1 = new Compra(5, p1);
			
		assertEquals(5, c1.getQuantia());
	}

	/**
	 * Test method for {@link sistema.compras.Compra#addQuantia(int)}.
	 */
	@Test
	public void testAddQuantia() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0);
		Compra c1 = new Compra(5, p1);
		c1.addQuantia(2);
			
		assertEquals(7, c1.getQuantia());
	}


	/**
	 * Test method for {@link sistema.compras.Compra#toString()}.
	 */
	@Test
	public void testToString() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0);
		Compra c1 = new Compra(5, p1);
			
		assertEquals("5 uva, alimento industrializado, 500 g", c1.toString());
	}

}
