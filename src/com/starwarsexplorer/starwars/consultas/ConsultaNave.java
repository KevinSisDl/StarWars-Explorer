package com.starwarsexplorer.starwars.consultas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.starwarsexplorer.starwars.records.Nave;

public class ConsultaNave {
    private final Gson gson;

    public ConsultaNave() {
        this.gson = new Gson();
    }

        public Nave buscaNave(int idNave){
        URI direccion = URI.create("https://swapi.dev/api/starships/" + idNave + "/");
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
          .uri(direccion)
           .build();

           try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
                    if (response.statusCode() == 200) {
                        String responseBody = response.body();
                        return gson.fromJson(responseBody, Nave.class);
                    } else if (response.statusCode() == 404) {
                        System.out.println("Nave no encontrada. Es posible que esté en una misión secreta!");
                        return null;
                    } else {
                        System.out.println("La información de esta nave ha sido borrada. Parece que se perdió en la derrota de la Estrella de la Muerte");
                        return null;
                    }
                } catch (Exception e) {
                    System.err.println("¡Se ha producido un error! Los tecnicos astromecánicos están trabajando para resolverlo");
                    return null;
                }
        }
}