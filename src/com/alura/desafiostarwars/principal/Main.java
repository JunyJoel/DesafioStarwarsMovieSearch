package com.alura.desafiostarwars.principal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hola Mundirijillo");
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("Escriba numero de episodio");
        Integer episodio = keyboardInput.nextInt();

        System.out.println("Elegiste el episodio " + episodio);
    }
}