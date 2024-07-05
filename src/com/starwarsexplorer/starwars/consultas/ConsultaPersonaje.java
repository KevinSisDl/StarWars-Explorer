package com.starwarsexplorer.starwars.consultas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.starwarsexplorer.starwars.records.Personaje;

public class ConsultaPersonaje {

        public Personaje buscaPersonaje(int idPersonaje){
        URI direccion = URI.create("https://swapi.dev/api/people/" + idPersonaje + "/");
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
          .uri(direccion)
           .build();

           try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Personaje.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró el personaje!");
        }
    }
}