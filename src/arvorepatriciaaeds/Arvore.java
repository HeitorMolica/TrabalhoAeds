
package arvorepatriciaaeds;

public class Arvore {
    
    private No raiz;
    private String nome;
    
    
    
    public Arvore(){
        this.raiz = null;
    }
    
    public void inserirPalavra(Palavra palavra){
        this.raiz = inserirPalavraRecursiva(this.raiz, palavra);
    }
    
   
    public No inserirPalavraRecursiva(No raizAtual, Palavra novaPalavra) {
        //acha valor do indice da folha mais parecida
        if (raizAtual == null) {
            return new No(novaPalavra);
        }
        
        No folhaEncontrada = raizAtual;
        //procurar folha mais parecida
        while (!folhaEncontrada.isFolha()) {
            int bit = novaPalavra.getBitDaPalavra(novaPalavra.getChave(), folhaEncontrada.getIndice());
            if (bit == 1) {
                folhaEncontrada = folhaEncontrada.getSad();
            } else {
                folhaEncontrada = folhaEncontrada.getSae();
            }
        }
    
        //compara a folha encontrada com a nova palavra
        int indiceDiferente = folhaEncontrada.comparar(novaPalavra);
    
        // se for igual a palavra ja existe
        if (indiceDiferente == 128) {
            folhaEncontrada.adicionarOcorrencia(novaPalavra.getPosicao());
            return raizAtual;
        }
        else{//inserir no lugar certo
            return inserirEntre(raizAtual, novaPalavra, indiceDiferente);    
        }
    }
    
    private No inserirEntre(No noAtual, Palavra novaPalavra, int indiceDiferente) {
        // se achou uma folha ou achou um nó interno que testa um bit maior ou igual
        if (noAtual.isFolha() || (noAtual.getIndice() >= indiceDiferente)) {
            // cria a nova folha que vai guardar a nova palavra
            No novaFolha = new No(novaPalavra);
            // cria o novo no interno
            No novoInterno = new No(); 
            novoInterno.alterarNo(indiceDiferente); //folha=false e indice = indiceDiferente

            int bitDaNovaPalavra = novaPalavra.getBitDaPalavra(novaPalavra.getChave(), indiceDiferente);
        
                if (bitDaNovaPalavra == 1) {
                    novoInterno.setSad(novaFolha);
                    novoInterno.setSae(noAtual); // o no anterior desce para a esquerda
                } 
                else {
                    novoInterno.setSae(novaFolha);
                    novoInterno.setSad(noAtual); // o no anterior desce para a direita
                }
            return novoInterno;
        }
        
        //se nao achar um indice maior ou uma folha desce novamente 
        int bit = novaPalavra.getBitDaPalavra(novaPalavra.getChave(), noAtual.getIndice());
        if (bit == 1) {
            noAtual.setSad(inserirEntre(noAtual.getSad(), novaPalavra, indiceDiferente));
        } 
        else {
            noAtual.setSae(inserirEntre(noAtual.getSae(), novaPalavra, indiceDiferente));
        }
    
        return noAtual;
    }
}

