package br.edu.ifes.si.tpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaoo
 */
public class AlgoritmoTopAutores {
    
    private Map<Integer, Integer> autorPorArtigo;
    private int[] autorQtdArtigo;
    
    public AlgoritmoTopAutores(Digrafo G) {
        autorQtdArtigo = new int[G.getAutores().size()]; //Numeros de Autores 
        autorPorArtigo = G.getAutores(); //HashMap autor de cada Artigo
    }
    
    public int[] qtdCitacoesAutores(Digrafo G){
        for (int x = 0; x < autorQtdArtigo.length; x++){
            for (Aresta aresta : G.adj(x)) {
                int y = autorPorArtigo.get(aresta.getV2()); //Identifica qual é o autor (pega o artigo e devolve quem é o autor)
                autorQtdArtigo[y]++;
            }
        } 
        return autorQtdArtigo;
    }
    
    
}
