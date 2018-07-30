package sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

	private static final String FILE_NAME = "./data/system.bin";
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
	 * @throws FileNotFoundException 
	 */
	public static void write(Map<Integer, Produto> produtos, Map<String, ListaDeCompras> listasDeCompras, int currentId,
			int currentIdLista) {
		try {
			FileOutputStream file = new FileOutputStream(new File(FILE_NAME));

			ObjectOutputStream object = new ObjectOutputStream(file);

			object.writeObject(produtos);
			object.writeObject(listasDeCompras);
			object.writeObject(currentId);
			object.writeObject(currentIdLista);

			object.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método responsável pela leitura do arquivo que armazena os produtos
	 * cadastrados no sistema.
	 * 
	 * @return Coleção de produtos do sistema.
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public static Map<Integer, Produto> readProdutos() throws FileNotFoundException {
		Map<Integer, Produto> map = null;
		try {
			FileInputStream input = new FileInputStream(new File(FILE_NAME));
			ObjectInputStream obj = new ObjectInputStream(input);
			try {
				map = (Map<Integer, Produto>) obj.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			obj.close();

		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Sistema iniciado pela primeira vez. Arquivo criado.");
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
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, ListaDeCompras> readListasDeCompras() throws FileNotFoundException {
		Map<String, ListaDeCompras> map = null;
		try {
			FileInputStream input = new FileInputStream(new File(FILE_NAME));
			ObjectInputStream obj = new ObjectInputStream(input);
			try {
				map = (Map<String, ListaDeCompras>) obj.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			obj.close();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Sistema iniciado pela primeira vez. Arquivo criado.");
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
	 * @throws FileNotFoundException
	 */
	public static int readCurrentID() throws FileNotFoundException {
		int i = 0;
		try {
			FileInputStream input = new FileInputStream(new File(FILE_NAME));
			ObjectInputStream obj = new ObjectInputStream(input);
			try {
				i = (int) obj.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj.close();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Sistema iniciado pela primeira vez. Arquivo criado.");
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
	 * @throws FileNotFoundException
	 *             lança exceção quando o sistema é iniciado pela primeira vez.
	 */
	public static int readCurrentIdLista() throws FileNotFoundException {
		int i = 0;
		try {
			FileInputStream input = new FileInputStream(new File(FILE_NAME));
			ObjectInputStream obj = new ObjectInputStream(input);
			try {
				i = (int) obj.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj.close();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Sistema iniciado pela primeira vez. Arquivo criado.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}

}