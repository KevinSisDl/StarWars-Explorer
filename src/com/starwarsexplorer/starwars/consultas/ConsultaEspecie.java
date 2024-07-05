package com.starwarsexplorer.starwars.consultas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.starwarsexplorer.starwars.records.Especie;

public class ConsultaEspecie {

        public Especie buscaEspecie(int idEspecie){
        URI direccion = URI.create("https://swapi.dev/api/species/" + idEspecie + "/");
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
          .uri(direccion)
           .build();

           try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Especie.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró esa especie!");
        }
    }
}