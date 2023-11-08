package com.biblioteca;

import java.util.ArrayList;
import java.util.Collection;

import com.biblioteca.persona.Cliente;
import com.biblioteca.persona.Empleado;

public class Biblioteca implements Prestamo{
    private Collection<Libro> libros;
    private Collection<RegistroPrestamo> prestamos;
    private Collection<RegistroPrestamo> prestados;
    private Empleado empleado;
    
    
    public Biblioteca(){
        this.libros = new ArrayList<>();
    }
    
    public Biblioteca(Collection<Libro> libros){
        this.libros = libros;
    }

    @Override
    public void crearPrestamo(Cliente cliente, Libro libro) {
        assert libro.getNumeroEjemplares() > 0 : "Ejemplares agotados";
        
        // reducir el numero ejemplares en 1, crear nuevo prestamo
        libro.setNumeroEjemplares(libro.getNumeroEjemplares()-1);
        RegistroPrestamo prestamoNuevo = new RegistroPrestamo(libro, cliente);
        cliente.agregarPrestamo(prestamoNuevo);
        this.prestamos.add(prestamoNuevo); // historico de prestamos
        this.prestados.add(prestamoNuevo); // actualmente prestados
    }

    @Override
    public void devolverPrestamo(RegistroPrestamo prestamo) {
        // buscar en lista 'prestados' una coincidencia
        // eliminarlo, y restaurar variables modificadas
        for (RegistroPrestamo prestado : prestados){
            if (prestado.equals(prestamo)){
                prestamo.getLibro().setNumeroEjemplares(prestamo.getLibro().getNumeroEjemplares()+1);
                prestamo.getCliente().removerPrestamo(prestamo);
                prestados.remove(prestamo);
            }
        }
    }

    public Collection<Libro> getLibros() {
        return libros;
    }
    public void setLibros(Collection<Libro> libros) {
        this.libros = libros;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public Collection<RegistroPrestamo> getPrestamos() {
        return prestamos;
    }
    
}
