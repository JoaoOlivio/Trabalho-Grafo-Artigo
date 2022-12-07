package br.edu.ifes.si.tpa;

import java.util.Arrays;
import java.util.List;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaoo
 */
public class AlgoritmoTopArtigos {
    
    private int[] qtdCitacoesArtigos;
    
    public AlgoritmoTopArtigos(Digrafo G) {
        qtdCitacoesArtigos = new int[G.V()];
    }
    
    public int[] citacoesPorArtigos(Digrafo G){
        for (int x = 0; x < G.V(); x++){
            for (Aresta aresta : G.adj(x)) {
                int y = aresta.getV2();
                qtdCitacoesArtigos[y]++;
            }
        } 
        return qtdCitacoesArtigos;
    }
}
