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

public class SistemaIO {

	public static void write(Map<Integer, Produto> produtos, Map<String, ListaDeCompras> listasDeCompras,
			int currentId, int currentIdLista, String descritorUltimaLista) {
		try {
			FileOutputStream inputProdutos = new FileOutputStream(new File("data/produtos.txt"));
			FileOutputStream inputListas = new FileOutputStream(new File("data/listasDeCompras.txt"));
			FileOutputStream inputId = new FileOutputStream(new File("data/currentID.txt"));
			FileOutputStream inputIdLista = new FileOutputStream(new File("data/currentIdLista.txt"));
			FileOutputStream inputUltima = new FileOutputStream(new File("data/descritorUltimaLista.txt"));

			ObjectOutputStream objectProdutos = new ObjectOutputStream(inputProdutos);
			ObjectOutputStream objectListas = new ObjectOutputStream(inputListas);
			ObjectOutputStream objectId = new ObjectOutputStream(inputId);
			ObjectOutputStream objectIdLista = new ObjectOutputStream(inputIdLista);
			ObjectOutputStream objectUltima = new ObjectOutputStream(inputUltima);

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
