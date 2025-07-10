package com.exerciciosDeFixacao;

import java.util.Scanner;

public class EntradaDadosScanner {

    public void CapturaDados() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu nome");
        String nome = scanner.nextLine();
        System.out.println("Nome capturado: " + nome);
    }

}
