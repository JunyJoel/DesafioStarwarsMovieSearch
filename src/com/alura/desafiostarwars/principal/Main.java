package com.alura.desafiostarwars.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
//        System.out.println("Hola Mundirijillo");
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("Escriba numero de episodio");
        Integer episodio = keyboardInput.nextInt();

        System.out.println("Elegiste el episodio " + episodio);

        String clave = "SinClave";
        String url = "https://swapi.py4e.com/api/films/";
        String direccion = url + episodio + "/";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            System.out.println("enviando request a SWAPI");

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("convirtiendo respuesta en string");

            String json = response.body();
            System.out.println(json);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}