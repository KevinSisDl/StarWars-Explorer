import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
            Scanner lectura = new Scanner(System.in);
            Explorador explorador = new Explorador();

            while (true) {
                mostrarMenu();
    
                int opcion = lectura.nextInt();
                lectura.nextLine();
    
                switch (opcion) {
                    case 1:
                        explorador.consultarEspecie();
                        break;
                    case 2:
                        explorador.consultarNave();
                        break;
                    case 3:
                        explorador.consultarPelicula();
                        break;
                    case 4:
                        explorador.consultarPersonaje();
                        break;
                    case 5: 
                        explorador.consultarPlaneta();
                        break;
                    case 6: 
                        explorador.consultarVehiculo();
                        break;
                    case 7: 
                        explorador.guardarHistorial();
                        break;
                    case 8:
                        System.out.println("Hasta luego joven jedi. ¡Que la fuerza te acompañe!");
                        return;
                        default:
                        System.out.println("Opción invalida. Por favor ingrese un número válido.");
                }
            }
        }
    
        private static void mostrarMenu() {
            System.out.println("===== Star Wars Explorer Menu =====");
            System.out.println("1. Busca Especie");
            System.out.println("2. Busca Nave");
            System.out.println("3. Busca Pelicula");
            System.out.println("4. Busca Personaje");
            System.out.println("5. Busca Planeta");
            System.out.println("6. Busca Vehiculo");
            System.out.println("7. Guardar historial de busqueda");
            System.out.println("8. Salir");
            System.out.print("Ingrese el número de opción: ");
        }
}


