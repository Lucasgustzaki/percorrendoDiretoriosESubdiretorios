/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import model.Diretorio;

/**
 *
 * @author lucassamuelgustzaki
 */
public class App {

    public static void main(String[] args) {
        Scanner digita = new Scanner(System.in);
        caminhoDiretorio(digita);
        digita.close();

    }

    public static void caminhoDiretorio(Scanner digita) { 
        System.out.println("Digite o caminho do Diretório:");
        String caminho = digita.nextLine();
        
        Diretorio diretorio = new Diretorio(caminho);
        long tamanhoArquivos = diretorio.obterTamanhoArquivos();
        
        System.out.println(tamanhoArquivos);

    }

}
