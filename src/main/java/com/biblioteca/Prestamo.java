package com.biblioteca;

import java.time.LocalDate;

import com.biblioteca.persona.Cliente;


public interface Prestamo {
    void crearPrestamo(Cliente cliente, Libro libro);
    void devolverPrestamo(Libro libro, LocalDate fechaPrestamo);
}
