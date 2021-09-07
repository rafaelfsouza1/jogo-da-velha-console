package entities;

public class Maquina extends Player{
	
	public Maquina(String peca) {
		super(peca);
	}

	public static String posiotion(Tabuleiro tabuleiro, Player voce) {
		
		return Math.round(Math.random() * (2 - 0) + 0)+ "," + Math.round(Math.random() * (2 - 0) + 0);
	}
	
}