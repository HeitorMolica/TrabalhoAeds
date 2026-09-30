
package arvorepatriciaaeds;

public class Posicao {
    private int linha;
    private int coluna;
    
    public Posicao(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }
    
    public String getPosicao(){
        return " L: " + linha + " C: " + coluna;
    }
}
