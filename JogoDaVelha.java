package com.mycompany.jogodavelha;

import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {
         char escolha;
         Scanner scanner = new Scanner(System.in);
         
         System.out.println("Para jogar singlePlayer digite 'S' para multiplayer digite 'M'");
         System.out.printf("Resposta: ");
         escolha = scanner.next().charAt(0);
         
        while(escolha != 'S' && escolha != 's' && escolha != 'M' && escolha != 'm'){
            System.out.println("Erro\nPara jogar singlePlayer digite 'S' para multiplayer digite 'M'");
            System.out.printf("Resposta: ");
            escolha = scanner.next().charAt(0);
        }
         if(escolha == 'S'){
                singlePlayer.singlePlayer();
         }else{
                multiPlayer.multiPlayer();
         }         
    }      
}        
         
    



