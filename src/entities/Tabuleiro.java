package entities;

public class Tabuleiro {
	
	private String[][] tabuleiro = new String[3][3];
	private String dificuldade;
		
	public void addPeca(String posicao, Player player) {
		String[] vect = posicao.split(",");
		int linha = Integer.parseInt(vect[0]);
		int coluna = Integer.parseInt(vect[1]);		
		tabuleiro[linha][coluna] = player.getPeca();	
	}

	public String[][] getTabuleiro() {
		return tabuleiro;
	}

	public String getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}
	
	
}
