package sistema.compras;

/**
 * @author wesley
 *
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sistema.Tupla;
import sistema.produtos.ProdutoQuantidade;

public class ListaDeComprasTest {
	
	ListaDeCompras lista;
	

	@Before
	public void setUp() throws Exception {
		lista = new ListaDeCompras("feira", "01/01/2000", 1);
		lista.adicionaCompra(1, new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0));
	}
	
	@Test
	public void testListaDeComprasListaDeComprasStringStringInt() {
		ListaDeCompras lista2 = new ListaDeCompras("feira", "01/01/2000", 1);
		lista2.adicionaCompra(1, new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0));
		
		assertEquals(lista2.toString(), lista.toString());
	}

	@Test
	public void testAdicionaCompra() {
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
		assertEquals(lista.pesquisaCompraEmLista(1),"1 uva, alimento industrializado, 500 g");
			
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDeletaCompra() {
		assertEquals(lista.pesquisaCompraEmLista(1),"1 uva, alimento industrializado, 500 g");

		lista.deletaCompra(1);
		
		assertEquals(lista.pesquisaCompraEmLista(1),"1 uva, alimento industrializado, 500 g");		
	}

	@Test
	public void testToString() {
		assertEquals(lista.toString(),"1 uva, alimento industrializado, 500 g" + System.lineSeparator());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testFinalizarListaDeCompras() {
		assertEquals(lista.pesquisaCompraEmLista(1),"1 uva, alimento industrializado, 500 g");		
		lista.finalizarListaDeCompras("bem legal", 10);
		
		lista.finalizarListaDeCompras("bem legal", 10);
	}

	@Test
	public void testGetItemLista() {
		assertEquals(lista.getItemLista(0),"1 uva, alimento industrializado, 500 g");
	}

	@Test
	public void testAtualizaCompraDeLista() {
		assertEquals(lista.getItemLista(0),"1 uva, alimento industrializado, 500 g");
		
		lista.atualizaCompraDeLista(1, "adiciona", 1);		
		assertEquals(lista.getItemLista(0),"2 uva, alimento industrializado, 500 g");
		
		lista.atualizaCompraDeLista(1, "diminui", 1);		
		assertEquals(lista.getItemLista(0),"1 uva, alimento industrializado, 500 g");
	}

	@Test
	public void testContemProdutoInt() {
		assertTrue(lista.contemProduto(1));
	}

	@Test
	public void testContemProdutoString() {
		assertTrue(lista.contemProduto("uva"));
	}

	@Test
	public void testGetID() {
		assertEquals(lista.getID(),1);
	}

	@Test
	public void testGetValorTotal() {
		assertEquals(lista.pesquisaCompraEmLista(1),"1 uva, alimento industrializado, 500 g");		
		lista.finalizarListaDeCompras("bem legal", 10);
		
		assertEquals(lista.getValorTotal(), 10.0, 0.005);
	}

}
