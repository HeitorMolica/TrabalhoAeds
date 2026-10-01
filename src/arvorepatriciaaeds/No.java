
package arvorepatriciaaeds;

public class No {
    
    private No sad;
    private No sae;
    private int indice;
    private boolean folha;
    private Palavra palavra;
    
    public No(Palavra palavra){
        this.sad = null;
        this.sae = null;
        this.indice = 0;//0 a 127
        this.folha = true;
        this.palavra = palavra;
    }
    
    public No(){
        this.sad = null;
        this.sae = null;
        this.indice = 0;
        this.folha = false;
        this.palavra = null;
    }
    
    public Palavra getPalavra(){
        return this.palavra;
    }
    
    public void setSad(No no){
        this.sad = no;
    }
    
    public No getSad(){
        return this.sad;
    }
    
    public No getSae(){
        return this.sae;
    }
    
    public int getIndice(){
        return this.indice;
    }
    
    public void setSae(No no){
        this.sae = no;
    }

    public boolean isFolha() {
        return folha;
    }
    
    public void adicionarOcorrencia(Posicao posicao){
        this.palavra.adicionarPosicao(posicao); //adiciona nova posicao
    }
    
    public int comparar(Palavra palavra){
        String chave = palavra.getChave();
        for(int i = 0; i < 16; i++){
            if(this.palavra.getChave().charAt(i) != chave.charAt(i)){//se letra for diferente olhar o bit diferente
                for (int j = 7; j >= 0; j--) { //olhar cada bit por vez
                //comeca pelo mais significativo
                    
                    int bit1 = (this.palavra.getChave().charAt(i) >> j) & 1; //pega o bit da chave do no
                    int bit2 = (chave.charAt(i) >> j) & 1;//pega o bit da chave da palavra que esta tentando ser adicionada
                    
                    if (bit1 != bit2) {
                        return (i * 8) + (7-j); //retorna indice global de 0 a 127
                        
                    }
                }
            }
        }
        
        return 128; //se as chaves forem iguais
    }
    
    
    public void alterarNo(int indice){
        this.folha = false;
        this.indice = indice;
    }
    
    
    
}
