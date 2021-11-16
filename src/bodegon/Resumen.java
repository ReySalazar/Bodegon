package bodegon;

import java.io.Serializable;
import java.util.ArrayList;

public class Resumen implements Serializable{

    private double recaudacion = 0;
    ArrayList <Integer> itemMasVendido;
    StockComandas sc;
    Comanda co;
    Menu m;

    public Resumen() {
        itemMasVendido = new ArrayList();
    }

    public Menu getM() {
        return m;
    }

    public void setM(Menu m) {
        this.m = m;
    }
    
    public StockComandas getSc() {
        return sc;
    }

    public void setSc(StockComandas sc) {
        this.sc = sc;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public ArrayList<Integer> getItemMasVendido() {
        return itemMasVendido;
    }

    public void setItemMasVendido(ArrayList<Integer> itemMasVendido) {
        this.itemMasVendido = itemMasVendido;
    }
    
    public void sumarItem(int pos){
        int valor;
        valor = itemMasVendido.get(pos) + 1;
        itemMasVendido.set(pos, valor);
    } 
    
    public void iniciaItem(int valor){
        itemMasVendido.add(valor);
    }
    
    public void devuelveItemMasVendido(Sistema s){
       int max = Integer.MIN_VALUE;
       int pos = 0;
       for(int i=0; i<itemMasVendido.size(); i++){
           if(itemMasVendido.get(i) > max){
               max = itemMasVendido.get(i);
               pos = i;
           }
       }
       EntradaSalida.mostrarString(s.getMe().obtenerDescripcion(pos) + " -- es hasta el momemto el ítem más vendido\n" + max + " Unidades");
    }
    public int mostrarItemMasVendido(int i){
        int mas=0;
        return mas;
    }

    public double acumularRecaudacion(Sistema s) {
        double recTotal = 0;
        for(int i = 0;i<s.getSco().getComandas().size();i++){
            recTotal += s.getSco().getComandas().get(i).getPrecio();
        } 
        return recTotal;
    }

}
