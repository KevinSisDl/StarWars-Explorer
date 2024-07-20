package com.starwarsexplorer.starwars.consultas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.starwarsexplorer.starwars.records.Personaje;

public class ConsultaPersonaje {
    private final Gson gson;

    public ConsultaPersonaje() {
        this.gson = new Gson();
    }

        public Personaje buscaPersonaje(int idPersonaje){
        URI direccion = URI.create("https://swapi.dev/api/people/" + idPersonaje + "/");
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
          .uri(direccion)
           .build();

           try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
                     if (response.statusCode() == 200) {
                        String responseBody = response.body();
                        return gson.fromJson(responseBody, Personaje.class);
                    } else if (response.statusCode() == 404) {
                        System.out.println("Personaje no encontrado. Es posible que ha sido capturado por el imperio.");
                        return null;
                    } else {
                        System.out.println("Los registros de este personaje han sido borrados. Parece que la información ha sido corrompida.");
                        return null;
                    }
                } catch (Exception e) {
                    System.err.println("¡Ha ocurrido un fallo en el sistema! Los ingenieros estelares están en proceso de reparación.");
                    return null;
                }
        }
}
                    