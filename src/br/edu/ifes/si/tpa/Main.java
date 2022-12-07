/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.si.tpa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author joaoo
 */
public class Main {
    public static void main(String[] args) {
        
       Scanner scanner = new Scanner(System.in);
       Digrafo G = new Digrafo(new In("./Digrafo4.txt"));

       menu(G, scanner);
    }
    
    public static void menu(Digrafo G, Scanner scanner) {
        
        int opcao = 0;
        do {
            System.out.println("\n --- Menu ---");
            System.out.println("1 - Menor caminho entre dois artigos");
            System.out.println("2 - Todos os caminhos entre dois artigos");
            System.out.println("3 - Número de citações de cada artigo");
            System.out.println("4 - Número de citações de cada autor");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            if( opcao > 0 && opcao < 5){
                switch (opcao) {
                    case 1:
                        // Menor caminho entre dois artigos
                        menorQtdArtigosLidos(G, scanner);
                        break;
                    case 2:
                        //Todos os caminhos entre dois artigos
                        todosCaminhos(G, scanner);
                        break;
                    case 3:
                        // Número de citações de cada artigo
                        topArtigo(G);
                        break;
                    case 4:
                        //  Número de citações de cada autor
                        topAutores(G);
                        break;
                    default:
                        System.err.println("Opção Inválida! Tente Novamente");
                        break;
                }
            }else{
                if(opcao != 5){
                    System.err.println("Opção Inválida! Tente Novamente");
                }else{
                    System.out.println("Até a proxima!");
                }
            }
        } while (opcao != 5);
    }
    
    public static void menorQtdArtigosLidos(Digrafo G, Scanner scanner) {
        
        int valorOrigem = 0;
        int valorDestino = 0;
        
        System.out.println("Digite o ID do artigo origem: ");
        valorOrigem = scanner.nextInt();
        
        System.out.println("Digite o ID do artigo destino: ");
        valorDestino= scanner.nextInt();
        
        AlgoritimoMenorQtdArtigosLidos algoritmoBFS = new AlgoritimoMenorQtdArtigosLidos(G, valorOrigem);

        if (algoritmoBFS.temCaminhoPara(valorDestino)) {
            System.out.printf("%d para %d (%d):  ", valorOrigem, valorDestino, algoritmoBFS.distanciaPara(valorDestino));
            for (int x : algoritmoBFS.caminhoPara(valorDestino)) {
                if (x == valorOrigem) {
                    System.out.print(x);
                } else {
                    System.out.print("->" + x);
                }
            }
            System.out.println();
        } else {
            System.out.printf("%d para %d (-):  não conectado\n", valorOrigem, valorDestino);
        }
    }
    
    public static void todosCaminhos(Digrafo G, Scanner scanner) {
            
        int valorOrigem = 0;
        int valorDestino = 0;
        
        System.out.println("Digite o ID do artigo origem: ");
        valorOrigem = scanner.nextInt();
        
        System.out.println("Digite o ID do artigo destino: ");
        valorDestino = scanner.nextInt();
        
        System.out.println("");
        System.out.printf("b) Todos os caminhos simples entre %d e %d \n", valorOrigem,valorDestino);
        AlgoritmoTodosCaminhos todosCaminhos = new AlgoritmoTodosCaminhos(G, valorOrigem, valorDestino);
        System.out.println("# Caminhos = " + todosCaminhos.numeroDeCaminhos());
    }

    public static void topArtigo(Digrafo G){
        
        AlgoritmoTopArtigos topArtigos = new AlgoritmoTopArtigos(G);
        int[] qtdCitacoesArtigos = topArtigos.citacoesPorArtigos(G);
        
        System.out.println("\nc) Top artigos");
        for(int x = 0; x < G.V(); x++){
            System.out.printf("%d : %d \n", x, qtdCitacoesArtigos[x]);
        }
    }
    
    public static void topAutores(Digrafo G){
        
        AlgoritmoTopAutores topAutores = new AlgoritmoTopAutores(G);
        int[] autorQtdArtigo = topAutores.qtdCitacoesAutores(G);
        
        System.out.println("\nd) Top autores");
        for(int x = 0; x < G.getAutores().size(); x++){
            if(autorQtdArtigo[x] > 0){
                System.out.printf("%d : %d \n", x, autorQtdArtigo[x]);
            }
            
        }
    }
    
}
