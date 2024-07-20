package com.starwarsexplorer.starwars.consultas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.starwarsexplorer.starwars.records.Vehiculo;

public class ConsultaVehiculo {
    private final Gson gson;

    public ConsultaVehiculo() {
        this.gson = new Gson();
    }


        public Vehiculo buscaVehiculo(int idVehiculo){
        URI direccion = URI.create("https://swapi.dev/api/vehicles/" + idVehiculo + "/");
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
          .uri(direccion)
           .build();

           try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
                    if (response.statusCode() == 200) {
                        String responseBody = response.body();
                        return gson.fromJson(responseBody, Vehiculo.class);
                    } else if (response.statusCode() == 404) {
                        System.out.println("Vehículo no encontrado. Es posible que haya sido destruido en una batalla con el imperio.");
                        return null;
                    } else {
                        System.out.println("La información sobre el vehículo ha sido comprometida por un virus escurridizo desde el Sector Corelliano.");
                        return null;
                    }
                } catch (Exception e) {
                    System.err.println("¡Se ha activado una alerta crítica en el sistema! Estamos movilizando a los ingenieros de la Alianza Rebelde para resolverlo.");
                    return null;
                }
        }
}