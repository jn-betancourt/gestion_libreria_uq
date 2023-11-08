package com.biblioteca.persona;

import java.util.ArrayList;
import java.util.Collection;

import com.biblioteca.RegistroPrestamo;

public class Cliente extends Persona{
    private int numero;
    private Collection<RegistroPrestamo> prestamos;

    public Cliente(String nombre, String apellido, int edad, int numero) {
        super(nombre, apellido, edad);
        this.numero = numero;
        this.prestamos = new ArrayList<>();
    }

    public Cliente(String nombre, String apellido, int edad, int numero, Collection<RegistroPrestamo> prestamos) {
        super(nombre, apellido, edad);
        this.numero = numero;
        this.prestamos = prestamos;
    }

    public void agregarPrestamo(RegistroPrestamo prestamo){
        this.prestamos.add(prestamo);
    }

    public void removerPrestamo(RegistroPrestamo prestamo){
        prestamos.remove(prestamo);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Collection<RegistroPrestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Collection<RegistroPrestamo> prestamos) {
        this.prestamos = prestamos;
    }
}