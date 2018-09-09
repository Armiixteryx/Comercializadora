package Datos;
import Utilerias.EstadoActualSistema;
import Utilerias.ManipulacionDatos;
import Utilerias.StringToolbox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sucursal implements ManipulacionDatos {
    private String codigo;
    private String nombre;
    private String ciudad;

    public Sucursal() {
        codigo = "";
        nombre = "";
        ciudad = "";
    }

    public Sucursal(String codigo, String nombre, String ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public void leerDatos() {
        final int SUCURSAL_ACTUAL = EstadoActualSistema.getSucursalesActualesAcceso() + 1;
        String codigo;
        String nombre;
        String ciudad;
        Scanner archivo;

        try {
            archivo = new Scanner(new File("Sucursales.dat"));
            archivo.useDelimiter("\\s* \\s*");

            for (int i = 0; i < SUCURSAL_ACTUAL - 1; i++) {
                archivo.nextLine();
            }

            codigo = String.valueOf(StringToolbox.returnOnlyNumbers(archivo.next()));
            this.setCodigo(codigo);

            nombre = StringToolbox.uppercaseSplit(archivo.next());
            this.setNombre(nombre);

            ciudad = StringToolbox.uppercaseSplit(archivo.next());
            this.setCiudad(ciudad);

            archivo.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el archivo: Sucursales.dat");
        }

        EstadoActualSistema.setSucursalesActualesAcceso(SUCURSAL_ACTUAL);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Ciudad: " + this.getCiudad());
    }
}
