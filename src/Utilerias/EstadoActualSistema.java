package Utilerias;

public class EstadoActualSistema {
    private static int productosActuales;
    private static int productosActualesAcceso;

    private static int sucursalesActuales;
    private static int sucursalesActualesAcceso;


    private static int puntosActuales;
    private static int getPuntosActualesAcceso;

    public static int getProductosActuales() {
        return productosActuales;
    }

    public static void setProductosActuales(int productosActuales) {
        EstadoActualSistema.productosActuales = productosActuales;
    }

    public static int getProductosActualesAcceso() {
        return productosActualesAcceso;
    }

    public static void setProductosActualesAcceso(int productosActualesAcceso) {
        EstadoActualSistema.productosActualesAcceso = productosActualesAcceso;
    }

    public static int getSucursalesActuales() {
        return sucursalesActuales;
    }

    public static void setSucursalesActuales(int sucursalesActuales) {
        EstadoActualSistema.sucursalesActuales = sucursalesActuales;
    }

    public static int getSucursalesActualesAcceso() {
        return sucursalesActualesAcceso;
    }

    public static void setSucursalesActualesAcceso(int sucursalesActualesAcceso) {
        EstadoActualSistema.sucursalesActualesAcceso = sucursalesActualesAcceso;
    }

    public static int getPuntosActuales() {
        return puntosActuales;
    }

    public static void setPuntosActuales(int puntosActuales) {
        EstadoActualSistema.puntosActuales = puntosActuales;
    }

    public static int getGetPuntosActualesAcceso() {
        return getPuntosActualesAcceso;
    }

    public static void setGetPuntosActualesAcceso(int getPuntosActualesAcceso) {
        EstadoActualSistema.getPuntosActualesAcceso = getPuntosActualesAcceso;
    }

}
