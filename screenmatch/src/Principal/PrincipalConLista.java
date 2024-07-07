package Principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConLista {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto",2021,120,"Nolan");
        Pelicula otraPelicula = new Pelicula("Matrix", 1998,180,"Spielberg");
        Serie casaDragon = new Serie("La casa del dragon",2001, 50, 1,10);

        ArrayList<Titulo> lista= new ArrayList<>();
        lista.add(miPelicula);
        miPelicula.evaluacion(8);
        lista.add(otraPelicula);
        otraPelicula.evaluacion(9);
        lista.add(casaDragon);
        //para saber tamaño de la lista
        System.out.println("Mostrame el tamaño de la lista:" +lista.size());
        //para saber cual esta en la posición inicial
        System.out.println("La primer película es:" + lista.get(0));

        for(Titulo item : lista) {
            System.out.println("Nombre: " +item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.println("Clasificacion: " +pelicula.getClasificacion());
            }
        }

        //para ordenar integrantes de la lista
        ArrayList<String> listaDeArtistas =new ArrayList<>();
        listaDeArtistas.add("Penelope Cruz");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Ricardo Darin");
        System.out.println("Mostrame la lista: " + listaDeArtistas);

        Collections.sort(listaDeArtistas);
        System.out.println("Mostrame la lista de artistas ordenada: "+ listaDeArtistas);

        Collections.sort(lista);
        System.out.println("Mostrame la lista de títulos ordenada: ");

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Mostrame la lista ordenada por fecha: "+lista);


    }
    }

