package com.alura.desafiostarwars.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        //System.out.println("Hola Mundirijillo");
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("Escriba numero de episodio");
        //Integer episodio = keyboardInput.nextInt();

        /*System.out.println("Elegiste el episodio " + episodio);

        String clave = "SinClave";
        String uri = "https://swapi.py4e.com/api/films/";
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
        }*/

        ConsultaPelicula consulta = new ConsultaPelicula();

        try{
            var numeroDePelicula = keyboardInput.nextLine();
            Pelicula pelicula = consulta.buscaPelicula(Integer.valueOf(numeroDePelicula));
            System.out.println(pelicula);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);
        } catch (NumberFormatException e){
            System.out.println("Numero no encontrado " + e.getMessage());
        } catch(RuntimeException | IOException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Finalizando la aplicacion...");
        }

    }
}