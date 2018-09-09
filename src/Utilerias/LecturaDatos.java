package Utilerias;

import Datos.*;
import Personas.Cliente;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LecturaDatos {
    public static Cliente[] leerCliente() {
        Cliente[] clientes = new Cliente[5];

        for (int i = 0; i < 5; i++) {
            clientes[i] = new Cliente();
            clientes[i].leerDatos();
        }

        return clientes;
    }

    public static PuntoVenta[] leerPuntoVenta() {
        final int CANTIDAD_PUNTOS = EstadoActualSistema.getPuntosActuales();

        PuntoVenta[] puntos = new PuntoVenta[CANTIDAD_PUNTOS];
        for (int i = 0; i < CANTIDAD_PUNTOS; i++) {
            puntos[i] = new PuntoVenta();
        }

        return puntos;
    }

    public static Sucursal[] leerSucursal() {
        final int CANTIDAD_SUCURSALES = EstadoActualSistema.getSucursalesActuales();

        Sucursal[] sucursales = new Sucursal[CANTIDAD_SUCURSALES];
        for (int i = 0; i < CANTIDAD_SUCURSALES; i++) {
            sucursales[i] = new Sucursal();
            sucursales[i].leerDatos();
        }

        return sucursales;
    }

    public static Producto[] leerProducto() {
        final int CANTIDAD_PRODUCTOS = 5;
        Producto[] productos = new Producto[CANTIDAD_PRODUCTOS];
        float porcentajeGanancia;
        int stockMinimo;
        String stockAux;
        Scanner archivo;

        try {
            archivo = new Scanner(new File("Productos.dat"));
            archivo.useDelimiter("\\s* \\s*");

            porcentajeGanancia = archivo.nextInt();

            //Debido a que stockMinimo es final, he tenido que obtener su valor
            //antes de crear los productos.
            //Después ya puedo cargar los demás datos sin inconveniente.
            archivo.nextLine(); //Consumir el salto de línea.
            for (int i = 0; i < CANTIDAD_PRODUCTOS; i++) {
                stockAux = StringToolbox.ReadLastWord(archivo.nextLine());
                try {
                    stockMinimo = Integer.parseInt(stockAux);
                    productos[i] = new Producto(stockMinimo);
                    productos[i].leerDatos();
                }
                catch (NumberFormatException e) {
                    System.err.println("Error al convertir stock a número:");
                }
            }
            archivo.close();

            Producto.setPorcentajeGanancia(porcentajeGanancia);
        }
        catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo: Productos.dat");
        }
        catch (InputMismatchException e) {
            System.err.println("Error al leer el porcentaje de ganancia.");
        }

        return productos;
    }
}
