package com.biblioteca.persona;

/**
 * Empleado
 */
public class Empleado extends Persona{
    private Cargo cargo;

    public Empleado(String nombre, String apellido, int edad, Cargo cargo) {
        super(nombre, apellido, edad);
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}