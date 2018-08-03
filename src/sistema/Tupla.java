package sistema;

/**Uma tupla que contem dois inteiros. Usada em alguns pontos do programa para simplificacao de metodos.
 * 
 * @author Igor Seabra
 */
public class Tupla {
	private int x;
	private int y;
	
	public Tupla(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void addX(int x) {
		this.x += x;
	}
	
	public void addY(int y) {
		this.y += y;
	}

}
