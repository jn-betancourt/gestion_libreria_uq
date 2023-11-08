package com.biblioteca;

import com.biblioteca.persona.Cliente;
import java.time.LocalDate;

public class RegistroPrestamo{
    private Libro libro;
    private Cliente cliente;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public RegistroPrestamo(Libro libro, Cliente cliente) {

        assert libro != null;
        assert cliente != null;

        this.libro = libro;
        this.cliente = cliente;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
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
