package bodegon;

import java.io.Serializable;

public class Cocinero extends Persona implements Serializable{

//    private Menu m;
    private String plato;

    public Cocinero(String nombre, String contraseña, String codigo) {
        super(nombre, contraseña, codigo);
    }

//    public Menu getM() {
//        return m;
//    }
//
//    public void setM(Menu m) {
//        this.m = m;
//    }

    @Override
    boolean proceder(Sistema sistema) {

        boolean cerrar = false;
        while (!cerrar) {

            char op;
            do {
                op = EntradaSalida.leerChar(
                        "MENÚ COCINERO\n\n"
                        + "[1] Alta - Plato\n"
                        + "[2] Salir\n");
            } while (op < '1' || op > '2');
            if (op == '1') {
                do {
                    plato = EntradaSalida.leerString("Hoy cocinamos : ");
                    sistema.getMe().agregar(plato);
                    char c = EntradaSalida.leerChar("Agregar otro plato ( S / N)");
                    if (c == 'N' || c == 'n') {
                        cerrar = true;
                        EntradaSalida.mostrarString(sistema.getMe().mostrarPlatos());
                    }
                } while (!cerrar);
            } else {
                cerrar = true;
            }
        }
        return true;
    }
}
