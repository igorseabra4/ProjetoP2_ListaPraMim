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
		assertEquals("uva, alimento industrializado", p1.toString(0));
		
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
	 * Test method for {@link sistema.produtos.ProdutoUnidade#toStringValues()}.
	 */
	@Test
	public void testToStringValues() {
		ProdutoUnidade p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		
		assertEquals("Preco", p1.toStringValues());
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoUnidade#ProdutoUnidade(int, java.lang.String, java.lang.String, int, java.lang.String, double)}.
	 */
	@Test
	public void testProdutoUnidade() {
		ProdutoUnidade p2 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		
		assertEquals("1. uva, alimento industrializado, Preco: <bem legal, R$ 10,00;>", p2.toString());
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#adicionaPrecoItem(java.lang.String, double)}.
	 */
	@Test
	public void testAdicionaPrecoItem() {
		ProdutoUnidade p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		p1.adicionaPrecoItem("pouco legal", 8.99);
		
		assertEquals("1. uva, alimento industrializado, Preco: <pouco legal, R$ 8,99;bem legal, R$ 10,00;>", p1.toString());
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#getId()}.
	 */
	@Test
	public void testGetId() {
		ProdutoUnidade p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		
		assertEquals(1, p1.getId());
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#getNome()}.
	 */
	@Test
	public void testGetNome() {
		ProdutoUnidade p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		
		assertEquals("uva", p1.getNome());
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#getCategoria()}.
	 */
	@Test
	public void testGetCategoria() {
		ProdutoUnidade p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		
		assertEquals("alimento industrializado", p1.getCategoria());
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#getMenorPreco()}.
	 */
	@Test
	public void testGetMenorPreco() {
		ProdutoUnidade p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);		
		p1.adicionaPrecoItem("pouco legal", 8.99);

		
		assertEquals(8.99, p1.getMenorPreco(), 0.005);
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#contemStringPesquisada(java.lang.String)}.
	 */
	@Test
	public void testContemStringPesquisada() {
		ProdutoUnidade p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		
		assertTrue(p1.contemStringPesquisada("uva"));
		assertFalse(p1.contemStringPesquisada("banana"));
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#toString()}.
	 */
	@Test
	public void testToString() {
		ProdutoUnidade p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		
		assertEquals("1. uva, alimento industrializado, Preco: <bem legal, R$ 10,00;>", p1.toString());
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#toString(int)}.
	 */
	@Test
	public void testToStringInt() {
		ProdutoUnidade p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		
		assertEquals("uva, alimento industrializado", p1.toString(0));
	}
	
	@Test
	public void testEquals() {
		ProdutoUnidade p1 = new ProdutoUnidade(1, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		ProdutoUnidade p2 = new ProdutoUnidade(2, "uva", "alimento industrializado", 500, "bem legal", 10.0);
		
		assertEquals(p1, p2);
	}

}
