package entities;

public class Regras {


	public static boolean finalizar(Tabuleiro tabuleiro){
			
			boolean temp = true;
			
			
			for (int i = 0; i < 3; i++) {
				if (tabuleiro.getTabuleiro()[i][0] != null) {
					if (tabuleiro.getTabuleiro()[i][0] == tabuleiro.getTabuleiro()[i][1] && tabuleiro.getTabuleiro()[i][0] == tabuleiro.getTabuleiro()[i][2]) {
						temp = false;
					}			
				}
			}
			
			for (int i = 0; i < 3; i++) {
				if (tabuleiro.getTabuleiro()[0][i] != null) {
					if(tabuleiro.getTabuleiro()[0][i] == tabuleiro.getTabuleiro()[1][i] && tabuleiro.getTabuleiro()[0][i] == tabuleiro.getTabuleiro()[2][i]) {
						temp = false;
					}
				}
			}
			if (tabuleiro.getTabuleiro()[0][0] != null) {
				if(tabuleiro.getTabuleiro()[0][0] == tabuleiro.getTabuleiro()[1][1] && tabuleiro.getTabuleiro()[0][0] == tabuleiro.getTabuleiro()[2][2]) {
					temp = false;
				}
			}
			if (tabuleiro.getTabuleiro()[2][0] != null) {
				if(tabuleiro.getTabuleiro()[2][0] == tabuleiro.getTabuleiro()[1][1] && tabuleiro.getTabuleiro()[2][0] == tabuleiro.getTabuleiro()[0][2]) {
					temp = false;
				}	
			}
			int contagem = 0;
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (tabuleiro.getTabuleiro()[i][j] == null) {
						contagem++;
					}
				}
			}
			if (contagem <= 2) {
				temp = false;
			}
			
			return temp;		
		}
		
	public static String quemGanhou(Tabuleiro tabuleiro, Player voce, Player maquina) {
		String temp = "Deu velha!";
			
			
		for (int i = 0; i < 3; i++) {
				if (tabuleiro.getTabuleiro()[i][0] == tabuleiro.getTabuleiro()[i][1] && tabuleiro.getTabuleiro()[i][0] == tabuleiro.getTabuleiro()[i][2]) {
					if (tabuleiro.getTabuleiro()[i][0] == voce.getPeca()) {
						temp = "Voce ganhou!";
					}		
					else {
						temp = "A maquina ganhou!";	
					}
				}
		}
			
		for (int i = 0; i < 3; i++) {
					
			if(tabuleiro.getTabuleiro()[0][i] == tabuleiro.getTabuleiro()[1][i] && tabuleiro.getTabuleiro()[0][i] == tabuleiro.getTabuleiro()[2][i]) {
				if (tabuleiro.getTabuleiro()[0][i] == voce.getPeca()) {
					temp = "Voce ganhou!";
				}		
				else {
					temp = "A maquina ganhou!";	
				}
			}	
		}
			
				
		if(tabuleiro.getTabuleiro()[0][0] == tabuleiro.getTabuleiro()[1][1] && tabuleiro.getTabuleiro()[0][0] == tabuleiro.getTabuleiro()[2][2]) {
			if (tabuleiro.getTabuleiro()[0][0] == voce.getPeca()) {
				temp = "Voce ganhou!";	
			}
			else {
				temp = "A maquina ganhou!";	
			}
		}
		
		if(tabuleiro.getTabuleiro()[2][0] == tabuleiro.getTabuleiro()[1][1] && tabuleiro.getTabuleiro()[2][0] == tabuleiro.getTabuleiro()[0][2]) {
			if (tabuleiro.getTabuleiro()[0][0] == voce.getPeca()) {
				temp = "Voce ganhou!";
			}
			else {
				temp = "A maquina ganhou!";	
			}
		}
			
		return temp;
	}
	
}
			
			
	
	
