package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificacion;

public class Pelicula  extends Titulo implements Clasificacion {
  private String director;

    public Pelicula(String nombre, int fechaDeLanzamiento, int duracionEnMinutos, String director) {
        super(nombre, fechaDeLanzamiento, duracionEnMinutos);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }



    @Override
    public int getClasificacion() {
        return (int) (calculaMedia() / 2);
    }

    @Override
    public String toString() {
        return "Pelicula: " +this.getNombre() + " (" +this.getFechaDeLanzamiento() + ")";
    }
}
