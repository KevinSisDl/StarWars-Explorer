package com.starwarsexplorer.starwars.consultas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.starwarsexplorer.starwars.records.Planeta;

public class ConsultaPlaneta {
    private final Gson gson;

    public ConsultaPlaneta() {
        this.gson = new Gson();
    }

        public Planeta buscaPlaneta(int idPlaneta){
        URI direccion = URI.create("https://swapi.dev/api/planets/" + idPlaneta + "/");
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
          .uri(direccion)
           .build();

           try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
                    if (response.statusCode() == 200) {
                        String responseBody = response.body();
                        return gson.fromJson(responseBody, Planeta.class);
                    } else if (response.statusCode() == 404) {
                        System.out.println("Planeta no encontrado. Es posible que esté en una galaxia lejana");
                        return null;
                    } else {
                        System.out.println("Los registros de este planeta han sido dispersados por un agujero de gusano en el Borde Exterior");
                        return null;
                    }
                } catch (Exception e) {
                    System.err.println("¡Se ha desatado un error en el sistema! Los técnicos de la Academia Jedi están trabajando para resolver el problema.");
                    return null;
                }
        }
}