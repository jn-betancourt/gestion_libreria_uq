package com.biblioteca;

public class Libro {
    private String titulo;
    private Autor autor;
    private int numeroEjemplares;
    public Libro(String titulo, Autor autor, int numeroEjemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroEjemplares = numeroEjemplares;
    }
    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }
    
    public int getNumeroEjemplares() {
        return numeroEjemplares;
    }
    public void setNumeroEjemplares(int numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }
    
}
