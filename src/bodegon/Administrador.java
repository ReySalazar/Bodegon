package bodegon;

import java.io.Serializable;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;

public class Administrador extends Persona implements Serializable {

    private Menu m;
    private Comanda c;
    private Resumen r;
    private Cocinero co;
    private StockComandas sco;
    private ArrayList<Persona> personas;

    public Administrador(String nombre, String contraseña, String codigo) {
        super(nombre, contraseña, codigo);
        m = new Menu();
        r = new Resumen();
    }

    public StockComandas getSco() {
        return sco;
    }

    public void setSco(StockComandas sco) {
        this.sco = sco;
    }

    public Cocinero getCo() {
        return co;
    }

    public void setCo(Cocinero co) {
        this.co = co;
    }

    public Menu getM() {
        return m;
    }

    public void setM(Menu m) {
        this.m = m;
    }

    public Comanda getC() {
        return c;
    }

    public void setC(Comanda c) {
        this.c = c;
    }

    public Resumen getR() {
        return r;
    }

    public void setR(Resumen r) {
        this.r = r;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    @Override
    boolean proceder(Sistema sistema) {
        boolean seguirCorriendo = true;
        boolean cerrar = false;

        while (!cerrar) {
            int op;
            do {
                op = EntradaSalida.leerInt(
                        "MENÚ ADMINISTRADOR\n\n"
                        + "[0] Salir del sistema\n"
                        + "[1] Cerrar Sesión\n"
                        + "[2] Alta Bebidas\n"
                        + "[3] Asignar precio de platillo\n"
                        + "[4] Mostrar recaudacion\n"
                        + "[5] Ítem más vendido\n"
                        + "[6] Alta empleado");
            } while (op < 0 || op > 6);
            if (op != 0 && op != 1) {
                switch (op) {
                    case 2:
                        int op1 = -1;
                        while (op1 != 0) {
                            char c;
                            String tipo = EntradaSalida.leerString("Tipo de bebida a cargar en el menú");
                            double precio = Double.parseDouble(EntradaSalida.leerString("Precio de la bebida: "));
                            sistema.getMe().agregar(new Bebida(tipo, precio));
                            sistema.getMe().agregarListaPrecios(precio);
                            sistema.getMe().agregarDescripcion(tipo);
                            sistema.getRe().iniciaItem(0);
                            c = EntradaSalida.leerChar("Agregar otra bebida (S/N)");
                            if (c == 'n' || c == 'N') {
                                op1 = 0;
                            }
                            EntradaSalida.mostrarString(sistema.getMe().obtenerListaMenu());
                        }
                        break;
                    case 3:
                        int indice;
                        do {
                            indice = EntradaSalida.leerInt(""
                                    + "Lista de Platos cargados por el Chef\n"
                                    + "[0] Salir\n"
                                    + sistema.getMe().mostrarPlatos());
                        } while (indice < 0 || indice > sistema.getMe().obtenerCantidadPlato());
                        if (indice > 0) {
                            double pre = parseDouble(EntradaSalida.leerString("Precio a colocar al plato elejido\n"));
                            String desc = sistema.getMe().getPlatos().get(indice - 1);
                            sistema.getMe().agregar(new Platillo(desc, pre));
                            sistema.getMe().agregarListaPrecios(pre);
                            sistema.getMe().agregarDescripcion(desc);
                            sistema.getRe().iniciaItem(0);
                            sistema.getMe().getPlatos().remove(indice - 1);
                            EntradaSalida.mostrarString(sistema.getMe().obtenerListaMenu());
                        }
                        break;
                    case 4:
                        EntradaSalida.mostrarString("La recaudación total hasta el momento es: \n" + "$/ "
                                + sistema.getRe().acumularRecaudacion(sistema) + " pesos.");
                        break;
                    case 5:
                        sistema.getRe().devuelveItemMasVendido(sistema);
                        break;
                    case 6:
                        String nom,pass,codAcceso;
                        boolean termine = false;
                        int cat;
                        while (!termine) {
                            do {
                                 cat = EntradaSalida.leerInt(
                                        "ALTA EMPLEADO\n\n"
                                        + "[1] Cocinero\n"
                                        + "[2] Camarero\n"
                                        + "[3] SALIR");
                            } while (cat < 1 || cat > 3);
                            switch (cat) {
                                case 1:
                                    nom = EntradaSalida.leerString("COCINERO\nIngrese nombre");
                                    pass = EntradaSalida.leerString("COCINERO\nIngrese su contraseña");
                                    codAcceso = EntradaSalida.leerString("COCINERO\nIngrese código de acceso");
                                    Cocinero cocinero = new Cocinero(nom, pass, codAcceso);                                   
                                    sistema.getPersonas().add(cocinero);
                                    EntradaSalida.mostrarString("Usuario agregado correctamente");
                                    break;
                                case 2:
                                    nom = EntradaSalida.leerString("CAMARERO\nIngrese nombre");
                                    pass = EntradaSalida.leerString("CAMARERO\nIngrese su contraseña");
                                    codAcceso = EntradaSalida.leerString("CAMARERO\nIngrese código de acceso");
                                    Camarero camarero = new Camarero(nom, pass, codAcceso);
                                    sistema.getPersonas().add(camarero);
                                    EntradaSalida.mostrarString("Usuario agregado correctamente");
                                    break;
                                case 3:
                                    termine = true;
                                    break;
                            }
                        }

                }
            } else if (op == 1) {
                cerrar = true;
                EntradaSalida.mostrarString("Hasta pronto!");
            } else {
                cerrar = true;
                seguirCorriendo = false;
            }
        }
        return seguirCorriendo;
    }

}
