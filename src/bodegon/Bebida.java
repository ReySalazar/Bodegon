package bodegon;

import java.io.Serializable;

public class Bebida extends Menu implements Serializable{

    private String tipo;
    private double precio;

    public Bebida(String tipo, double precio) {
        //super(precio);
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Bebida " + tipo + ", precio : " + precio;
    }

}
