package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    //se usa una anotacion
//    @SerializedName("Title")
//
//    @SerializedName("Year")
        private String nombre;
        private int fechaDeLanzamiento;
        private int duracionEnMinutos;
        private boolean incluidoEnElPlan;
        private double sumaDeLasEvaluaciones;
        private int totalDeLasEvaluaciones;


    public Titulo(String nombre, int fechaDeLanzamiento, int duracionEnMinutos) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmdb.year());
        if (miTituloOmdb.runtime().contains("N/A")){
            throw new ErrorEnConversionDeDuracionException("No pude convertir la duración." + "porque contiene un N/A");
        }
        this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime().substring(0,3).replace(" ",""));
    }

    public int getTotalDeLasEvaluaciones(){
            return totalDeLasEvaluaciones;
        }

        //para colocar datos y get para obtener datos
        public String getNombre (){
            return nombre;
        }


        public int getFechaDeLanzamiento(){
            return fechaDeLanzamiento;
        }


        public int getDuracionEnMinutos(){
            return duracionEnMinutos;
        }
        public void setDuracionEnMinutos (int duracionEnMinutos){
            this.duracionEnMinutos = duracionEnMinutos;
        }

        public boolean getIncluidoEnElPlan(){
            return incluidoEnElPlan;
        }
        public void setIncluidoEnElPlan (boolean incluidoEnElPlan){
            this.incluidoEnElPlan = incluidoEnElPlan ;
        }
        public void mostrarFichaTecnica(){
            System.out.println("El nombre de la película es:" + nombre);
            System.out.println("Su fecha de lanzamiento es: "+ fechaDeLanzamiento);
            System.out.println("Su duración es:" + getDuracionEnMinutos());
        }

        public void evaluacion( double nota){
            sumaDeLasEvaluaciones = sumaDeLasEvaluaciones + nota;
            totalDeLasEvaluaciones ++;
        }

        public double calculaMedia(){
            return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
        }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
        //se compara el nombre del 1er objeto con otro título en este caso
    }

    @Override
    public String toString() {
        return
                "(nombre= " + nombre +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento+
                ",duración = " + duracionEnMinutos+ ")";
    }
}
