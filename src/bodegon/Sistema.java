package bodegon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Sistema implements Serializable{

    private ArrayList<Persona> personas;
    private StockComandas sco;
    private Resumen re;
    private Menu me;

    public Sistema() {
        sco = new StockComandas();
        re = new Resumen();
        me = new Menu();
        personas = new ArrayList<>();
//        Administrador a = new Administrador("Juan", "admin", "ja01");
//        a.setM(me);
//        a.setSco(sco);
//        a.setR(re);
//        Cocinero c = new Cocinero("Carlos", "coci", "cc02");
//        c.setM(me);
//        Camarero ca = new Camarero("Roberto", "cama", "rc03");
//        ca.setSco(sco);
//        ca.setM(me);
//        ca.setR(re);
//        re.setSc(sco);
//        re.setM(me);
//        personas.add(a);
//        personas.add(c);
//        personas.add(ca);
    }
    
    public Sistema deSerializar(String a) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(a);
        ObjectInputStream o = new ObjectInputStream(f);
        Sistema s = (Sistema) o.readObject();
        o.close();
        f.close();
        return s;
    }

    public void serializar(String a) throws IOException {
        FileOutputStream f = new FileOutputStream(a);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();
    }

    public StockComandas getSco() {
        return sco;
    }

    public void setSco(StockComandas sco) {
        this.sco = sco;
    }

    public Resumen getRe() {
        return re;
    }

    public void setRe(Resumen re) {
        this.re = re;
    }

    public Menu getMe() {
        return me;
    }

    public void setMe(Menu me) {
        this.me = me;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    void arrancar() {
        boolean corriendo = true;
        while (corriendo) {
            Persona u = null;
            do {
                String codigo = EntradaSalida.leerPassword("Ingrese su código de acceso único");
                for (Persona p : personas) {
                    if (p.getCodigo().equals(codigo)) {
                        u = p;
                        break;
                    }
                }
                if (u == null) {
                    EntradaSalida.mostrarString("Código de acceso inexistente");
                }
            } while (u == null);
            corriendo = u.proceder(this);
        }
        EntradaSalida.mostrarString("Hasta mañana!");
    }

}
