package sistema.compras;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistema.produtos.ProdutoQuantidade;

public class ListaDeComprasTest {
	
	ListaDeCompras lista;
	

	@Before
	public void setUp() throws Exception {
		lista = new ListaDeCompras("feira", "01/01/2000", 1);
	}
	
	@Test
	public void testListaDeComprasListaDeComprasStringStringInt() {
		ListaDeCompras lista2 = new ListaDeCompras("feira", "01/01/2000", 1);
		
		assertEquals(lista2.toString(), lista.toString());
	}

	@Test
	public void testAdicionaCompra() {
		lista.adicionaCompra(1, new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0));
		assertEquals(lista.contemProduto(1),true);
	}

	@Test
	public void testGetDescritor() {
		assertEquals("feira", lista.getDescritor());
	}

	@Test
	public void testGetData() {
		assertEquals("01/01/2000", lista.getData());
	}

	@Test
	public void testPesquisaCompraEmLista() {
		lista.adicionaCompra(1, new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0));
		assertEquals(lista.pesquisaCompraEmLista(1),"1 uva, alimento industrializado, 500 g");
			
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDeletaCompra() {
		lista.adicionaCompra(1, new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0));
		assertEquals(lista.pesquisaCompraEmLista(1),"1 uva, alimento industrializado, 500 g");

		lista.deletaCompra(1);
		
		assertEquals(lista.pesquisaCompraEmLista(1),"1 uva, alimento industrializado, 500 g");		
	}

	@Test
	public void testToString() {
		lista.adicionaCompra(1, new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0));
		assertEquals(lista.toString(),"1 uva, alimento industrializado, 500 g" + System.lineSeparator());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testFinalizarListaDeCompras() {
		lista.adicionaCompra(1, new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0));
		assertEquals(lista.pesquisaCompraEmLista(1),"1 uva, alimento industrializado, 500 g");
		
		lista.finalizarListaDeCompras("bem legal", 10);
		
		lista.finalizarListaDeCompras("bem legal", 10);
	}

	@Test
	public void testGetItemLista() {
		lista.adicionaCompra(1, new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0));
		assertEquals(lista.getItemLista(0),"1 uva, alimento industrializado, 500 g");
	}

	@Test
	public void testDeletaCompraDeLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testAtualizaCompraDeLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testContemProdutoInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testContemProdutoString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValorTotal() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTuplas() {
		fail("Not yet implemented");
	}

	@Test
	public void testSubListasComLocal() {
		fail("Not yet implemented");
	}

}
