package bodegon;

import java.io.Serializable;

public class Platillo extends Menu implements Serializable{

    private String descripcion;
    private double precio;
    

    public Platillo(String descripcion, double precio) {
       //super(precio);
       this.descripcion = descripcion;
       this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String toString() {
        return "Platillo " + descripcion + ", precio : " + precio;
    }
    
    public String mostrarPlatillo(){
        return "Platillo " + descripcion;
    }

}
