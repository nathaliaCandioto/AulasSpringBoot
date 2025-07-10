package com.exerciciosdefixacao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class EntradaDadosScanner {
    String [] arrayDestring = new String[2];
    Scanner scanner = new Scanner(System.in);

    @GetMapping
    public void capturaDados() {

        System.out.println("Digite seu nome");
       // String nome = scanner.nextLine();
         arrayDestring[0] = scanner.nextLine();
        System.out.println("Nome capturado: " + arrayDestring[0]);

        System.out.println("Digite seu país :");
       // String pais = scanner.nextLine();
        arrayDestring[1] = scanner.nextLine();
        System.out.println(" país : " + arrayDestring[1]);

//        System.out.println("Digite sua idade");
//        int idade = scanner.nextLine();
//        System.out.println(" idade : " + idade);

        //return arrayDestring.toString() ;

            }

}
