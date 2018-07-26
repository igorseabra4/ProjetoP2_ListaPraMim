package sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import sistema.compras.ListaDeCompras;
import sistema.produtos.Produto;

/**
 * Classe responsável pela criação e leitura de arquivos, possibilitando que o
 * sistema seja continuado mesmo após reiniciado.
 * 
 * @author Henry Filho
 *
 */
public class SistemaIO {

	/**
	 * Método responsável por escrever e salvar os arquivos de dados do sistema.
	 * 
	 * @param produtos
	 *            Coleção de produtos do sistema.
	 * @param listasDeCompras
	 *            Coleção de listas de compra do sistema.
	 * @param currentId
	 *            Id do próximo produto a ser criado.
	 * @param currentIdLista
	 *            Id da próxima lista a ser criada.
	 * @param descritorUltimaLista
	 *            Descritor da ultima lista criada.
	 */
	public static void write(Map<Integer, Produto> produtos, Map<String, ListaDeCompras> listasDeCompras, int currentId,
			int currentIdLista, String descritorUltimaLista) {
		try {
			FileOutputStream outputProdutos = new FileOutputStream(new File("data/produtos.txt"));
			FileOutputStream outputListas = new FileOutputStream(new File("data/listasDeCompras.txt"));
			FileOutputStream outputId = new FileOutputStream(new File("data/currentID.txt"));
			FileOutputStream outputIdLista = new FileOutputStream(new File("data/currentIdLista.txt"));
			FileOutputStream outputUltima = new FileOutputStream(new File("data/descritorUltimaLista.txt"));

			ObjectOutputStream objectProdutos = new ObjectOutputStream(outputProdutos);
			ObjectOutputStream objectListas = new ObjectOutputStream(outputListas);
			ObjectOutputStream objectId = new ObjectOutputStream(outputId);
			ObjectOutputStream objectIdLista = new ObjectOutputStream(outputIdLista);
			ObjectOutputStream objectUltima = new ObjectOutputStream(outputUltima);

			objectProdutos.writeObject(produtos);
			objectListas.writeObject(listasDeCompras);
			objectId.writeInt(currentId);
			objectIdLista.writeInt(currentIdLista);
			objectUltima.writeUTF(descritorUltimaLista);

			objectProdutos.close();
			objectListas.close();
			objectId.close();
			objectIdLista.close();
			objectUltima.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método responsável pela leitura do arquivo que armazena os produtos
	 * cadastrados no sistema.
	 * 
	 * @return Coleção de produtos do sistema.
	 */
	@SuppressWarnings("unchecked")
	public static Map<Integer, Produto> readProdutos() {
		Map<Integer, Produto> map = null;
		try {
			FileInputStream input = new FileInputStream(new File("data/produtos.txt"));
			ObjectInputStream obj = new ObjectInputStream(input);
			try {
				map = (Map<Integer, Produto>) obj.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			obj.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * Método responsável pela leitura do arquivo que armazena as listas de compra
	 * do sistema.
	 * 
	 * @return Coleção de listas de compra do sistema.
	 */
	@SuppressWarnings("unchecked")
	public static Map<Integer, ListaDeCompras> readListasDeCompras() {
		Map<Integer, ListaDeCompras> map = null;
		try {
			FileInputStream input = new FileInputStream(new File("data/listasDeCompras.txt"));
			ObjectInputStream obj = new ObjectInputStream(input);
			try {
				map = (Map<Integer, ListaDeCompras>) obj.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			obj.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * Método responsável pela leitura do arquivo que armazena o identificador
	 * numérico do próximo produto a ser criado.
	 * 
	 * @return Valor inteiro do Id de produto.
	 */
	public static int readCurrentID() {
		int i = 0;
		try {
			FileInputStream input = new FileInputStream(new File("data/currentID.txt"));
			ObjectInputStream obj = new ObjectInputStream(input);
			i = obj.readInt();
			obj.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * Método responsável pela leitura do arquivo que armazena o identificador
	 * numérico da próxima lista a ser criada.
	 * 
	 * @return Valor inteiro do Id de lista.
	 */
	public static int readCurrentIdLista() {
		int i = 0;
		try {
			FileInputStream input = new FileInputStream(new File("data/currentIdLista.txt"));
			ObjectInputStream obj = new ObjectInputStream(input);
			i = obj.readInt();
			obj.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * Método responsável pela leitura do arquivo que armazena o descritor da ultima
	 * lista criada.
	 * 
	 * @return Descritor da ultima lista.
	 */
	public static String readDescritorUltimaLista() {
		String temp = null;
		try {
			FileInputStream input = new FileInputStream(new File("data/descritorUltimaLista.txt"));
			ObjectInputStream obj = new ObjectInputStream(input);
			temp = obj.readUTF();
			obj.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}
}
