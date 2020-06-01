package br.com.bootcamp.jogo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PalavraChave {
    private static String palavraChave;
    private static ArrayList<String> dica = new ArrayList();
    public ArrayList<String> palavras = new ArrayList<String>();

    public void escolhePalavraChave(String nomeArquivo) {
        // Pega o arquivo
        File file = new File("./src/" + nomeArquivo + ".txt");
        Scanner inputFile = null;

        try { // tenta scanear o arquivo
            inputFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Preencher o array
        while (inputFile.hasNext()) {
            palavras.add(inputFile.next());
        }
        inputFile.close();

        // A partir  do arraylist seleciona uma palavra randomica
        palavraChave = palavras.get((int) (Math.random() * palavras.size())).toLowerCase();
        setPalavraChave(palavraChave);
        montaDica();
    }

    protected void montaDica(){
        for (int cont = 0; cont < getPalavraChave().length();cont++){
            dica.add(" _ ");
        }
        setDica(dica);
    }

    public String converteDicaEmString(){
        String novaDica = "";
        for(String g : getDica()){
            novaDica+=g;
        }
        return novaDica;
    }

    public static String getPalavraChave() {
        return palavraChave;
    }

    public static void setPalavraChave(String palavraChave) {
        PalavraChave.palavraChave = palavraChave;
    }

    public static ArrayList<String> getDica() {
        return dica;
    }

    public static void setDica(ArrayList<String> dica) {
        PalavraChave.dica = dica;
    }
}
