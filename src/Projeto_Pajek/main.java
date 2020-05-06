package Projeto_Pajek;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class main {

    public static void main(String[] args) throws IOException {
        /* ================== ler e salvar pajek ================  */

        grafo G = null;
        pajek P = new pajek(G);
        
        File ler = new File("arquivos\\grafo revisao.txt");
        //File ler_base = new File("arquivos/comentarios pajek.txt");
        //File escrever = new File("arquivos/teste1.txt");
        
        P.Load(ler);


        //P.Write(escrever,"direcionado");


        /*=======================resultados da revisao ====================*/
        System.out.println();
        System.out.println("é conexo: "+ P.G.SerConexo()+"\n");
        System.out.println("é euleriano: "+ P.G.euleriano(P.G.ContaComponentes().size())+"\n");
        System.out.println("é cíclico: "+ P.G.ciclico()+"\n");
        System.out.println("Agrupamento local do:");
        for (int i = 0; i < P.G.size; i++) {
            System.out.println("Nó "+i+": "+P.G.Agrupamento_local(i));
        }
        System.out.println("\nAgrupamento médio: "+P.G.Agrupamento_Medio()+"\n");

        P.G.Centralidade_Posicionamento();
        System.out.println("centralidade de posicionamento do: ");
        for (int i = 0; i < P.G.size; i++) {
            System.out.println("Nó "+i+": "+P.G.vertices[i].cent_posicionamento);
        }

        P.G.Centralidade_Intermediacao();
        System.out.println("\ncentralidade de Intermediação do: ");
        for (int i = 0; i < P.G.size; i++) {
            System.out.println("Nó "+i+": "+P.G.vertices[i].cent_intermediacao);
        }


         /*================== gerador de grafo aleatório =============
        int vertices = 7000;
        int arestas = 25000;
        
        grafo G = new grafo(vertices); 
        
        Gerador gerador = new Gerador(G);
        gerador.criar(vertices, arestas, "conexo");
        
        //G.imprime_adj();

        */

         
         /*================== busca de componentes com largura ================

        //LinkedList<Integer> R = P.G.BuscaComponente2(9);
        //System.out.println(R);

        //System.out.println(G.ContaComponentes());

        //System.out.println(P.G.ciclico());
        //System.out.println(G.euleriano(G.conectividade()));

        */


         /* ================leitor da base ====================

        grafo G = null;
        File ler = new File("arquivos\\comentarios programming.csv");

        Leitor L = new Leitor(G,11506);
        L.Load(ler);

        pajek P = new pajek(L.G);

        File escrever = new File("arquivos/comentarios pajek.txt");
        P.Write(escrever,"direcionado");
*/

    }
}
