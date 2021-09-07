package entities;

public class Juiz {
	
	public static void jogada(Tabuleiro tabuleiro, Player player, String position) {
		tabuleiro.addPeca(position, player);

	}
	
	public static void tabuleiroAtual(Tabuleiro tabuleiro) {
		System.out.println();
		
		
		System.out.println("-  1 2 3");
		System.out.println();
		for(int i = 0; i < 3; i++) {
			
			if (i == 0) {
				System.out.print("A  ");
			}
			if (i == 1) {
				System.out.print("B  ");
			}
			if (i == 2) {
				System.out.print("C  ");
			}
			
			
			for(int j = 0; j < 3; j++) {
				if (tabuleiro.getTabuleiro()[i][j] == null) {
					System.out.print("▢ ");
				}
				else {
					System.out.print(tabuleiro.getTabuleiro()[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
	
}
