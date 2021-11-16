package bodegon;

import java.io.Serializable;

public abstract class Persona implements Serializable{

    private String nombre;
    private String contraseña;
    private String codigo;

    public Persona(String nombre, String contraseña, String codigo) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    abstract boolean proceder(Sistema sistema);

}
