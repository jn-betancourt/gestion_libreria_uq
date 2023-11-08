package com.biblioteca;

import com.biblioteca.persona.Cliente;

public interface Prestamo {
    void crearPrestamo(Cliente cliente, Libro libro);
    void devolverPrestamo(RegistroPrestamo prestamo);
}
