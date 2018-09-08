import Personas.*;


public class Implementacion {

    public static void main(String[] args) {
        //PERSONAS-Cliente:
        final int NUMEROCLIENTES = 5; //Se cuenta el cero.
        Cliente clientes[] = new Cliente[NUMEROCLIENTES];

        for (int i = 0; i < NUMEROCLIENTES; i++) {
            System.out.println("ITERACION: " + i);
            clientes[i] = new Cliente();
            clientes[i].leerDatos();
            clientes[i].mostrarDatos();
            System.out.println();
        }
    }
}
