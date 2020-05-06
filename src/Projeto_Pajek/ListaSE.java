package Projeto_Pajek;

public class ListaSE {
    public No primeiro = null;
    public No ultimo = null;

    public ListaSE() {}
    
        public class No {
            public int inicio;
            public int fim;
            public int peso;
            public No proximo;

            public No(int inicio, int fim, int peso) {
                this.inicio = inicio;
                this.fim = fim;
                this.peso = peso;
            }

            public void SetProximo(No novo){
                this.proximo = novo;
            }
        }
    
    public boolean Vazia(){
        if(primeiro == null){
            return true;
        }
        return false;
    }
    
    public void InserePrimeiro(int inicio,int fim,int peso){ // define o primeiro nó, caso a lista ja tenha um, este vira o próximo do novo primeiro
        No novo = new No(inicio,fim,peso);
        
        if(this.Vazia()){ 
            this.primeiro = novo; 
            this.ultimo = novo;
        }
        else{
           novo.proximo= this.primeiro;
           this.primeiro = novo;
        }
    }
    
    public No InsereDepois(No p,int inicio, int fim, int peso){ // insere um nó após P, tornando o novo nó o próximo de P, o próximo do novo o antigo próximo de P 
        try{ 
            No novo = new No(inicio,fim,peso);
            novo.SetProximo(p.proximo);
            p.proximo = novo;
            return novo;
        }
        catch(Exception ex){
            System.out.println("erro!!!");
            return null;
        }
    }
    
    public void InsereUltimo(int inicio,int fim, int peso){ 
        if(this.Vazia()){
            this.InserePrimeiro(inicio,fim,peso);
        }
        else{
            this.ultimo = InsereDepois(this.ultimo,inicio,fim,peso);
        }      
    }
       
    public void imprimir(){  // printa o primeiro nó e incrementa, até que o próximo seja nulo
        No p  = this.primeiro;
        while(p!=null){
            System.out.print("["+p.fim+","+p.peso+"] ");
            p = p.proximo;
        }
    }
  
    
}