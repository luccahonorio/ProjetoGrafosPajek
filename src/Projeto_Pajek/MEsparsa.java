package Projeto_Pajek;

public class MEsparsa {
    public ListaSE linhas[];
    public int size;
    
    public MEsparsa(int size){
        this.size = size;
        linhas = new ListaSE[size];
        for (int i = 0; i < size; i++) {
            linhas[i] = new ListaSE();
        }   
    }
    
    void insere(int i, int j, int valor){
       linhas[i].InsereUltimo(i,j,valor);
    }
    
    public int valor(int i, int j){
        ListaSE.No p = this.linhas[i].primeiro;
        if (p == null){
            return 99999;
        }
        while(p.fim != j){
            if (p.proximo==null) {
                return 9999999;
            }
            p = p.proximo;
        }
        return p.peso;
    }
       
}