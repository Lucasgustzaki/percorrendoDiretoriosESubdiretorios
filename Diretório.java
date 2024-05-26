/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;

/**
 *
 * @author lucassamuelgustzaki
 */
public class Diretorio {

    private File diretorio;

    public Diretorio(String caminho) {
        diretorio = new File(caminho);

        if (!diretorio.isDirectory()) {
            throw new IllegalArgumentException("O diretório não existe");

        }
    }

    public long obterTamanhoArquivos() {
        return obterTamanhoArquivos(diretorio);
    }

    private long obterTamanhoArquivos(File diretorio) {
        long tamanhoTotal = 0;
        File[] listaDiretorio = diretorio.listFiles();

        if (listaDiretorio != null) {
            for (File item : listaDiretorio) { // criando uma lista e percorrendo dentro do diretorio
                if (item.isDirectory()) { // verificando daquele 1˚ diretorio que usuário colocou como entrada tem um diretorio
                    tamanhoTotal += obterTamanhoDiretorio(item); // encontrou um diretorio na lista, logo "item" é um diretorio,
                } else {
                    tamanhoTotal += item.length();   // entra aqui quando é arquivo e soma o total de bytes do arquivos
                    System.out.println("Arquivo: " + item.getAbsolutePath() + " - Tamanho: " + item.length());
                }
            }
        }
        return tamanhoTotal;
    }

    public long obterTamanhoDiretorio(File diretorio) {
        long tamanhoDiretorio = 0;
        File[] listaSubdiretorio = diretorio.listFiles();// percorrendo o subdiretorio

        if (listaSubdiretorio != null) {
            for (File itemSubdiretorio : listaSubdiretorio) {
                if (itemSubdiretorio.isDirectory()) {
                    tamanhoDiretorio += obterTamanhoDiretorio(itemSubdiretorio);
                } else {
                    tamanhoDiretorio += itemSubdiretorio.length();
                    System.out.println("Arquivo: " + itemSubdiretorio.getAbsolutePath() + " - Tamanho: " + itemSubdiretorio.length());

                }
            }
        }

        System.out.println("Diretório: " + diretorio.getAbsolutePath() + " - Tamanho Total: " + tamanhoDiretorio + " bytes");
        return tamanhoDiretorio;
    }

}
