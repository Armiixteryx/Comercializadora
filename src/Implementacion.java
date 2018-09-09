import Datos.Producto;
import Datos.PuntoVenta;
import Datos.Sucursal;
import Personas.*;
import Utilerias.*;

public class Implementacion {

    public static void main(String[] args) {
        //Estado inicial del sistema:
        EstadoActualSistema.setProductosActuales(5);
        EstadoActualSistema.setSucursalesActuales(2);
        EstadoActualSistema.setPuntosActuales(2);

        Cliente[] clientes;
        Sucursal[] sucursales;
        Producto[] productos;
        PuntoVenta[] puntos;

        clientes = LecturaDatos.leerCliente();
        sucursales = LecturaDatos.leerSucursal();
        productos = LecturaDatos.leerProducto();
        puntos = LecturaDatos.leerPuntoVenta();
    }
}
