package Datos;
import Utilerias.ManipulacionDatos;

public class PuntoVenta implements ManipulacionDatos {
    private String direccion;
    private Sucursal aQuienReporta;
    private int cantidadItemsInventario;
    private Producto[] inventarioAsignado;

    public PuntoVenta() {
        direccion = null;
        aQuienReporta = null;
        cantidadItemsInventario = 0;
        inventarioAsignado = null;
    }

    public PuntoVenta(String direccion, Sucursal aQuienReporta, int cantidadItemsInventario, Producto[] inventarioAsignado) {
        this.direccion = direccion;
        this.aQuienReporta = aQuienReporta;
        this.cantidadItemsInventario = cantidadItemsInventario;
        this.inventarioAsignado = inventarioAsignado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Sucursal getaQuienReporta() {
        return aQuienReporta;
    }

    public void setaQuienReporta(Sucursal aQuienReporta) {
        this.aQuienReporta = aQuienReporta;
    }

    public int getCantidadItemsInventario() {
        return cantidadItemsInventario;
    }

    public void setCantidadItemsInventario(int cantidadItemsInventario) {
        this.cantidadItemsInventario = cantidadItemsInventario;
    }

    public Producto[] getInventarioAsignado() {
        return inventarioAsignado;
    }

    public void setInventarioAsignado(Producto[] inventarioAsignado) {
        this.inventarioAsignado = inventarioAsignado;
    }

    @Override
    public void leerDatos() {

    }

    @Override
    public void mostrarDatos() {

    }
}
