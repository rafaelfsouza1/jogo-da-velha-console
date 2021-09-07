package entities;

public class Voce extends Player{

	public Voce(String peca) {
		super(peca);
	}
	
	public static String position(char linha, int coluna) {
		if (linha == 'A' || linha == 'a') {
			return 0 + "," + (coluna - 1);
		}
		else if (linha == 'B' || linha == 'b') {
			return 1 + "," + (coluna - 1);
		}
		else if (linha == 'C' || linha == 'c') {
			return 2 + "," + (coluna - 1);
		}
		else {
			return null;
		}
	}
}
