
package arvorepatriciaaeds;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ArvorePatriciaAEDS {
    public static void main(String[] args) {
        Arvore arvore1 = new Arvore();
        inserirArquivo(new File("exemplo1.txt"), arvore1);
        
        String[] palavrasExemplo1 = {
            "trabalho", "computacao", "governo", "educacao", 
            "tecnologia", "formacao", "desenvolvimento", 
            "que", "informatica", "em", "crise"
        };
        
        System.out.println("=== RESULTADOS EXEMPLO 1 ===");
        
        fazerBuscas(arvore1, palavrasExemplo1);
        
        Arvore arvore2 = new Arvore();
        inserirArquivo(new File("exemplo2.txt"), arvore2);
        
        String[] palavrasExemplo2 = {
            "sociedade", "software", "ideia", "pessoa", 
            "Informatica", "etica", "muito", "ciencia", 
            "computacao", "que", "area", "moral"
        };
        
        System.out.println("=== RESULTADOS EXEMPLO 2 ===");
        
        fazerBuscas(arvore2, palavrasExemplo2);
    
    /*    System.out.println("Resultados teste");
        Arvore arvoreTeste = new Arvore();
        inserirArquivo(new File("teste.txt"), arvoreTeste);
        String[] palavrasExemplo3 = {
            "carro", "aviao", "moto", "bola", "bota","bolaa", "bolaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            "testeaaaaaaaaaaaaaaaaaaaaaaaa", "testeaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", " "
        };
        fazerBuscas(arvoreTeste, palavrasExemplo3);
    */
    }
    
    public static void inserirArquivo(File file, Arvore arvore){
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
                    //System.out.println("Palavra: " + palavra + " l: " + linhaPalavra + "c: " + colunaPalavra);
                    arvore.inserirPalavra(new Palavra(palavra, linhaPalavra, colunaPalavra));
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
    
    public static void fazerBuscas(Arvore arvore, String[] palavras){
        for(String p: palavras){
            StringBuilder sb = new StringBuilder(p);
            if(sb.length() > 16){
                p = sb.substring(0, 16);
            }
            while(sb.length() < 16){//preenche com espacos ate ter 16 caracteres
                sb.append(' ');
            }
            p = sb.toString();
            
            No encontrada = arvore.busca(arvore.getRaiz(), p);
            if(encontrada != null){
                ArrayList<Posicao> posicao = encontrada.getPalavra().getPosicoes();
                System.out.println("Palavra: " + p + " Encontrada " + posicao.size() + " vezes");
                System.out.println("Posicoes: ");
                for(Posicao pos: posicao){
                    System.out.println(pos.getPosicao());
                }
                System.out.println("");
            }else
                System.out.println("Palavra " + p + " nao encontrada");
        }
    }
    
    public static boolean eletra(char c){
        return (c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z');
    }
    
    public static boolean edigito(char c){
        return (c >= '0' && c <= '9');
    }
    
}
