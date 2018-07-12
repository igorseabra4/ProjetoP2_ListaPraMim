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
public class ProdutoQuantidadeTest {

	/**
	 * Test method for {@link sistema.produtos.ProdutoQuantidade#atualizaItem(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAtualizaItem() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0);
		
		p1.atualizaItem("unidade", "5");		
		assertEquals("5 uva, alimento industrializado, 500 g", p1.toString(0));
		
		p1.atualizaItem("quantidade", "250");		
		assertEquals("5 uva, alimento industrializado, 250 g", p1.toString(0));
	
		p1.atualizaItem("unidade de medida", "kg");
		assertEquals("5 uva, alimento industrializado, 250 kg", p1.toString(0));
		
		p1.atualizaItem("nome", "feijao");
		assertEquals("5 feijao, alimento industrializado, 250 kg", p1.toString(0));
		
		p1.atualizaItem("categoria", "alimento nao industrializado");
		assertEquals("5 feijao, alimento nao industrializado, 250 kg", p1.toString(0));
		
		p1.atualizaItem("categoria", "limpeza");
		assertEquals("5 feijao, limpeza, 250 kg", p1.toString(0));
		
		p1.atualizaItem("categoria", "higiene pessoal");
		assertEquals("5 feijao, higiene pessoal, 250 kg", p1.toString(0));
	}

	/**
	 * Test method for {@link sistema.produtos.ProdutoQuantidade#toString(int)}.
	 */
	@Test
	public void testToStringInt() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento nao industrializado", 500, "g", "bem legal", 10.0);		
		assertEquals("1 uva, alimento nao industrializado, 500 g", p1.toString(0));
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
		assertEquals("1 uva, alimento nao industrializado, 500 g", p1.toString(0));
	}


	/**
	 * Test method for {@link sistema.produtos.ProdutoQuantidade#ProdutoQuantidade(int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, double)}.
	 */
	@Test
	public void testProdutoQuantidadeIntStringStringIntStringStringDouble() {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento nao industrializado", 500, "g", "bem legal", 10.0);
		
		assertEquals("1. uva, alimento nao industrializado, 500 g, Preco: <bem legal, R$ 10,00;>", p1.toString());		
		assertEquals("1 uva, alimento nao industrializado, 500 g", p1.toString(0));
	}

}
