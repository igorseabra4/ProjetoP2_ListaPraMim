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
 * Classe responsavel pela criacao e leitura de arquivos, possibilitando que o
 * sistema seja continuado mesmo apos reiniciado.
 * 
 * @author Henry Filho
 * @author Igor Seabra
 */
public class SistemaIO {
	private static final String FILE_NAME = "./data/system.bin";
	
	/**
	 * Metodo responsavel pela leitura do arquivo que armazena o sistema.
	 * 
	 * @return O sistema lido.
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public static Sistema readSistema() throws FileNotFoundException {
		Sistema sistema = null;
		
		try {
			FileInputStream fileReader = new FileInputStream(new File(FILE_NAME));
			ObjectInputStream objectReader = new ObjectInputStream(fileReader);
			
			try {
				Map<Integer, Produto> produtos = (Map<Integer, Produto>) objectReader.readObject();
				Map<String, ListaDeCompras> listasDeCompras = (Map<String, ListaDeCompras>) objectReader.readObject();
				int currentID = (int) objectReader.readObject();
				int currentIDlista = (int) objectReader.readObject();
				
				sistema = new Sistema(produtos, listasDeCompras, currentID, currentIDlista);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			objectReader.close();
			fileReader.close();
			
			return sistema;
			
		} catch (IOException e) {
			e.printStackTrace();
			return new Sistema();
		}
	}
	
	/**Metodo responsavel por escrever e salvar o arquivo que contem os dados do sistema.
	 * @param produtos O mapa de produtos do sistema a ser salvo.
	 * @param listasDeCompras O mapa de listas de compras do sistema a ser salvo.
	 * @param currentId O valor usado para controle de identificadores de produtos.
	 * @param currentIdLista O valor usado para controle de identificadores de listas de compras.
	 */
	public static void writeSistema(Map<Integer, Produto> produtos, Map<String, ListaDeCompras> listasDeCompras, int currentId, int currentIdLista) {
		try {
			FileOutputStream fileWriter = new FileOutputStream(new File(FILE_NAME));
			ObjectOutputStream objectWriter = new ObjectOutputStream(fileWriter);

			objectWriter.writeObject(produtos);
			objectWriter.writeObject(listasDeCompras);
			objectWriter.writeObject(currentId);
			objectWriter.writeObject(currentIdLista);

			objectWriter.close();			
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}