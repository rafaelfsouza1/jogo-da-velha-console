package application;

import java.util.Scanner;

import entities.Maquina;
import entities.Player;
import entities.Tabuleiro;
import entities.Voce;

public class Program {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Player voce;
		Player maquina;
		Tabuleiro tabuleiro = new Tabuleiro();

		
		if (falseOuTrue()) {
			System.out.print("X ou O? ");
			char temp = scan.next().charAt(0);
			voce = new Voce(String.valueOf(temp));
			if (temp == 'X' || temp == 'x') {
				maquina = new Maquina("O");
			}
			else {
				maquina = new Maquina("X");
			}
			
			do {
				tabuleiroAtual(tabuleiro);
				
				System.out.println();
				System.out.print("Qual linha/coluna quer jogar? ");
				String pos = scan.next();
				char linha = pos.charAt(0);
				int coluna = Character.getNumericValue(pos.charAt(1));
				
				String[] vect = position(linha, coluna).split(",");
				int x = Integer.parseInt(vect[0]);
				int y = Integer.parseInt(vect[1]);		
				
				while(tabuleiro.getTabuleiro()[x][y] != null) {
						System.out.println("Este espaco ja enta utilizado, escolha um vazio!");
						System.out.println();
						System.out.print("Qual linha/coluna quer jogar? ");
						pos = scan.next();
						linha = pos.charAt(0);
						coluna = Character.getNumericValue(pos.charAt(1));
						
						vect = position(linha, coluna).split(",");
						x = Integer.parseInt(vect[0]);
						y = Integer.parseInt(vect[1]);
				}
				jogada(tabuleiro, voce, position(linha, coluna));
				
				if (finalizar(tabuleiro)) {

					tabuleiroAtual(tabuleiro);
					
					System.out.println();
					vect = posiotionAleatoria().split(",");
					x = Integer.parseInt(vect[0]);
					y = Integer.parseInt(vect[1]);
					String position = x + "," + y;
					
					while(tabuleiro.getTabuleiro()[x][y] != null) {

						vect = posiotionAleatoria().split(",");
						x = Integer.parseInt(vect[0]);
						y = Integer.parseInt(vect[1]);
						position = x + "," + y;
					}
					jogada(tabuleiro, maquina, position);
				}
			
			}while(finalizar(tabuleiro));
			
			tabuleiroAtual(tabuleiro);
		}
		else {
			if(falseOuTrue()) {
				maquina = new Maquina("X");
				voce = new Voce("O");
			}
			else {
				maquina = new Maquina("O");
				voce = new Voce("X");
			}
			do{
				tabuleiroAtual(tabuleiro);
				
				System.out.println();
				String[] vect = posiotionAleatoria().split(",");
				int x = Integer.parseInt(vect[0]);
				int y = Integer.parseInt(vect[1]);
				String position = x + "," + y;
				
				while(tabuleiro.getTabuleiro()[x][y] != null) {

					vect = posiotionAleatoria().split(",");
					x = Integer.parseInt(vect[0]);
					y = Integer.parseInt(vect[1]);
					position = x + "," + y;
				}
				jogada(tabuleiro, maquina, position);
				
				if (finalizar(tabuleiro)) {
					
					tabuleiroAtual(tabuleiro);
					
					System.out.println();
					System.out.print("Qual linha/coluna quer jogar? ");
					String pos = scan.next();
					char linha = pos.charAt(0);
					int coluna = Character.getNumericValue(pos.charAt(1));
					
					vect = position(linha, coluna).split(",");
					x = Integer.parseInt(vect[0]);
					y = Integer.parseInt(vect[1]);		
					
					while(tabuleiro.getTabuleiro()[x][y] != null) {
							System.out.println("Este espaco ja enta utilizado, escolha um vazio!");
							System.out.println();
							System.out.print("Qual linha/coluna quer jogar? ");
							pos = scan.next();
							linha = pos.charAt(0);
							coluna = Character.getNumericValue(pos.charAt(1));
							vect = position(linha, coluna).split(",");
							x = Integer.parseInt(vect[0]);
							y = Integer.parseInt(vect[1]);
					}
					jogada(tabuleiro, voce, position(linha, coluna));
				}
				
			}while(finalizar(tabuleiro));
			
			tabuleiroAtual(tabuleiro);
			System.out.println();
			System.out.println(quemGanhou(tabuleiro, voce, maquina));
			
		scan.close();
			
		}
	}
	
	public static String posiotionAleatoria() {
		return Math.round(Math.random() * (2 - 0) + 0)+ "," + Math.round(Math.random() * (2 - 0) + 0);
		
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
	public static boolean falseOuTrue() {
		if(Math.round(Math.random() * (100 - 0) + 0) >= 50) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void jogada(Tabuleiro tabuleiro, Player player, String position) {
		tabuleiro.addPeca(position, player);

	}
	
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
	
	public static void tabuleiroAtual(Tabuleiro tabuleiro) {
		System.out.println();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (tabuleiro.getTabuleiro()[i][j] == null) {
					System.out.print("! ");
				}
				else {
					System.out.print(tabuleiro.getTabuleiro()[i][j] + " ");
				}
			}
			System.out.println();
		}
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
	}}
