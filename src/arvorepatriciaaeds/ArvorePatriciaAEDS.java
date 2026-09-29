
package arvorepatriciaaeds;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ArvorePatriciaAEDS {
    public static void main(String[] args) {
        //Palavra palavraIinicial1, palavraInicial2;
        //Arvore arvore1 = new Arvore(Palavra palavraInicial1);
        //Arvore arvore2 = new Arvore(Palavra palavraInicial2);
        inserirArquivo(new File("exemplo1.txt"));
        inserirArquivo(new File("exemplo1.txt"));
        
    }
    
    public static void inserirArquivo(File file){
        int coluna = 1;
        int linha = 1;
        String palavra = "";
        int colunaPalavra = 1;
        int linhaPalavra = 1;
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao abrir arquivo");;
        }
        scanner.useDelimiter(""); //le um caractere por vez
        while(scanner.hasNext()){
            char c = scanner.next().charAt(0);// transforma String de tamanho 1 em char
            if(eletra(c)){//se for letra
                if(palavra.isEmpty()){//se palavra for vazia deve comecar uma nova palavra
                    colunaPalavra = coluna;
                    linhaPalavra = linha;
                }
                palavra += c;
                coluna++;
            }
            else if(edigito(c)){
                if(palavra.isEmpty()){//nao pode comecar com digito
                    
                }
                else{//nao esta vazia
                    palavra += c;
                }
                coluna++;
            }
            else{//espaco, pontuacao ou \n
                if(!palavra.isEmpty()){ // adiciona palavra
                    //System.out.println("Palavra: " + palavra + "l: " + linhaPalavra + "c: " + colunaPalavra);
                    //arvore.inserirPalavra(new Palavra(palavra, linhaPalavra, colunaPalavra));
                    palavra = "";// esvazia a palavra
                }
                
                if(c == '\n'){
                    linha++;
                    coluna = 1;
                }
                else if(c == '\r'){
                    
                }
                else{
                    coluna++;
                }
            }
            
        }
        scanner.close();
    }
    
    public static boolean eletra(char c){
        return (c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z');
    }
    
    public static boolean edigito(char c){
        return (c >= '0' && c <= '9');
    }
    
}
