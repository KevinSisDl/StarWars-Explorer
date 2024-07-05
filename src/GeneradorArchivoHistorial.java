import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GeneradorArchivoHistorial {
    private List<Object> historial;

    public GeneradorArchivoHistorial(){
        this.historial = new ArrayList<>();
    }

    public void agregarBusqueda(Object busqueda){
        historial.add(busqueda);
    }

    public void guardarHistorial() throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritor = new FileWriter("historial.json");
        gson.toJson(historial, escritor);
        escritor.close();
    }
}
