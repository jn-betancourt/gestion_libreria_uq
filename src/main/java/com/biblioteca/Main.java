package com.biblioteca;

import com.biblioteca.persona.Cliente;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Autor autorCartas = new Autor("Fiodor", "Dostoiévski");
        Libro cartasDelSubsuelo = new Libro("Cartas del subsuelo", autorCartas, 2);

        Cliente juanAntonio = biblioteca.registrarCliente("Juan", "Betancourt", 18, 300);

        biblioteca.registrarLibro(cartasDelSubsuelo);
        biblioteca.crearPrestamo(juanAntonio, cartasDelSubsuelo);

        System.out.println(cartasDelSubsuelo.getNumeroEjemplares()); // debe ser iguala 1
    }
}