package com.biblioteca;

import com.biblioteca.persona.Cliente;
import java.time.LocalDate;

public class RegistroPrestamo{
    private Libro libro;
    private Cliente cliente;
    private LocalDate fechaPrestamo;

    public RegistroPrestamo(Libro libro, Cliente cliente) {
        this.libro = libro;
        this.cliente = cliente;
        this.fechaPrestamo = LocalDate.now();
    }

    public Libro getLibro() {
        return libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    
}
