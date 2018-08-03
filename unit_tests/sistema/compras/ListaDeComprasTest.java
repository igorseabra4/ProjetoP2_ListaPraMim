package sistema.compras;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistema.produtos.ProdutoQuantidade;

public class ListaDeComprasTest {
	private ProdutoQuantidade p1;
	private Compra c1;
	ListaDeCompras l;
	

	@Before
	public void setUp() throws Exception {
		ProdutoQuantidade p1 = new ProdutoQuantidade(1, "uva", "alimento industrializado", 500, "g", "bem legal", 10.0);
		c1 = new Compra(5, p1);
		l = new ListaDeCompras("feira", "01/01/2000", 1);
	}

	@Test
	public void testListaDeComprasStringStringInt() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testListaDeComprasListaDeComprasStringStringInt() {
		ListaDeCompras l2 = new ListaDeCompras("feira", "01/01/2000", 1);
		
		assertEquals(l2.toString(), l.toString());
	}

	@Test
	public void testAdicionaCompra() {
		Compra c2 = new Compra(c1);
		
		assertEquals("ID diferente", c1.getId(), c2.getId());
		assertEquals("Nome diferente", c1.getNome(), c2.getNome());
		assertEquals("Categoria diferente", c1.getCategoria(), c2.getCategoria());
		assertEquals("Quantidade diferente", c1.getQuantia(), c2.getQuantia());
		assertEquals("toString diferente", c1.toString(), c2.toString());
	}

	@Test
	public void testGetDescritor() {
		assertEquals("feira", l.getDescritor());
	}

	@Test
	public void testGetData() {
		assertEquals("01/01/2000", l.getData());
	}

	@Test
	public void testPesquisaCompraEmLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletaCompra() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalizarListaDeCompras() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItemLista() {
		fail("Not yet implemented");
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
