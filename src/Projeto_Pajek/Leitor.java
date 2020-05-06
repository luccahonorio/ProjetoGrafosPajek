package Projeto_Pajek;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Leitor {
    grafo G;
    int size;

    public Leitor(grafo g, int size) {
        G = g;
        this.size = size;
    }

    public void Load(File f) throws IOException {
        FileReader reader = new FileReader(f.getAbsolutePath());
        BufferedReader br = new BufferedReader(reader);

        String line = br.readLine();        //elimina primeira linha
        G = new grafo(size);
        String[] a;
        int contador = -1;
        ArrayList<String> users = new ArrayList();
        int adj = 0;


        while ((line = br.readLine()) != null) {
            if(line.isEmpty()){
                continue;         //se for linha em branco, ignora
            }

            a = line.split(";");      // divide a linha entre suas informacoes

            if (!users.contains(a[2]) && !a[2].equals("[deleted]")){     // elimina repeticoes e usuarios deletados
                users.add(a[2]);
                contador++;     // conta qnt de usuarios
                G.seta_inform(contador,a[2]);  // da nome ao nó
                //System.out.println(a[2]);
            }
            if(!a[2].equals("[deleted]")) {                      // define os comentarios e a quem ele respondeu
                G.vertices[G.busca_no(a[2])].comments.add(a[0]);
                if (!a[3].startsWith("t3")) { // caso comece com t3, seu parente é um post e nao um comentario, logo é ignorado
                    G.vertices[G.busca_no(a[2])].parents.add(a[3].substring(3));
                }
                G.vertices[G.busca_no(a[2])].pontos += Integer.parseInt(a[4]);
            }
        }

        //relaciona conexoes entre comentarios de cada usuario
        for (int i = 0; i < size; i++) {               // para cada usuario i
            //System.out.println("progresso:"+i);
            ArrayList<String> parents = G.vertices[i].parents;
            for (int j = 0; j < parents.size(); j++) {      //para cada comment que este usuário respondeu
                for (int k = 0; k < size; k++) {                   // confere quem criou este comentario, e cria a adjacência ente i e k
                    if (G.vertices[k].comments.contains(parents.get(j))){
                        G.criar_adj(i, k, 1);
                        adj++;
                    }
                }
            }
        }

        //G.imprime_adj();
        System.out.println("Nós:"+users.size());
        System.out.println("arestas:"+adj);
        System.out.println("nome:"+G.vertices[0].nome);
        System.out.println("pontos:"+G.vertices[0].pontos);


    }

}
