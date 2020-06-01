package br.com.bootcamp.jogo;

import java.util.ArrayList;
import java.util.Scanner;

public class Regras {
    private String[] listaLetrasCorretas;
    private ArrayList<String> dica = new ArrayList<String>();
    private PalavraChave palavraChave = new PalavraChave();
    private static int pontuacao = 10;
    private static boolean acertou;

    public void selecionaDificuldadeJogo(){
        Scanner in = new Scanner(System.in);
        System.out.print("Bem vindo ao jogo!\nQual dificuldade do jogo? F (Fácil); N (Normal); D (Difícil): ");
        String dificuldadeJogo = in.next();

        switch (dificuldadeJogo.toUpperCase()){
            case "F":
                palavraChave.escolhePalavraChave("listaFacil");
                break;
            case "N":
                palavraChave.escolhePalavraChave("listaNormal");
                break;
            case "D":
                palavraChave.escolhePalavraChave("listaDificil");
                break;
            default:
                System.out.println("Por Favor selecione uma opção válida.");
                System.exit(0);
        }
    }

    public void validaLetraInserida(String letraDigitada){
        listaLetrasCorretas = palavraChave.getPalavraChave().split("");
        int qtdLetras = palavraChave.getPalavraChave().length();
        dica = palavraChave.getDica();
        int i = 0;
        acertou = false;

        while (i < qtdLetras){
            if (listaLetrasCorretas[i].equals(letraDigitada)){
                dica.remove(i);
                dica.add(i,letraDigitada);
                acertou = true;
            }
            i++;
        }

        validaPalavra();
        controlaPontuacao(pontuacao);
        palavraChave.setDica(dica);
    }

    private void validaPalavra(){
        if (palavraChave.getPalavraChave().equals(palavraChave.converteDicaEmString())){
            System.out.println("Você ganhou o jogo, parabéns!");
            System.exit(0);
        }
    }

    private void controlaPontuacao (int pontuacao){
        this.pontuacao = (acertou ? pontuacao : pontuacao - 1);

        /*
        if (!acertou){
            this.pontuacao = pontuacao -1;
        }else{
            this.pontuacao = pontuacao;
        }
        */

        System.out.println("Vida(s): "+this.pontuacao);

        if (this.pontuacao == 0){
            System.out.println("Você Perdeu!!");
            System.exit(0);
        }
    }

    public static int getPontuacao() {
        return pontuacao;
    }
}
