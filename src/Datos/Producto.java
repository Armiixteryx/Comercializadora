package Datos;
import Utilerias.EstadoActualSistema;
import Utilerias.ManipulacionDatos;
import Utilerias.StringToolbox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Producto implements ManipulacionDatos {
    private int codigo;
    private String descripcion;
    private float costo;
    private static float porcentajeGanancia;
    private int existencia;
    private final int stockMinimo;

    public Producto() {
        codigo = 0;
        descripcion = "";
        costo = 0f;
        porcentajeGanancia = 0f;
        existencia = 0;
        stockMinimo = 0;
    }

    public Producto(int codigo, String descripcion, float costo, float _porcentajeGanancia, int existencia, int stockMinimo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
        porcentajeGanancia = _porcentajeGanancia;
        this.existencia = existencia;
        this.stockMinimo = stockMinimo;
    }

    public Producto(int stockMinimo) {
        codigo = 0;
        descripcion = "";
        costo = 0f;
        porcentajeGanancia = 0f;
        existencia = 0;
        this.stockMinimo = stockMinimo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public static float getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public static void setPorcentajeGanancia(float _porcentajeGanancia) {
        porcentajeGanancia = _porcentajeGanancia;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public boolean decrementarExistencia(int decremento) {
        if(existencia > decremento) {
            existencia -= decremento;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void leerDatos() {
        //Ya leidas: porcentajeGanancia, stockMinimo.
        //Sistema: Uso de getProductosActualesAcceso: Pre-incremento.
        final int PRODUCTO_ACTUAL = EstadoActualSistema.getProductosActualesAcceso() + 1;
        int codigo;
        String descripcion;
        float costo;
        int existencia;
        Scanner archivo;

        costo = 0;

        try {
            archivo = new Scanner(new File("Productos.dat"));
            archivo.useDelimiter("\\s* \\s*");

            //Posicionar lectura en la línea de la instancia actual.
            for (int i = 0; i < PRODUCTO_ACTUAL; i++) {
                archivo.nextLine();
            }

            codigo = StringToolbox.returnOnlyNumbers(archivo.next());
            this.setCodigo(codigo);

            descripcion = StringToolbox.uppercaseSplit(archivo.next());
            this.setDescripcion(descripcion);

            try {
                costo = Float.parseFloat(archivo.next());
                this.setCosto(costo);
            }
            catch (NumberFormatException e) {
                System.err.println("Error al convertir costo a Float.");
            }


            try {
                existencia = Integer.parseInt(archivo.next());
                this.setExistencia(existencia);
            }
            catch (NumberFormatException e) {
                System.err.println("Error al convertir existencia a Integer.");
            }

            archivo.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo: Productos.dat");
        }

        EstadoActualSistema.setProductosActualesAcceso(PRODUCTO_ACTUAL);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Descripción: " + this.getDescripcion());
        System.out.println("Costo: " + this.getCosto());
        System.out.println("Porcentaje de ganancia: " + getPorcentajeGanancia());
        System.out.println("Existencia: " + this.getExistencia());
        System.out.println("Stock mínimo: " + stockMinimo);
    }
}
