package sistema.produtos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProdutoQuiloTest {
	ProdutoQuilo p1;

	@Before
	public void setUp() throws Exception {
		p1 = new ProdutoQuilo(1, "uva", "alimento industrializado", 500.0, "bem legal", 10.0);
	}

	@Test
	public void testHashCode() {
		ProdutoQuilo p2 = new ProdutoQuilo(1, "uva", "alimento industrializado", 500.0, "bem legal", 10.0);
		
		assertEquals(p2.hashCode(), p1.hashCode());
	}

	@Test
	public void testAtualizaItem() {
		ProdutoQuilo p2 = new ProdutoQuilo(1, "uva", "alimento industrializado", 5.0, "bem legal", 10.0);
		p1.atualizaItem("kg", "5");
		
		assertEquals(p2.hashCode(), p1.hashCode());
		
	}

	@Test
	public void testToStringValues() {
		assertEquals("Preco por quilo", p1.toStringValues());
	}

	@Test
	public void testProdutoQuilo() {
		ProdutoQuilo p2 = new ProdutoQuilo(1, "uva", "alimento industrializado", 500.0, "bem legal", 10.0);
		
		assertEquals(p2.hashCode(), p1.hashCode());
	}

	@Test
	public void testEqualsObject() {
		ProdutoQuilo p2 = new ProdutoQuilo(1, "uva", "alimento industrializado", 500.0, "bem legal", 10.0);
		
		assertTrue(p1.equals(p2));
	}

}
