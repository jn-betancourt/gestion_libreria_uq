package com.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

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
    public void devolverPrestamo(Libro libro, LocalDate fechaPrestamo) {
        // buscar en lista 'prestados' una coincidencia
        // eliminarlo, y restaurar variables modificadas

        Predicate<RegistroPrestamo> prestamoRegistro = r-> r.getLibro().equals(libro) && r.getFechaPrestamo().equals(fechaPrestamo);

        Optional<RegistroPrestamo> registro = prestados.stream().filter(prestamoRegistro).findAny();

        if (registro.isPresent()){
            registro.get().getLibro().setNumeroEjemplares(registro.get().getLibro().getNumeroEjemplares()+1);
            registro.get().getCliente().removerPrestamo(registro.get());
            registro.get().setFechaDevolucion(LocalDate.now());
            prestados.remove(registro.get());
        }
    }

    /*
     * Buscar libros por autor
     */
    public Collection<Libro> buscarLibrosAutor(Autor autor){
        Predicate<Libro> buscarAutor = l -> l.getAutor().equals(autor);
        Collection<Libro> librosCoinciden = libros.stream().filter(buscarAutor).toList();
        return librosCoinciden;
    }

    /*
     * Buscar libro por nombre
     */
    public Optional<Libro> buscarLibroNombre(String nombre){
        Predicate<Libro> nombreLibro = l-> l.getTitulo().equals(nombre);
        Optional<Libro> libro = libros.stream().filter(nombreLibro).findAny();
        return libro;
    }

    /* 
     * Devolver informe o historial de prestamos
     * basado en un libro
     */    
    public Collection<RegistroPrestamo> informePrestamosLibro(Libro libro){
        Predicate<RegistroPrestamo> registroEncontrado = r -> r.getLibro().equals(libro);
        Collection<RegistroPrestamo> informe = prestamos.stream().filter(registroEncontrado).toList();
        return informe;
    }

    /*
     * Registrar un libro 
     */
    public void registrarLibro(Libro libro){
        boolean condicion = buscarLibroDuplicado(libro);
        if (!condicion){
            libros.add(libro);
        }
    }

    /*
     *  Buscar un duplicado
     */
    private boolean buscarLibroDuplicado(Libro libro){
        Predicate<Libro> duplicado = l->l.getTitulo().equals(libro.getTitulo());
        boolean esDuplicado = libros.stream().anyMatch(duplicado);
        return esDuplicado;
    }
    
    /**
     * Registrar un nuevo cliente
     * */
    public Cliente registrarCliente(String nombre, String apellido, int edad, int numero){
        Cliente nuevoCliente = new Cliente(nombre, apellido, edad, numero);
        return nuevoCliente;
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
