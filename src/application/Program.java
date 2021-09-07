package application;

import java.util.Scanner;

import entities.Juiz;
import entities.Maquina;
import entities.Player;
import entities.Regras;
import entities.Tabuleiro;
import entities.Voce;

public class Program {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Player voce;
		Player maquina;
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.setDificuldade("Facil");

		
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
				Juiz.tabuleiroAtual(tabuleiro);
				
				System.out.println();
				System.out.print("Qual linha/coluna quer jogar? ");
				String pos = scan.next();
				char linha = pos.charAt(0);
				int coluna = Character.getNumericValue(pos.charAt(1));
				
				String[] vect = Voce.position(linha, coluna).split(",");
				int x = Integer.parseInt(vect[0]);
				int y = Integer.parseInt(vect[1]);		
				
				while(tabuleiro.getTabuleiro()[x][y] != null) {
						System.out.println("Este espaco ja enta utilizado, escolha um vazio!");
						System.out.println();
						System.out.print("Qual linha/coluna quer jogar? ");
						pos = scan.next();
						linha = pos.charAt(0);
						coluna = Character.getNumericValue(pos.charAt(1));
						
						vect = Voce.position(linha, coluna).split(",");
						x = Integer.parseInt(vect[0]);
						y = Integer.parseInt(vect[1]);
				}
				Juiz.jogada(tabuleiro, voce, Voce.position(linha, coluna));
				
				if (Regras.finalizar(tabuleiro)) {

					Juiz.tabuleiroAtual(tabuleiro);
					
					System.out.println();
					vect = Maquina.posiotion(tabuleiro, voce).split(",");
					x = Integer.parseInt(vect[0]);
					y = Integer.parseInt(vect[1]);
					String position = x + "," + y;
					
					while(tabuleiro.getTabuleiro()[x][y] != null) {

						vect = Maquina.posiotion(tabuleiro, voce).split(",");
						x = Integer.parseInt(vect[0]);
						y = Integer.parseInt(vect[1]);
						position = x + "," + y;
					}
					Juiz.jogada(tabuleiro, maquina, position);
				}
			
			}while(Regras.finalizar(tabuleiro));

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
				Juiz.tabuleiroAtual(tabuleiro);
				
				System.out.println();
				String[] vect = Maquina.posiotion(tabuleiro, voce).split(",");
				int x = Integer.parseInt(vect[0]);
				int y = Integer.parseInt(vect[1]);
				String position = x + "," + y;
				
				while(tabuleiro.getTabuleiro()[x][y] != null) {

					vect = Maquina.posiotion(tabuleiro, voce).split(",");
					x = Integer.parseInt(vect[0]);
					y = Integer.parseInt(vect[1]);
					position = x + "," + y;
				}
				Juiz.jogada(tabuleiro, maquina, position);
				
				if (Regras.finalizar(tabuleiro)) {
					
					Juiz.tabuleiroAtual(tabuleiro);
					
					System.out.println();
					System.out.print("Qual linha/coluna quer jogar? ");
					String pos = scan.next();
					char linha = pos.charAt(0);
					int coluna = Character.getNumericValue(pos.charAt(1));
					
					vect = Voce.position(linha, coluna).split(",");
					x = Integer.parseInt(vect[0]);
					y = Integer.parseInt(vect[1]);		
					
					while(tabuleiro.getTabuleiro()[x][y] != null) {
							System.out.println("Este espaco ja enta utilizado, escolha um vazio!");
							System.out.println();
							System.out.print("Qual linha/coluna quer jogar? ");
							pos = scan.next();
							linha = pos.charAt(0);
							coluna = Character.getNumericValue(pos.charAt(1));
							vect = Voce.position(linha, coluna).split(",");
							x = Integer.parseInt(vect[0]);
							y = Integer.parseInt(vect[1]);
					}
					Juiz.jogada(tabuleiro, voce, Voce.position(linha, coluna));
				}
				
			}while(Regras.finalizar(tabuleiro));
		}

		Juiz.tabuleiroAtual(tabuleiro);
		System.out.println();
		System.out.println(Regras.quemGanhou(tabuleiro, voce, maquina));
		
		scan.close();	
	}

	public static boolean falseOuTrue() {
		if(Math.round(Math.random() * (100 - 0) + 0) >= 50) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
	
}
