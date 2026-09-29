
package arvorepatriciaaeds;

import java.util.ArrayList;

public class Palavra {
    private String chave;
    private ArrayList<Posicao> posicoes;


    public Palavra(String chave, Posicao posicao){
        this.chave = chave;
        this.posicoes.add(posicao);
    }
    
    public Palavra(String chave, int linha, int coluna){
        this.chave = formatarChave(chave);
        this.posicoes = new ArrayList<>();
        adicionarPosicao(linha, coluna);
    }
    
    public String getChave(){
        return this.chave;
    }
    
    public Posicao getPosicao(){
        return posicoes.getFirst();
    }
    
    public String formatarChave(String chave){ //deixa a palavra com 16 caracteres
        StringBuilder sb = new StringBuilder(chave);
        if(sb.length() > 16){
            return sb.substring(0, 16);
        }
        while(sb.length() < 16){//preenche com espacos ate ter 16 caracteres
            sb.append(' ');
        }
        return sb.toString();
    }
    
    public void adicionarPosicao(int linha, int coluna){ //adiciona cada posicao da palavra
        posicoes.add(new Posicao(linha, coluna));
    }
    
    public void adicionarPosicao(Posicao posicao){ //adiciona cada posicao da palavra
        posicoes.add(posicao);
    }
    
    
}

