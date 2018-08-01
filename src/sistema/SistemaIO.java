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
	
	/**Metodo responsavel pela leitura do arquivo que armazena o sistema.
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
				sistema = (Sistema) objectReader.readObject();
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
	 * @param sistema O sistema que sera salvo.
	 */
	public static void writeSistema(Sistema sistema) {
		try {
			FileOutputStream fileWriter = new FileOutputStream(new File(FILE_NAME));
			ObjectOutputStream objectWriter = new ObjectOutputStream(fileWriter);

			objectWriter.writeObject(sistema);

			objectWriter.close();			
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}