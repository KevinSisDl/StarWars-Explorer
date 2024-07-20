import java.io.IOException;
import java.util.Scanner;

import com.starwarsexplorer.starwars.consultas.ConsultaEspecie;
import com.starwarsexplorer.starwars.consultas.ConsultaNave;
import com.starwarsexplorer.starwars.consultas.ConsultaPelicula;
import com.starwarsexplorer.starwars.consultas.ConsultaPersonaje;
import com.starwarsexplorer.starwars.consultas.ConsultaPlaneta;
import com.starwarsexplorer.starwars.consultas.ConsultaVehiculo;
import com.starwarsexplorer.starwars.records.Especie;
import com.starwarsexplorer.starwars.records.Nave;
import com.starwarsexplorer.starwars.records.Pelicula;
import com.starwarsexplorer.starwars.records.Personaje;
import com.starwarsexplorer.starwars.records.Planeta;
import com.starwarsexplorer.starwars.records.Vehiculo;

public class Explorador {
    private Scanner lectura;
    private ConsultaEspecie consultaEspecie;
    private ConsultaNave consultaNave;
    private ConsultaPelicula consultaPelicula;
    private ConsultaPersonaje consultaPersonaje;
    private ConsultaPlaneta consultaPlaneta;
    private ConsultaVehiculo consultaVehiculo;
    private GeneradorArchivoHistorial generadorHistorial;

    public Explorador(){
        lectura = new Scanner(System.in);
        consultaEspecie = new ConsultaEspecie();
        consultaNave = new ConsultaNave();
        consultaPelicula = new ConsultaPelicula();
        consultaPersonaje = new ConsultaPersonaje();
        consultaPlaneta = new ConsultaPlaneta();
        consultaVehiculo = new ConsultaVehiculo();
        generadorHistorial = new GeneradorArchivoHistorial();
    }

    public void consultarEspecie(){
        System.out.println("Ingrese el ID de la especie que desea investigar: ");
        int idEspecie = lectura.nextInt();
        Especie especie = consultaEspecie.buscaEspecie(idEspecie);
        System.out.println(especie);
        generadorHistorial.agregarBusqueda(especie);
    }

    public void consultarNave(){
        System.out.println("Ingresa el ID de la nave espacial que deseas explorar: ");
        int idNave = lectura.nextInt();
        Nave nave = consultaNave.buscaNave(idNave);
        System.out.println(nave);
        generadorHistorial.agregarBusqueda(nave);
    }

    public void consultarPelicula(){
        System.out.println("Ingresa el ID de la pelicula que quieres conocer más: ");
        int idPelicula = lectura.nextInt();
        Pelicula pelicula = consultaPelicula.buscaPelicula(idPelicula);
        System.out.println(pelicula);
        generadorHistorial.agregarBusqueda(pelicula);
    }

    public void consultarPersonaje(){
        System.out.println("Ingresa el ID del personaje que quieres explorar y conocer sus secretos: ");
        int idPersonaje = lectura.nextInt();
        Personaje personaje = consultaPersonaje.buscaPersonaje(idPersonaje);
        System.out.println(personaje);
        generadorHistorial.agregarBusqueda(personaje);
    }

    public void consultarPlaneta(){
        System.out.println("Ingresa el ID del planeta que deseas descubrir: ");
        int idPlaneta = lectura.nextInt();
        Planeta planeta = consultaPlaneta.buscaPlaneta(idPlaneta);
        System.out.println(planeta);
        generadorHistorial.agregarBusqueda(planeta);
    }

    public void consultarVehiculo(){
        System.out.println("Ingresa el ID del vehículo que quieras pilotar con velocidad: ");
        int idVehiculo = lectura.nextInt();
        Vehiculo vehiculo = consultaVehiculo.buscaVehiculo(idVehiculo);
        System.out.println(vehiculo);
        generadorHistorial.agregarBusqueda(vehiculo);
    }

    public void guardarHistorial(){
        try{
            generadorHistorial.guardarHistorial();
            System.out.println("Historial guardado exitosamente");
        } catch (IOException e){
            System.out.println("Error al guardar el historial" + e.getMessage());
        }
    }
}

