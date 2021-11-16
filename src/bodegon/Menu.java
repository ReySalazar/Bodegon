package bodegon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable{

    ArrayList <String> platos;
    List <Menu> menus;
    ArrayList <Double> listaPrecios;
    ArrayList <String> listaDescripcion;
   
    public Menu(){
        menus = new ArrayList<>();
        platos = new ArrayList();
        listaPrecios = new ArrayList<>();
        listaDescripcion = new ArrayList<>();
    }

    public ArrayList<Double> getListaPrecios() {
        return listaPrecios;
    }

    public void setListaPrecios(ArrayList<Double> listaPrecios) {
        this.listaPrecios = listaPrecios;
    }
    
    public void agregarListaPrecios(double precio){
        listaPrecios.add(precio);
    }
    
    public double obtenerPrecio(int pos){
        double pre = listaPrecios.get(pos);
        return pre;
    }

    public ArrayList<String> getListaDescripcion() {
        return listaDescripcion;
    }

    public void setListaDescripcion(ArrayList<String> listaDescripcion) {
        this.listaDescripcion = listaDescripcion;
    }

    public String obtenerDescripcion(int pos){
        String desc = listaDescripcion.get(pos);
        return desc;
    }
    
    public void agregarDescripcion(String desc){
        listaDescripcion.add(desc);
    }  

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String obtenerListaMenu() {
        String lista = "";
        for (int i = 0; i < menus.size(); i++) {
            lista += "[" + (i + 1) + "] " + menus.get(i) + "\n";
        }
        return lista;
    }

    public int cantidadMenu() {

        return menus.size();

    }

    public void agregar(Menu m) {
        if (m != null) {
            menus.add(m);
        }
    }

    public ArrayList<String> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<String> platos) {
        this.platos = platos;
    }

    public void agregar(String p) {
        if (p != null) {
            platos.add(p);
        }
    }

    public String mostrarPlatos() {
        String lista1 = "";
        for (int i = 0; i < platos.size(); i++) {
            lista1 += "[" + (i + 1) + "] " + platos.get(i) + "\n";
        }
        return lista1;
    }

    public int obtenerCantidadPlato() {
        return platos.size();
    }

    @Override
    public String toString() {
        return "Menu{" + "platos=" + platos + ", menus=" + menus + ", precio=" +  '}';
    }

}
