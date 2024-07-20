package com.starwarsexplorer.starwars.consultas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.starwarsexplorer.starwars.records.Especie;

public class ConsultaEspecie {
    private final Gson gson;

    public ConsultaEspecie() {
        this.gson = new Gson();
    }

        public Especie buscaEspecie(int idEspecie){
        URI direccion = URI.create("https://swapi.dev/api/species/" + idEspecie + "/");
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
          .uri(direccion)
           .build();

           try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
                    if (response.statusCode() == 200) {
                        String responseBody = response.body();
                        return gson.fromJson(responseBody, Especie.class);
                    } else if (response.statusCode() == 404) {
                        System.out.println("La información sobre esta especie ha sido destruida en la batalla de Endor");
                        return null;
                    } else {
                        System.out.println("La especie que buscas no ha sido encontrada. Parece que se ha perdido en el espacio interestelar");
                        return null;
                    }
                } catch (Exception e) {
                    System.err.println("¡Se ha producido un error interno! Los droides de mantenimiento están en ello.");
                    return null;
                }
        }
}