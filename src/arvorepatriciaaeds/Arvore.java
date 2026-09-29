
package arvorepatriciaaeds;

public class Arvore {
    
    private No raiz;
    private String nome;
    
    
    
    public Arvore(Palavra palavra){
        this.raiz = new No(palavra);
    }
    
    public void inserirPalavra(No no, Palavra palavra){
        this.raiz = inserirPalavraRecursiva(no, palavra);
    }
    
    public No inserirPalavraRecursiva(No no, Palavra palavra){
        if(no == null){
            return new No(palavra);
        }
        
        if(no.isFolha()){//se for folha
            int indice = no.comparar(palavra);//acha indice diferente e retorna
            //se indice for igual a 128 quer dizer que as chaves sao iguais
            if(indice == 128){//adiciona posicao
                no.adicionarOcorrencia(palavra.getPosicao());
            }
            else{//se for diferente 
                No temp = no;
                no.alterarNo(indice);//define como folha = false e indice = indice diferente
                if(palavra.getChave().charAt(no.getIndice()) == 1){// se o bit da chave da palavra for igual a 1
                    no.setSad(new No(palavra));//sad vira novo no
                    no.setSae(new No(no.getPalavra()));
                }
                else{
                    no.setSae(new No(palavra));//sae vira novo no
                    no.setSad(new No(no.getPalavra()));
                }
            }
        }
        else{ //no nao e folha
            //se o bit da chave da palavra no indice for igual a 1, ele vai para sad
            if(palavra.getChave().charAt(no.getIndice()) == 1){
                return inserirPalavraRecursiva(no.getSad(), palavra);
            }
            //se o bit da chave da palavra no indice for 0 ele vai para sae
            else{
                return inserirPalavraRecursiva(no.getSae(), palavra);
            }
        }
        
        
        
        return null;
    }
    
}

