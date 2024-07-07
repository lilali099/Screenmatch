package Principal;

import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        //PELICULAS
        Pelicula miPelicula = new Pelicula("Encanto",2021,120,"Nolan");
        miPelicula.setIncluidoEnElPlan(true);

        //llama método
        miPelicula.mostrarFichaTecnica();
        miPelicula.evaluacion(7.8);
        miPelicula.evaluacion(10);
        System.out.println(miPelicula.getTotalDeLasEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        //SERIES
        Serie casaDragon = new Serie("La casa del dragon",2001, 50, 1,10);
        casaDragon.mostrarFichaTecnica();

        //creación de objeto otraPelicula
        Pelicula otraPelicula = new Pelicula("Matrix", 1998,180,"Spielberg");


        System.out.println(casaDragon.getDuracionEnMinutos());

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);

        System.out.println("Tiempo necesario para ver tus películas favoritas: " + calculadora.getTiempoTotal() + "minutos.");

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio("La casa Targaryen",1);
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(300);

        filtroRecomendacion.filtra(episodio);


        ArrayList<Pelicula>listaDePelículas = new ArrayList<>();
        listaDePelículas.add(miPelicula);
        listaDePelículas.add(otraPelicula);
        System.out.println("Mostrame el tamaño de la lista:" +listaDePelículas.size());
        System.out.println("La primer película es:" + listaDePelículas.get(0));
        System.out.println(listaDePelículas);
    }
}

