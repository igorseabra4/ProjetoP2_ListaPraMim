/**
 * 
 */
package sistema.produtos;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author wesleyrs
 *
 */
public class ProdutoQuantidadeTest {

	/**
	 * Test method for {@link sistema.produtos.ProdutoQuantidade#atualizaItem(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAtualizaItem() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0);
		
		p1.atualizaItem("quantidade", "250");		
		assertEquals("uva, alimento industrializado, 250 g", p1.toString(0));
	
		p1.atualizaItem("unidade de medida", "kg");
		assertEquals("uva, alimento industrializado, 250 kg", p1.toString(0));
		
		p1.atualizaItem("nome", "feijao");
		assertEquals("feijao, alimento industrializado, 250 kg", p1.toString(0));
		
		p1.atualizaItem("categoria", "alimento nao industrializado");
		assertEquals("feijao, alimento nao industrializado, 250 kg", p1.toString(0));
		
		p1.atualizaItem("categoria", "limpeza");
		assertEquals("feijao, limpeza, 250 kg", p1.toString(0));
		
		p1.atualizaItem("categoria", "higiene pessoal");
		assertEquals("feijao, higiene pessoal, 250 kg", p1.toString(0));
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoQuantidade#toString(int)}.
	 */
	@Test
	public void testToStringInt() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento nao industrializado", 500, "g", "bem legal", 10.0);		
		assertEquals("uva, alimento nao industrializado, 500 g", p1.toString(0));
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoQuantidade#toStringValues()}.
	 */
	@Test
	public void testToStringValues() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento nao industrializado", 500, "g", "bem legal", 10.0);		
		assertEquals("500 g, Preco", p1.toStringValues());
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoQuantidade#ProdutoQuantidade(sistema.produtos.ProdutoQuantidade)}.
	 */
	@Test
	public void testProdutoQuantidadeProdutoQuantidade() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento nao industrializado", 500, "g", "bem legal", 10.0);		
		ProdutoQuantidade p2 = new ProdutoQuantidade(p1);
		
		assertEquals("1. uva, alimento nao industrializado, 500 g, Preco: <bem legal, R$ 10,00;>", p2.toString());		
		assertEquals("uva, alimento nao industrializado, 500 g", p1.toString(0));
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoQuantidade#ProdutoQuantidade(int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, double)}.
	 */
	@Test
	public void testProdutoQuantidadeIntStringStringIntStringStringDouble() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento nao industrializado", 500, "g", "bem legal", 10.0);
		
		assertEquals("1. uva, alimento nao industrializado, 500 g, Preco: <bem legal, R$ 10,00;>", p1.toString());		
		assertEquals("uva, alimento nao industrializado, 500 g", p1.toString(0));
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#Produto(sistema.produtos.Produto)}.
	 */
	@Test
	public void testProdutoProduto() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#Produto(int, java.lang.String, java.lang.String, java.lang.String, double)}.
	 */
	@Test
	public void testProdutoIntStringStringStringDouble() {
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
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento nao industrializado", 500, "g", "bem legal", 10.0);
		
		assertEquals(1, p1.getId());
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#getNome()}.
	 */
	@Test
	public void testGetNome() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento nao industrializado", 500, "g", "bem legal", 10.0);
		
		assertEquals("uva", p1.getNome());
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#getCategoria()}.
	 */
	@Test
	public void testGetCategoria() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento nao industrializado", 500, "g", "bem legal", 10.0);
		
		assertEquals("alimento nao industrializado", p1.getCategoria());
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#getMenorPreco()}.
	 */
	@Test
	public void testGetMenorPreco() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#contemStringPesquisada(java.lang.String)}.
	 */
	@Test
	public void testContemStringPesquisada() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link sistema.produtos.Produto#toString()}.
	 */
	@Test
	public void testToString() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento nao industrializado", 500, "g", "bem legal", 10.0);
		
		assertEquals("1. uva, alimento nao industrializado, 500 g, Preco: <bem legal, R$ 10,00;>", p1.toString());
	}

}
