package com.mycompany.jogodavelha;
//
import java.util.Scanner;



public class multiPlayer {
    public static void multiPlayer(){
        int pontPlayer1 = 0;
        int pontPlayer2 = 0;
        Campo[][] velha=new Campo[3][3];
        char simboloAtual='X';
        boolean andamento = true;
        boolean vitoria;
        Scanner scanner = new Scanner(System.in);
        String player1;
        String player2;
        char continuar;
         
         System.out.println("Digite o nome do Player1: ");
         player1 = scanner.next();
         System.out.println("Digite o nome do Player2: ");
         player2 = scanner.next();
         
         iniciarJogo(velha);
         
         while(andamento==true){
            
            mostrarTabuleiro(velha);
            vitoria = verificaVitoria(velha, player1, player2, pontPlayer1, pontPlayer2);
            if(vitoria == true){
                System.out.println("Parabens por ganhar. Se quiser continuar jogando digite 'S' se não, aperte qualquer tecla.");
                continuar = scanner.next().charAt(0);
                if(continuar == 'S' || continuar == 's'){
                    simboloAtual='X';
                    iniciarJogo(velha);
                }else{
                    System.out.printf("Obrigado por jogar.");
                    break;
                }
            }else if (verificaEmpate(velha)) {
                System.out.println("Placar: (X)"+pontPlayer1+" (O)"+pontPlayer2);
                System.out.println("Empate! Se quiser continuar jogando digite 'S'.");
                continuar = scanner.next().charAt(0);
                if(continuar == 'S' || continuar == 's'){
                    simboloAtual='X';
                    iniciarJogo(velha);
                }else{
                    System.out.printf("Obrigado por jogar.");
                    break;
                }
            }
            
            
            try{
                if(verificarJogada(velha,jogar(velha,scanner,simboloAtual,player1,player2),simboloAtual)){
                    if(simboloAtual == 'X'){
                        simboloAtual = 'O';
                    }else{
                        simboloAtual = 'X';
                }
            }
                
            }catch(Exception e){
                System.out.println("Erro");
            }

         }
         System.out.println("Fim de jogo.");
 
    }
            public static void mostrarTabuleiro(Campo[][] velha){
                     
            System.out.println("    0   1   2");
            System.out.printf("0   %c | %c | %c %n", velha[0][0].getSimbolo(),velha[0][1].getSimbolo(),velha[0][2].getSimbolo());
            System.out.println("  --------------");
            System.out.printf("1   %c | %c | %c %n", velha[1][0].getSimbolo(),velha[1][1].getSimbolo(),velha[1][2].getSimbolo());
            System.out.println("  --------------");
            System.out.printf("2   %c | %c | %c %n", velha[2][0].getSimbolo(),velha[2][1].getSimbolo(),velha[2][2].getSimbolo());
        }    
            
            
            
            
            public static int[] jogar(Campo[][] velha,Scanner scanner, char simboloAtual, String player1, String player2) {
            int[] p = new int[2];
                if(simboloAtual == 'X'){
                    System.out.printf("%s %s(%c)\n", "Quem joga: ",player1,simboloAtual);
                }else{
                    System.out.printf("%s %s(%c)\n", "Quem joga: ",player2,simboloAtual);
                }
    
                System.out.print("Informe a linha: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Entrada inválida. Por favor, insira um número para a linha.");
                        scanner.next(); 
                }
                p[0] = scanner.nextInt();
    
                System.out.print("Informe a coluna: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Entrada inválida. Por favor, insira um número para a coluna.");
                        scanner.next();
                }
                p[1] = scanner.nextInt();
                
                if(velha[p[0]][p[1]].getSimbolo()!=' '){
                    System.out.println("Jogada invalida. Por favor, escolha uma posicao vazia dentro do tabuleiro.");
                    System.out.print("Informe a linha: ");
                    p[0] = scanner.nextInt();
                    System.out.print("Informe a coluna: ");
                    p[1] = scanner.nextInt();   
                }

            return p;
        }
            
            public static boolean verificarJogada(Campo[][] velha, int p[], char simboloAtual){
                if(velha[p[0]][p[1]].getSimbolo()==' '){
                    velha[p[0]][p[1]].setSimbolo(simboloAtual);
                    return true;
                }else{
                    return false;
                }
            }
            
            public static boolean verificaVitoria(Campo[][] velha, String player1, String player2,int pontPlayer1,int pontPlayer2) {
            for (char jogador : new char[]{'X', 'O'}) {
                for (int i = 0; i < 3; i++) {
                    if ((velha[i][0].getSimbolo() == jogador && velha[i][1].getSimbolo() == jogador && velha[i][2].getSimbolo() == jogador) ||
                        (velha[0][i].getSimbolo() == jogador && velha[1][i].getSimbolo() == jogador && velha[2][i].getSimbolo() == jogador)) {
                            
                        if(jogador == 'X'){
                            System.out.printf("%s (%c) venceu.%n",player1, jogador);
                            pontPlayer1++;
                            System.out.println("Placar: (X)"+pontPlayer1+" (O)"+pontPlayer2);
                            return true;
                        }else{
                            System.out.printf("%s (%c) venceu.%n",player2, jogador);
                            pontPlayer2++;
                            System.out.println("Placar: (X)"+pontPlayer1+" (O)"+pontPlayer2);                            
                            return true;
                        }
                }
            }
                    if ((velha[0][0].getSimbolo() == jogador && velha[1][1].getSimbolo() == jogador && velha[2][2].getSimbolo() == jogador) ||
                        (velha[0][2].getSimbolo() == jogador && velha[1][1].getSimbolo() == jogador && velha[2][0].getSimbolo() == jogador)) {
                        if(jogador == 'X'){
                            System.out.printf("%s (%c) venceu.%n",player1, jogador);
                            pontPlayer1++;
                            System.out.println("Placar: (X)"+pontPlayer1+" (O)"+pontPlayer2);
                            return true;
                        }else{
                            System.out.printf("%s (%c) venceu.%n",player2, jogador);
                            pontPlayer2++;
                            System.out.println("Placar: (X)"+pontPlayer1+" (O)"+pontPlayer2);
                            return true;
                        }
                    }
                }
            return false;
        }
            public static boolean verificaEmpate(Campo[][] velha) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (velha[i][j].getSimbolo() == ' ') {
                return false; 
                        }
                    }
                }
            return true;
        }
            public static void iniciarJogo(Campo[][] velha){
                for(int l=0;l<3;l++){
                    for(int c=0;c<3;c++){
                        velha[l][c] = new Campo();
                    }
                }
            }
}
