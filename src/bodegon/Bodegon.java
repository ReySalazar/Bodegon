package bodegon;

import java.io.IOException;

public class Bodegon {

    public static void main(String[] args) throws IOException {
        Sistema s = new Sistema();
        try {
            s = s.deSerializar("bodegon.txt");
            EntradaSalida.mostrarString("BIENVENDO AL SISTEMA BODEGÓN");
        } catch (IOException | ClassNotFoundException e) {
            EntradaSalida.mostrarString("CARGANDO SISTEMA 1ra VEZ");
            String usuario = EntradaSalida.leerString("Registre su usuario, Administrador");
            String password = EntradaSalida.leerPassword("Registre su contraseña, Administrador");
            String codigoAcceso = EntradaSalida.leerString("Registre su código de acceso, Administrador");
            Administrador a = new Administrador(usuario, password, codigoAcceso);
            s.getPersonas().add(a);
            a.setPersonas(s.getPersonas());
            EntradaSalida.mostrarString("Usted es el nuevo administrador, por favor logearse");
        }
        s.arrancar();
        s.serializar("bodegon.txt");
    }

}
 