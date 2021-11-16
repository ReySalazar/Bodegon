package bodegon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StockComandas implements Serializable{
//    Comanda c;
    List<Comanda> comandas;
    ArrayList<String> items;
    private double precioTotal = 0;

    public StockComandas() {
        comandas = new ArrayList<>();
        items = new ArrayList<>();
    }

//    public Comanda getC() {
//        return c;
//    }
//
//    public void setC(Comanda c) {
//        this.c = c;
//    }
        
    public String obtenerListaComandas() {
        String lista = "";
        for (int i = 0; i < comandas.size(); i++) {
            lista += "[" + (i + 1) + "] " + comandas.get(i) + "\n";
        }
        return lista;
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }

    public int cantidadMenu() {
        return comandas.size();
    }

    public void agregar(Comanda c) {
        if (c != null) {
            comandas.add(c);
        }
    }
    
    public String mostrardetalleComanda(int pos){
        String detalle;
        detalle = "COMANDA Nro: " + pos + 1 + "\n" +
                "Total consumo de la mesa nro: " + comandas.get(pos).getNroMesa() + "\n";
        for(int i = 0;i < comandas.get(pos).items.size();i++){
            detalle += comandas.get(pos).items.get(i) + "\n"; 
        }
        detalle += "Precio total : " + comandas.get(pos).getPrecio(); 
        return detalle;
    }
    
    public void generadorComanda(String s, String nroMesa, double precio) {      
        if (s.isEmpty()) {
            Comanda c = new Comanda(nroMesa, items, precioTotal);
            agregar(c);
            precioTotal = 0;
            items.clear();
            EntradaSalida.mostrarString("La comanda se ha generado con exito y se agregó al stock");
        } else {
            items.add(s);
            precioTotal += precio;
        }        
    }
}
