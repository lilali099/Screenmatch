package Principal;

import com.aluracursos.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura= new Scanner(System.in);
        List <Titulo>titulos=new ArrayList<>();

        Gson gson=new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting() //para crear una lista más linda en el archivo json
                .create();



        while (true){
            System.out.println("Escriba el nombre de una película :");
            var busqueda = lectura.nextLine();

            if(busqueda.equalsIgnoreCase("salir")){
                break;
            }

            String direccion ="https://www.omdbapi.com/?i=" + busqueda.replace("","+")
                    + "tt3896198&apikey=2664dac";

            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());


                String json= response.body();
                System.out.println(json);


                TituloOmdb miTituloOmdb= gson.fromJson(json, TituloOmdb.class);
                System.out.println(miTituloOmdb);

                Titulo miTitulo= new Titulo(miTituloOmdb);
                System.out.println("Título ya convertido" + miTitulo);

                titulos.add(miTitulo);

//                //una escritura que creara un archivo txt
//                FileWriter escritura = new FileWriter("Películas.txt");
//                escritura.write(miTitulo.toString());  //como solo se puede escribir texto (String), se transforma el objeto en String
//                escritura.close();

            }catch (NumberFormatException e){
                System.out.println("Ocurrió un error: ");
                System.out.println(e.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println("Error en la URI, verifique la dirección");
            } catch (ErrorEnConversionDeDuracionException e){
                System.out.println(e.getMensaje());
            }

        }
        System.out.println("Títulos: ");

        //Guardar títulos en algún archivo
        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();

        System.out.println("Finalizo la ejecución del programa");


    }
}
