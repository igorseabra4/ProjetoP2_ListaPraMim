package sistema.produtos;

/**
 * @author wesley
 *
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProdutoUnidadeTest {
	ProdutoUnidade p1;

	@Before
	public void setUp() throws Exception {
		p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
	}

	@Test
	public void testHashCode() {
		ProdutoUnidade p2 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		
		assertEquals(p2.hashCode(), p1.hashCode());
	}

	@Test
	public void testAtualizaItem() {
		ProdutoUnidade p2 = new ProdutoUnidade(1, "uva", "alimento industrializado", 5, "bem legal", 10.0);
		
		p1.atualizaItem("unidade", "5");		
		assertEquals(p2.hashCode(), p1.hashCode());
	}

	@Test
	public void testToStringValues() {
		assertEquals("Preco", p1.toStringValues());
	}

	@Test
	public void testProdutoUnidade() {
		ProdutoUnidade p2 = new ProdutoUnidade(1, "uva", "alimento industrializado", 5, "bem legal", 10.0);
		
		assertEquals("1. uva, alimento industrializado, Preco: <bem legal, R$ 10,00;>", p2.toString());
	}

	@Test
	public void testEqualsObject() {
		ProdutoUnidade p2 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		
		assertTrue(p1.equals(p2));
	}

}
