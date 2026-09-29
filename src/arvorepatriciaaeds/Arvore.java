
package arvorepatriciaaeds;

public class Arvore {
    
    private No raiz;
    private String nome;
    
    
    
    public Arvore(Palavra palavra){
        this.raiz = new No(palavra);
    }
    
    public void inserirPalavra(No no, Palavra palavra){
        if(no.comparar(palavra) == -1){
            no.adicionarOcorrencia(palavra.getPosicao());
        }
    }
    
}

