package com.starwarsexplorer.starwars.consultas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.starwarsexplorer.starwars.records.Pelicula;

public class ConsultaPelicula {
    private final Gson gson;

    public ConsultaPelicula() {
        this.gson = new Gson();
    }

    public Pelicula buscaPelicula(int numeroDePelicula){
        URI direccion = URI.create("https://swapi.dev/api/films/"+numeroDePelicula + "/");
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
          .uri(direccion)
           .build();

           try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
                    if (response.statusCode() == 200) {
                        String responseBody = response.body();
                        return gson.fromJson(responseBody, Pelicula.class);
                    } else if (response.statusCode() == 404) {
                        System.out.println("Película no encontrada. Es posible que esté en una dimensión paralela");
                        return null;
                    } else {
                        System.out.println("La película ha sido interrumpida por una manada de banthas galácticos.");
                        return null;
                    }
                } catch (Exception e) {
                    System.err.println("¡Se ha activado el protocolo de emergencia! Un rancor virtual ha invadido nuestro sistema.");
                    return null;
                }
        }
}