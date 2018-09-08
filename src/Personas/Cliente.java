package Personas;

import Utilerias.ManipulacionDatos;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Cliente implements ManipulacionDatos {
    private String cedula;
    private String nombre;
    private static int numeroCliente = 0;

    public Cliente() {
        this.cedula = "";
        this.nombre = "";
    }

    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void resetNumeroClientes() {
        numeroCliente = 0;
    }

    //FUNCIONA
    @Override
    public void leerDatos() {
        String cedula;
        String nombre;
        String apellido;
        String identificacion;

        Scanner archivo;

        try {
            archivo = new Scanner(new File("Clientes.dat"));
            archivo.useDelimiter("\\s* \\s*");

            for (int i = 0; i < numeroCliente; i++) {
                archivo.nextLine();
            }

            numeroCliente++;

            cedula = archivo.next();
            this.setCedula(cedula);

            nombre = archivo.next();
            apellido = archivo.next();
            identificacion = nombre + " " + apellido;
            this.setNombre(identificacion);

        }
        catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo.");
        }
        catch (NoSuchElementException e) {
            System.out.println("Error en la carga de datos: Token fallido.");
        }

    }

    @Override
    public void mostrarDatos() {
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Cédula: " + this.getCedula());
    }
}
