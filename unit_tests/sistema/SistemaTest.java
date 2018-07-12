package sistema;

import static org.junit.Assert.*;
import org.junit.Test;
import sistema.Sistema;
import sistema.produtos.*;

public class SistemaTest {
	@Test
	public void testSistema() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdicionaItemPorQtd() {
		Sistema s = new Sistema();

		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento nao industrializado", 500, "g", "bem legal", 10);
		ProdutoQuantidade p2 = new ProdutoQuantidade(2, "banana", "alimento nao industrializado", 500, "g", "bem legal", 5);
		ProdutoQuantidade p3 = new ProdutoQuantidade(3, "ovo", "alimento industrializado", 100, "g", "bem legal", 5);
		
		int u1 = s.adicionaItemPorQtd("uva", "alimento nao industrializado", 500, "g", "bem legal", 10);
		int u2 = s.adicionaItemPorQtd("banana", "alimento nao industrializado", 500, "g", "bem legal", 5);
		int u3 = s.adicionaItemPorQtd("ovo", "alimento industrializado", 100, "g", "bem legal", 5);

		assertEquals(s.exibeItem(u1), p1.toString());
		assertEquals(s.exibeItem(u2), p2.toString()); 
		assertEquals(s.exibeItem(u3), p3.toString()); 
	}

	@Test
	public void testAdicionaItemPorQuilo() {
		Sistema s = new Sistema();

		ProdutoQuilo p1 = new ProdutoQuilo(1, "carne", "alimento nao industrializado", 1, "bem legal", 25);
		ProdutoQuilo p2 = new ProdutoQuilo(2, "queijo", "alimento industrializado", 1, "bem legal", 50);
		
		int u1 = s.adicionaItemPorQuilo("carne", "alimento nao industrializado", 1, "bem legal", 25);
		int u2 = s.adicionaItemPorQuilo("queijo", "alimento industrializado", 1, "bem legal", 50);

		assertEquals(s.exibeItem(u1), p1.toString());
		assertEquals(s.exibeItem(u2), p2.toString()); 
	}

	@Test
	public void testAdicionaItemPorUnidade() {
		Sistema s = new Sistema();

		ProdutoUnidade p1 = new ProdutoUnidade(1, "escova de dente", "higiene pessoal", 1, "bem legal", 5);
		ProdutoUnidade p2 = new ProdutoUnidade(2, "escova melhor", "higiene pessoal", 2, "bem legal", 15);
		int u1 = s.adicionaItemPorUnidade("escova de dente", "higiene pessoal", 1, "bem legal", 5);
		int u2 = s.adicionaItemPorUnidade("escova melhor", "higiene pessoal", 2, "bem legal", 15);

		assertEquals(s.exibeItem(u1), p1.toString());
		assertEquals(s.exibeItem(u2), p2.toString()); 
	}

	@Test
	public void testAtualizaItem() {
		Sistema s = new Sistema();

		ProdutoUnidade p1 = new ProdutoUnidade(1, "escova de dente", "higiene pessoal", 1, "bem legal", 5);
		ProdutoUnidade p2 = new ProdutoUnidade(2, "escova melhor", "higiene pessoal", 2, "bem legal", 15);
		int u1 = s.adicionaItemPorUnidade("escova de dente", "higiene pessoal", 1, "bem legal", 5);
		int u2 = s.adicionaItemPorUnidade("escova melhor", "higiene pessoal", 2, "bem legal", 15);

		assertEquals(s.exibeItem(u1), p1.toString());
		assertEquals(s.exibeItem(u2), p2.toString());

		p1.atualizaItem("nome", "pasta de dente");
		s.atualizaItem(u1, "nome", "pasta de dente");

		assertEquals(s.exibeItem(u1), p1.toString());
		assertEquals(s.exibeItem(u2), p2.toString());
		
		p2.atualizaItem("categoria", "limpeza");
		s.atualizaItem(u2, "categoria", "limpeza");

		assertEquals(s.exibeItem(u1), p1.toString());
		assertEquals(s.exibeItem(u2), p2.toString());
	}

	@Test
	public void testAdicionaPrecoItem() {
		fail("Not yet implemented");
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testDeletaItem() {
		Sistema s = new Sistema();
		
		ProdutoQuilo p1 = new ProdutoQuilo(1, "carne", "alimento nao industrializado", 1, "bem legal", 25);
		ProdutoQuilo p2 = new ProdutoQuilo(2, "queijo", "alimento industrializado", 1, "bem legal", 50);
		
		int u1 = s.adicionaItemPorQuilo("carne", "alimento nao industrializado", 1, "bem legal", 25);
		int u2 = s.adicionaItemPorQuilo("queijo", "alimento industrializado", 1, "bem legal", 50);
		
		s.deletaItem(u1);
		
		assertEquals(s.exibeItem(u2), p2.toString());
		
		s.exibeItem(u1);
	}

}
