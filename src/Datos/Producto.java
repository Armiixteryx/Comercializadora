package Datos;
import Utilerias.ManipulacionDatos;

public class Producto implements ManipulacionDatos {
    private int codigo;
    private String descripcion;
    private float costo;
    private static float porcentajeGanancia;
    private int existencia;
    private final int stockMinimo = 0;

    public Producto() {
        codigo = 0;
        descripcion = "";
        costo = 0f;
        porcentajeGanancia = 0f;
        existencia = 0;
    }

    public Producto(int codigo, String descripcion, float costo, float _porcentajeGanancia, int existencia) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
        porcentajeGanancia = _porcentajeGanancia;
        this.existencia = existencia;
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

    public float getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public void setPorcentajeGanancia(float _porcentajeGanancia) {
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

    }

    @Override
    public void mostrarDatos() {

    }
}
