package com.alura.desafiostarwars.principal;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPelicula {

    Pelicula buscaPelicula(int numeroDePelicula){

        String clave = "SinClave";
        String uri = "https://swapi.py4e.com/api/films/";
        String direccion = uri + numeroDePelicula + "/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();


        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Pelicula.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa pelicula.");
        }


    }
}





































