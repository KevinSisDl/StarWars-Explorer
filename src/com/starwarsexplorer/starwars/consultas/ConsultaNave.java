package com.starwarsexplorer.starwars.consultas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.starwarsexplorer.starwars.records.Nave;

public class ConsultaNave {
        public Nave buscaNave(int idNave){
        URI direccion = URI.create("https://swapi.dev/api/starships/" + idNave + "/");
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
          .uri(direccion)
           .build();

           try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Nave.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró la información de la nave espacial!");
        }
    }
}