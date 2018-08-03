package sistema.produtos;

/**
 * @author wesley
 *
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProdutoQuantidadeTest {
	ProdutoQuantidade p1;

	@Before
	public void setUp() throws Exception {
		p1 = new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0);
	}

	@Test
	public void testHashCode() {
		ProdutoQuantidade p2 = new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0);
		
		assertEquals(p2.hashCode(), p1.hashCode());
	}

	@Test
	public void testAtualizaItem() {
		p1.atualizaItem("quantidade", "250");		
		assertEquals("uva, alimento industrializado, 250 g", p1.toStringSemPrecos());
	
		p1.atualizaItem("unidade de medida", "kg");
		assertEquals("uva, alimento industrializado, 250 kg", p1.toStringSemPrecos());
	}

	@Test
	public void testToStringInt() {
		assertEquals("uva, alimento industrializado, 500 g", p1.toStringSemPrecos());
	}

	@Test
	public void testToStringValues() {
		assertEquals("500 g, Preco", p1.toStringValues());
	}

	@Test
	public void testProdutoQuantidade() {
		ProdutoQuantidade p2 = new ProdutoQuantidade(1, "uva", "alimento nao industrializado", 500, "g", "bem legal", 10.0);
		assertEquals("1. uva, alimento nao industrializado, 500 g, Preco: <bem legal, R$ 10,00;>", p2.toString());
	}

	@Test
	public void testEqualsObject() {
		ProdutoQuantidade p2 = new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0);
		assertTrue(p1.equals(p2));
	}

}
