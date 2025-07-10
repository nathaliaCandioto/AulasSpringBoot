package com.exerciciosdefixacao;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


   public class taboadaDodois {
        public static void main(String[] args) {
            int n=2;
            for (int i = 0; i <= 10; i++){

                System.out.println(+n+" X "+i+ " = "+n*i);

            }
            System.out.println("fim do for \n *****************************************");

            while (n==2){
                int i =1;
               // System.out.println(+i);
                int operacao=n*i;

                System.out.println(+operacao);
                i++;
                System.out.println(+i);
               System.out.println(+n+" X "+i);



            }
        }

    }


