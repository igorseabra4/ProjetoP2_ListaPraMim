package sistema;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SistemaTest {

	Sistema sistema;
	
	@Before
	public void setUp() throws Exception {
		sistema = new Sistema();
	}

	@Test
	public void testAdicionaItemPorQtd() {
		int i = sistema.adicionaItemPorQtd("Exemplo Produto", "higiene pessoal", 5, "g", "Mercado Exemplo", 500);
		assertEquals(i, 1);
	}

	@Test
	public void testAdicionaItemPorQuilo() {
		int i = sistema.adicionaItemPorQuilo("nome", "higiene pessoal", 10, "local", 15);
		assertEquals(i, 1);
	}

	@Test
	public void testAdicionaItemPorUnidade() {
		int i = sistema.adicionaItemPorUnidade("nome", "higiene pessoal", 15, "lugar", 15);
		assertEquals(i, 1);
	}

	@Test
	public void testExibeItem() {
		sistema.adicionaItemPorUnidade("nome", "higiene pessoal", 15, "lugar", 15);
		assertEquals(sistema.exibeItem(1), "1. nome, higiene pessoal, Preco: <lugar, R$ 15,00;>");
	}

	@Test
	public void testAtualizaItem() {
		sistema.adicionaItemPorUnidade("nome", "higiene pessoal", 15, "lugar", 15);
		sistema.atualizaItem(1, "nome", "exemplo");
		assertEquals(sistema.exibeItem(1), "1. exemplo, higiene pessoal, Preco: <lugar, R$ 15,00;>");
	}

	@Test
	public void testAdicionaPrecoItem() {
		sistema.adicionaItemPorUnidade("nome", "higiene pessoal", 15, "lugar", 15);
		sistema.adicionaPrecoItem(1, "lugar legal", 7500);
		assertEquals(sistema.exibeItem(1), "1. nome, higiene pessoal, Preco: <lugar legal, R$ 7500,00;lugar, R$ 15,00;>");
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testDeletaItem() {
		sistema.adicionaItemPorUnidade("nome", "higiene pessoal", 15, "lugar", 15);
		sistema.deletaItem(1);
		sistema.exibeItem(1);
	}

	@Test
	public void testGetItem() {
		sistema.adicionaItemPorUnidade("nome", "higiene pessoal", 15, "lugar", 15);
		assertEquals(sistema.getItem(0), "1. nome, higiene pessoal, Preco: <lugar, R$ 15,00;>");
	}

	@Test
	public void testGetItemPorCategoria() {
		sistema.adicionaItemPorUnidade("nome", "higiene pessoal", 15, "lugar", 15);
		assertEquals(sistema.getItemPorCategoria("higiene pessoal", 0), "1. nome, higiene pessoal, Preco: <lugar, R$ 15,00;>");
	}

	@Test
	public void testGetItemPorMenorPreco() {
		sistema.adicionaItemPorUnidade("nome", "higiene pessoal", 15, "lugar", 15);
		assertEquals(sistema.getItemPorMenorPreco(0), "1. nome, higiene pessoal, Preco: <lugar, R$ 15,00;>");
	}

	@Test
	public void testGetItemPorPesquisa() {
		sistema.adicionaItemPorUnidade("nome", "higiene pessoal", 15, "lugar", 15);
		assertEquals(sistema.getItemPorPesquisa("no", 0), "1. nome, higiene pessoal, Preco: <lugar, R$ 15,00;>");
	}

	@Test
	public void testAdicionaListaDeCompras() {
		sistema.adicionaListaDeCompras("feira bacana");
		assertEquals(sistema.pesquisaListaDeCompras("feira bacana"), "feira bacana");
	}

	@Test
	public void testPesquisaListaDeCompras() {
		sistema.adicionaListaDeCompras("feira bacana");
		assertEquals(sistema.pesquisaListaDeCompras("feira bacana"), "feira bacana");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testFinalizarListaDeCompras() {
		sistema.adicionaItemPorUnidade("nome", "higiene pessoal", 15, "lugar", 15);
		sistema.adicionaListaDeCompras("feira bacana");
		sistema.finalizarListaDeCompras("feira bacana", "local bacana", 15000);
		sistema.adicionaCompraALista("feira bacana", 15, 1);
	}

	@Test
	public void testPesquisaCompraEmLista() {
		sistema.adicionaItemPorUnidade("nome", "higiene pessoal", 15, "lugar", 15);
		sistema.adicionaListaDeCompras("feira bacana");
		sistema.adicionaCompraALista("feira bacana", 15, 1);
		assertEquals(sistema.pesquisaCompraEmLista("feira bacana", 1), "15 nome, higiene pessoal");
	}

	@Test
	public void testGetItemLista() {
		sistema.adicionaItemPorUnidade("nome", "higiene pessoal", 15, "lugar", 15);
		sistema.adicionaListaDeCompras("feira bacana");
		sistema.adicionaCompraALista("feira bacana", 15, 1);
		assertEquals(sistema.getItemLista("feira bacana", 0), "15 nome, higiene pessoal");
	}

}
