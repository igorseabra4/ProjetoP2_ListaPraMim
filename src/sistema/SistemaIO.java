package sistema;
import java.io.*;
import java.util.ArrayList;
import sistema.produtos.*;

public class SistemaIO {
    public static void WriteProdutos(ArrayList<Produto> produtos) {
        String fileName = "produtos.txt";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            
            for (Produto p : produtos) {
            	bufferedWriter.write("produto " + p.getId() + "," + p.getNome() + ","
            + p.getCategoria().toString());
            	// TODO
            	
            	if (p instanceof ProdutoQuantidade) {
                	// TODO            		
            	}
            	// TODO
            }
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.err.println("Erro ao escrever produtos.txt");
        }
    }
}


