package Projeto_Pajek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class pajek {
    grafo G;
    int size;

    public pajek(grafo G) {
        this.G = G;
    }
    

    public void Load(File f) throws IOException{
        FileReader reader = new FileReader(f.getAbsolutePath());
        BufferedReader br = new BufferedReader(reader);
        
        String line = br.readLine();
                    
        if(line.startsWith("*Vertices ")){
            size = Integer.parseInt(line.substring(11));    //pega o tamanho do grafo
        }

        G = new grafo(size);
        
        boolean direcionado = false;
        String[] a;
        int c = 0;
        while ((line = br.readLine()) != null) {
            if (line.startsWith("*Arcs")) { //se comeca com edges, parar
                direcionado = true;
                G.direcionado = true;
                break;                
            }
            if (line.startsWith("*Edges")) {
                break;
            }
            if(line.isEmpty()){
                continue;         //se for linha em branco, ignora
            }
            line = line.replace("\"", "");
            a = line.split(" ",3);           //divide a linha entre o numero do nó e o nome dele
            G.seta_inform(c, a[1]);

            if (a.length>2){
                G.vertices[c].pontos=Integer.parseInt(a[2]);
            }

            c++;
            /*
            System.out.println("nó n:"+a[0]);
            System.out.println("nome:"+a[1]);
            System.out.println("");
            */
                        
        }
        
 
        
        while ((line = br.readLine()) != null) {
            if(line.isEmpty()){
                continue;         //se for linha em branco, ignora
            }
            if(line.startsWith("*Arcs")){
                System.out.println("batata");
                direcionado = true;         //se for direcionado
            }                
            
            
            a = line.split(" ");
            G.criar_adj(Integer.parseInt(a[0])-1, Integer.parseInt(a[1])-1, Integer.parseInt(a[2]));
            
            if(!direcionado){
                G.criar_adj(Integer.parseInt(a[1])-1, Integer.parseInt(a[0])-1, Integer.parseInt(a[2]));
            }
            /*
            System.out.println("inicio:"+a[0]);
            System.out.println("fim:"+a[1]);    
            System.out.println("peso:"+a[2]);
            System.out.println("");
            */
        }
            
                
        G.imprime_adj();
    }
    
    public void Write(File f,String S) throws IOException{
        FileWriter writer = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(writer);
        //int[][] ligacoes = new int[G.size][2];
        
        ArrayList<Integer>[] ligacoes = new ArrayList[2];
        ligacoes[0] = new ArrayList();
        ligacoes[1] = new ArrayList();
        
        String R;
        boolean direcionado = false;
        if (S.equals("direcionado")) {
            R = "*Arcs";
            direcionado = true;
        }
        else{
            R = "*Edges";
        }
        
        
        bw.write("*Vertices  "+G.size+"\n\n");
        
        for (int i = 0; i < G.size; i++) {
           // if (G.vertices[i].pontos!= null) {
                bw.write(i + 1 + " \"" + G.vertices[i].nome + "\" " + G.vertices[i].pontos + "\n");
            //}
        }
        bw.write("\n\n"+R+"\n\n");
        
        for (int i = 0; i < G.size; i++) {
            ArrayList<ListaSE.No> adj = new ArrayList();
            int c = G.adjacentes2(i, adj);
            
            for (int j = 0; j < c; j++) {
                
                if (!direcionado) {
                    boolean T = true;
                        for (int k = 0; k < ligacoes[0].size(); k++) {
                            if ((ligacoes[0].get(k) == i && ligacoes[1].get(k) == adj.get(j).fim) || (ligacoes[1].get(k) == i && ligacoes[0].get(k) == adj.get(j).fim)) {
                               T = false;
                                break;
                            }    
                        }
                    
                    if (T) {
                        bw.write((i+1)+" "+ (adj.get(j).fim+1) + " " + adj.get(j).peso + "\n");
                        ligacoes[0].add(i);
                        ligacoes[1].add(adj.get(j).fim);
                    }
                     
                }
                else if(direcionado){
                    bw.write((i+1)+" "+ (adj.get(j).fim+1) + " " + adj.get(j).peso + "\n");
                }
            }
        }
        bw.close();
        
        
        
    }
}
