package bodegon;

import java.io.Serializable;
import java.util.ArrayList;

public class Camarero extends Persona implements Serializable{

    private Menu m;
    private String nroMesa;
    private StockComandas sco;
    private Resumen r;
    private Comanda c;
//    private double precioTotal = 0;
//    ArrayList<String> items = new ArrayList();

    public Camarero(String nombre, String contraseña, String codigo) {
        super(nombre, contraseña, codigo);        
    }

    public Resumen getR() {
        return r;
    }

    public void setR(Resumen r) {
        this.r = r;
    }

    public StockComandas getSco() {
        return sco;
    }

    public void setSco(StockComandas sco) {
        this.sco = sco;
    }

    public Menu getM() {
        return m;
    }

    public void setM(Menu m) {
        this.m = m;
    }

    public String getNroMesa() {
        return nroMesa;
    }

    public void setNroMesa(String nroMesa) {
        this.nroMesa = nroMesa;
    }

    @Override
    boolean proceder(Sistema sistema) {

        boolean cerrar = false;
        while (!cerrar) {

            int op;
            if (sistema.getMe().getMenus().size() > 0) {
                do {
                    op = EntradaSalida.leerInt(
                            "MENÚ CAMARERO\n\n"
                            + "[0] Salir \n"
                            + "[1] Tomar orden\n");
                } while (op < 0 || op > sistema.getMe().cantidadMenu());
                if (op != 0) {
                    nroMesa = EntradaSalida.leerString("Ingrese el N° de mesa ");
                    int op1 = -1;
                    while (op1 != 0) {
                        do {
                            op1 = EntradaSalida.leerInt(
                                    "MENU de hoy\n"
                                    + "[0] SALIR\n"
                                    + sistema.getMe().obtenerListaMenu());
                        } while (op1 < 0 || op1 > sistema.getMe().cantidadMenu());
                        if (op1 != 0) {
                           sistema.getSco().generadorComanda(sistema.getMe().obtenerDescripcion(op1 - 1), nroMesa, sistema.getMe().obtenerPrecio(op1 -1));
                           sistema.getRe().sumarItem(op1 - 1);
                        }
                        char cop = EntradaSalida.leerChar("Agrega algo más (S/N) ?");
                        if (cop == 'N' || cop == 'n') {
                            sistema.getSco().generadorComanda("", nroMesa, 0);
                            op1 = 0;                           
                        }
                    }
                    EntradaSalida.mostrarString(sistema.getSco().obtenerListaComandas());
                } else {
                    cerrar = true;
                }
            } else {
                EntradaSalida.mostrarString("El menú se encuentra vacio");
                cerrar = true;
            }
        }
        return true;
    }
    
//    private void generadorComanda(String s, String nroMesa, double precio) {      
//        if (s.isEmpty()) {
//            Comanda c = new Comanda(nroMesa, items, precioTotal);
//            sco.agregar(c);
//            precioTotal = 0;
//            items.clear();
//            EntradaSalida.mostrarString("La comanda se ha generado con exito y se agregó al stock");
//        } else {
//            items.add(s);
//            precioTotal += precio;
//        }        
//    }

}
