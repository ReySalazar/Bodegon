package bodegon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Comanda implements Serializable{

    List<Comanda> comandas;
    StockComandas sco;
    private String nroMesa;
    private double precio;
    ArrayList<String> items;
//    private double precioTotal = 0;
   
    public Comanda(String nroMesa, ArrayList items, double precio) {        
        this.nroMesa = nroMesa;
        this.items = items;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public StockComandas getSco() {
        return sco;
    }

    public void setSco(StockComandas sco) {
        this.sco = sco;
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }

    public String getNroMesa() {
        return nroMesa;
    }

    public void setNroMesa(String nroMesa) {
        this.nroMesa = nroMesa;
    }
    
//     public void generadorComanda(String s, String nroMesa, double precio) {      
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
    
    @Override
    public String toString() {
        return " nroMesa:  " + nroMesa + " - Total consumo: " + precio;
    }
}
