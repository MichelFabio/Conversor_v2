package conversor.modelo;

import javax.swing.*;

public interface Convertible {

    double convertir();
    void setValorSalida();
    static boolean verificarEntradas(String entrada){
        if (!(entrada.matches("[0-9.]+")) || entrada == null) {
            return false;
        }
        return true;
    }

}
